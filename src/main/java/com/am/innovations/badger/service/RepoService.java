package com.am.innovations.badger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.innovations.badger.configurations.yml.BadgesConfiguration;
import com.am.innovations.badger.enums.OPS;
import com.am.innovations.badger.repository.RepoRepository;

@Service
public class RepoService {
	Logger logger = LoggerFactory.getLogger(RepoService.class);

	@Autowired
	private BadgesConfiguration badgesConfiguration;

	@Autowired
	private RepoRepository repoRepository;

	public String getAllRepoBadgesByUserName(final String user, OPS ops) {
		StringBuilder builder = new StringBuilder();
		repoRepository.getAllRepoBadgesByUserName(user, ops).ifPresentOrElse(val -> {
			builder.append(ops.apply(val, badgesConfiguration));
		}, () -> {
			builder.append("User Not Found!!");
		});
		return builder.toString();

	}

}
