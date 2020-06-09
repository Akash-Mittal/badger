package com.am.innovations.badger;

public interface API {
	String BASE_PATH = "/V_1.0/badges";

	String GET_ALL_REPOS_BADGES_BY_USER_NAME = "/all/repos/{username:^[a-zA-Z_-]*$}";
	String URL_PLACE_HOLDER_REPO_NAME = "REPONAME";
	String URL_PLACE_HOLDER_USER_NAME = "USERNAME";
}