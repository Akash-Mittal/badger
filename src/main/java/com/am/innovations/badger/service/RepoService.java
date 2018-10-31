package com.am.innovations.badger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.am.innovations.badger.configurations.yml.BadgesConfiguration;
import com.am.innovations.badger.enums.OPS;
import com.am.innovations.badger.exception.DataException;
import com.am.innovations.badger.repository.RepoRepository;
import com.am.innovations.validations.Validators;

@Service
public class RepoService {
	Logger logger = LoggerFactory.getLogger(RepoService.class);

	@Autowired
	private BadgesConfiguration badgesConfiguration;

	@Autowired
	private RepoRepository repoRepository;

	public String getAllRepoBadgesByUserName(final String user, OPS ops) {
		StringBuilder builder = new StringBuilder();
		try {
			repoRepository.getAllRepoBadgesByUserName(user, ops).ifPresentOrElse(val -> {
				if (Validators.checkIfEqualsTo.test(val.getStatusCode().value(), HttpStatus.OK.value())) {
					builder.append(ops.apply(val, badgesConfiguration));
				} else {
					builder.append(val.getBody());
				}
			}, () -> {
				builder.append("Not Found !!");
			});
		} catch (DataException e) {
			logger.error("Exception While Getting Data: {}", e);
		}
		return builder.toString();

	}

}
