package com.am.innovations.badger.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.am.innovations.badger.exception.DataException;
import com.am.innovations.badger.exception.RestClientException;
import com.am.innovations.badger.exception.ServiceException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ServiceException.class, DataException.class, RestClientException.class })
	protected ResponseEntity<String> handleConflict(RuntimeException ex, WebRequest request) {
		ResponseEntity<String> response = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return response;
	}
}
