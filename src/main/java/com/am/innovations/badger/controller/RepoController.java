package com.am.innovations.badger.controller;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.am.innovations.badger.API;
import com.am.innovations.badger.enums.OPS;
import com.am.innovations.badger.service.RepoService;

@RestController
@RequestMapping(API.BASE_PATH)
public class RepoController {

	Logger logger = LoggerFactory.getLogger(RepoController.class);

	@Autowired
	private RepoService repoService;

	@GetMapping(API.GET_ALL_REPOS_BADGES_BY_USER_NAME)
	public String getBadgesByUserName(@NonNull @PathVariable(value = "user") String user,
			@RequestParam("facility") OPS ops) throws URISyntaxException {
		return repoService.getAllRepoBadgesByUserName(user, ops);
	}

}
