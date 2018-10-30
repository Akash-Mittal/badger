package com.am.innovations.badger.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.am.innovations.badger.API;
import com.am.innovations.badger.configurations.yml.BadgesConfiguration;
import com.am.innovations.badger.dto.git.GitRepoResponse;

@Service
public class RepoService {
	Logger logger = LoggerFactory.getLogger(RepoService.class);

	@Autowired
	private BadgesConfiguration badgesConfiguration;

	@Autowired
	private RestTemplate restTemplate;

	public String getAllGithubBadgesByUserName(final String user) throws URISyntaxException {
		final ResponseEntity<GitRepoResponse[]> response = callGitHub(user);
		final StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(response.getBody()).forEach(repo -> {
			stringBuilder.append(
					badgesConfiguration.getGithub().getIssues().replace(API.URL_PLACE_HOLDER_REPO_NAME, repo.getName()))
					.append("\n");
			stringBuilder.append(
					badgesConfiguration.getGithub().getForks().replace(API.URL_PLACE_HOLDER_REPO_NAME, repo.getName()))
					.append("\n");
			stringBuilder.append(badgesConfiguration.getGithub().getLicense().replace(API.URL_PLACE_HOLDER_REPO_NAME,
					repo.getName())).append("\n");
			stringBuilder.append(
					badgesConfiguration.getGithub().getStars().replace(API.URL_PLACE_HOLDER_REPO_NAME, repo.getName()))
					.append("\n");
		});
		return stringBuilder.toString();
	}

	public String getAllSonarBadgesByUserName(final String user) throws URISyntaxException {
		final ResponseEntity<GitRepoResponse[]> response = callGitHub(user);
		final StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(response.getBody()).forEach(repo -> {
			stringBuilder.append(
					badgesConfiguration.getSonar().getMeasure().replace(API.URL_PLACE_HOLDER_REPO_NAME, repo.getName()))
					.append("\n");
		});
		return stringBuilder.toString();
	}

	public ResponseEntity<GitRepoResponse[]> callGitHub(final String userName) throws URISyntaxException {
		final URI uri = new URI(badgesConfiguration.getConfig().getGithubreposapiurl()
				.replace(API.URL_PLACE_HOLDER_USER_NAME, userName));
		logger.info("Calling {}", uri.toString());
		final RequestEntity<?> request1 = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		final ResponseEntity<GitRepoResponse[]> response = restTemplate.exchange(request1, GitRepoResponse[].class);
		return response;
	}

}
