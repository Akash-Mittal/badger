package com.am.innovations.badger.repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.am.innovations.badger.API;
import com.am.innovations.badger.client.RestClient;
import com.am.innovations.badger.configurations.yml.BadgesConfiguration;
import com.am.innovations.badger.dto.git.GitRepoResponse;
import com.am.innovations.badger.exception.RestClientException;

@Component
public class RepoRepository {

	Logger logger = LoggerFactory.getLogger(RepoRepository.class);

	@Autowired
	private BadgesConfiguration badgesConfiguration;

	@Autowired
	private RestClient restClient;

	@Cacheable("users")
	public Optional<ResponseEntity<GitRepoResponse[]>> getAllRepoBadgesByUserName(final String user) {
		Optional<ResponseEntity<GitRepoResponse[]>> response = Optional.empty();
		logger.info("User: {} Not Found in Cache", user);
		try {
			response = restClient.get(badgesConfiguration.getConfig().getGithubreposapiurl()
					.replace(API.URL_PLACE_HOLDER_USER_NAME, user));
		} catch (RestClientException e) {
			logger.error("Exception While Calling API: {}", e);
		}
		return response;
	}

	@CachePut("users")
	@Async
	public void getAllRepoBadgesByUserNameAndPutInCache(final String user) {
		Optional<ResponseEntity<GitRepoResponse[]>> response = Optional.empty();
		logger.info("User: {},Getting and Updating it to Cache Asynchronously", user);
		try {
			response = restClient.get(badgesConfiguration.getConfig().getGithubreposapiurl()
					.replace(API.URL_PLACE_HOLDER_USER_NAME, user));
			CompletableFuture.completedFuture(response);
		} catch (RestClientException e) {
			logger.error("Exception While Calling API: {}", e);
		}

	}

}
