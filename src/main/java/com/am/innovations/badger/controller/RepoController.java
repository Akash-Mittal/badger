package com.am.innovations.badger.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.am.innovations.badger.configurations.yml.BadgesConfiguration;

@RestController
@RequestMapping(API.BASE_PATH)
public class RepoController {

	Logger logger = LoggerFactory.getLogger(RepoController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BadgesConfiguration badgesConfiguration;

	@GetMapping(API.GET_ALL_REPOS_CLONE_COMMANDS_BY_USER_NAME)
	public String getAllRepoCloneCommandsByUserName(@PathVariable(value = "user") String user)
			throws URISyntaxException {
		ResponseEntity<GitRepoResponse[]> response = callGitHub(user);
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(response.getBody()).forEach(repo -> {
			stringBuilder.append("git clone git@github.com:" + user + "/" + repo.getName() + ".git").append("\n");
		});
		return stringBuilder.toString();
	}

	@GetMapping(API.GET_ALL_REPOS_GITHUB_BADGES_BY_USERNAME)
	public String getAllGithubBadgesByUserName(@NonNull @PathVariable(value = "user") String user)
			throws URISyntaxException {
		ResponseEntity<GitRepoResponse[]> response = callGitHub(user);
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(response.getBody()).forEach(repo -> {
			stringBuilder.append(badgesConfiguration.getGithub().getIssues().replace("REPONAME", repo.getName()))
					.append("\n");
			stringBuilder.append(badgesConfiguration.getGithub().getForks().replace("REPONAME", repo.getName()))
					.append("\n");
			stringBuilder.append(badgesConfiguration.getGithub().getLicense().replace("REPONAME", repo.getName()))
					.append("\n");
			stringBuilder.append(badgesConfiguration.getGithub().getStars().replace("REPONAME", repo.getName()))
					.append("\n");
		});
		return stringBuilder.toString();
	}

	@GetMapping(API.GET_ALL_REPOS_SONAR_BADGES_BY_USERNAME)
	public String getAllSonarBadgesByUserName(@PathVariable(value = "user") String user) throws URISyntaxException {
		ResponseEntity<GitRepoResponse[]> response = callGitHub(user);
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(response.getBody()).forEach(repo -> {
			stringBuilder.append(badgesConfiguration.getSonar().getMeasure().replace("REPONAME", repo.getName()))
					.append("\n");
		});
		return stringBuilder.toString();
	}

	private ResponseEntity<GitRepoResponse[]> callGitHub(String userName) throws URISyntaxException {
		URI uri = new URI(badgesConfiguration.getConfig().getGithubreposapiurl().replace("userName", userName));
		logger.info("Calling {}", uri.toString());
		RequestEntity<?> request1 = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<GitRepoResponse[]> response = restTemplate.exchange(request1, GitRepoResponse[].class);
		return response;
	}

}

interface API {
	String BASE_PATH = "/V_1.0/badges";
	String GET_ALL_REPOS_CLONE_COMMANDS_BY_USER_NAME = "/all/repos/clone/{user}";
	String GET_ALL_REPOS_BADGES_BY_USER_NAME = "/all/repos/badges/{user}";
	String GET_ALL_REPOS_GITHUB_BADGES_BY_USERNAME = "/all/repos/badges/github/{user}";
	String GET_ALL_REPOS_SONAR_BADGES_BY_USERNAME = "/all/repos/badges/sonar/{user}";
}
