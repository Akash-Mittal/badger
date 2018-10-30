package com.am.innovations.badger;

public interface API {
	String BASE_PATH = "/V_1.0/badges";
	String GET_ALL_REPOS_CLONE_COMMANDS_BY_USER_NAME = "/all/repos/clone/{user}";
	String GET_ALL_REPOS_BADGES_BY_USER_NAME = "/all/repos/badges/{user}";
	String GET_ALL_REPOS_GITHUB_BADGES_BY_USERNAME = "/all/repos/badges/github/{user}";
	String GET_ALL_REPOS_SONAR_BADGES_BY_USERNAME = "/all/repos/badges/sonar/{user}";
	String URL_PLACE_HOLDER_REPO_NAME = "REPONAME";
	String URL_PLACE_HOLDER_USER_NAME = "USERNAME";
}