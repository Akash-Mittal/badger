package com.am.innovations.badger.controller;

import java.net.URISyntaxException;

import javax.validation.constraints.Size;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(API.BASE_PATH)
@Api
public class RepoController {

	Logger logger = LoggerFactory.getLogger(RepoController.class);

	@Autowired
	private RepoService repoService;

	@GetMapping(API.GET_ALL_REPOS_BADGES_BY_USER_NAME)
	@ApiOperation(value = "Get Badges URL for all Github Repositories by username", notes = "", response = String.class)
	public String getBadgesByUserName(
			@NonNull @Size(min = 3, max = 50) @PathVariable(value = "username") String username,
			@RequestParam("facility") OPS ops) throws URISyntaxException {
		return repoService.getAllRepoBadgesByUserName(username, ops);
	}

}
