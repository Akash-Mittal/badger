package com.am.innovations.badger.service;

import java.net.URI;
import java.net.URISyntaxException;

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
import com.am.innovations.badger.enums.OPS;

@Service
public class RepoService {
	Logger logger = LoggerFactory.getLogger(RepoService.class);

	@Autowired
	private BadgesConfiguration badgesConfiguration;

	@Autowired
	private RestTemplate restTemplate;

	public String getAllRepoBadgesByUserName(final String user, OPS ops) throws URISyntaxException {
		final ResponseEntity<GitRepoResponse[]> response = callGitHub(user);
		return ops.apply(response, badgesConfiguration);

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
