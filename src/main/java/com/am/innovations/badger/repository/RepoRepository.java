package com.am.innovations.badger.repository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.am.innovations.badger.API;
import com.am.innovations.badger.configurations.yml.BadgesConfiguration;
import com.am.innovations.badger.dto.git.GitRepoResponse;
import com.am.innovations.badger.enums.OPS;
import com.am.innovations.badger.exception.RestClientException;
import com.am.innovations.badger.service.RestClient;

@Component
public class RepoRepository {

	Logger logger = LoggerFactory.getLogger(RepoRepository.class);

	@Autowired
	private BadgesConfiguration badgesConfiguration;

	@Autowired
	private RestClient restClient;

	public Optional<ResponseEntity<GitRepoResponse[]>> getAllRepoBadgesByUserName(final String user, OPS ops) {
		Optional<ResponseEntity<GitRepoResponse[]>> response = Optional.empty();
		try {
			response = restClient.get(badgesConfiguration.getConfig().getGithubreposapiurl()
					.replace(API.URL_PLACE_HOLDER_USER_NAME, user));
		} catch (RestClientException e) {
			logger.error("Exception While Calling API: {}", e);
		}
		return response;

	}

}
