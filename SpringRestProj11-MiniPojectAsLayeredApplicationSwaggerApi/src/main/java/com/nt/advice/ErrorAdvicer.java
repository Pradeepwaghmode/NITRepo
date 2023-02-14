package com.nt.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.Exception.ActorNotFound;
import com.nt.model.ErrorDetails;

@RestControllerAdvice
public class ErrorAdvicer {

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleActorNotFoundException(ActorNotFound anf) {
		System.out.println("ErrorAdvicer.handleActorNotFoundException()");
		ErrorDetails ed = new ErrorDetails(anf.getMessage(), "500", LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleAllException(Exception e) {
		System.out.println("ErrorAdvicer.handleAllException()");
		ErrorDetails ed = new ErrorDetails(e.getMessage(), "500", LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
