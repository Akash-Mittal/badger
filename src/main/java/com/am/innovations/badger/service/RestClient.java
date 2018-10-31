package com.am.innovations.badger.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.am.innovations.badger.dto.git.GitRepoResponse;

@Component
public class RestClient {

	Logger logger = LoggerFactory.getLogger(RestClient.class);

	@Autowired
	private RestTemplate restTemplate;

	public Optional<ResponseEntity<GitRepoResponse[]>> get(final String url, final String... optional) {
		URI uri = null;
		ResponseEntity<GitRepoResponse[]> response = null;
		try {
			uri = new URI(url);
			logger.info("Calling {}", uri.toString());
			final RequestEntity<?> request1 = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
			response = restTemplate.exchange(request1, GitRepoResponse[].class);
		} catch (URISyntaxException | RestClientException e) {
			logger.error("Exception While Calling API: {}", e);
		}
		return Optional.ofNullable(response);
	}
}
