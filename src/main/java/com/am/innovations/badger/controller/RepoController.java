package com.am.innovations.badger.controller;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.am.innovations.badger.API;
import com.am.innovations.badger.dto.git.GitRepoResponse;
import com.am.innovations.badger.service.RepoService;

@RestController
@RequestMapping(API.BASE_PATH)
public class RepoController {

	Logger logger = LoggerFactory.getLogger(RepoController.class);

	@Autowired
	private RepoService repoService;

	@GetMapping(API.GET_ALL_REPOS_CLONE_COMMANDS_BY_USER_NAME)
	public String getAllRepoCloneCommandsByUserName(@PathVariable(value = "user") String user)
			throws URISyntaxException {
		ResponseEntity<GitRepoResponse[]> response = repoService.callGitHub(user);
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(response.getBody()).forEach(repo -> {
			stringBuilder.append("git clone git@github.com:" + user + "/" + repo.getName() + ".git").append("\n");
		});
		return stringBuilder.toString();
	}

}
