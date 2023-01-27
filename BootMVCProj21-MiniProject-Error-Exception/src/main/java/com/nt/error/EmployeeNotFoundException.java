package com.nt.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.UNPROCESSABLE_ENTITY )
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String msg) {
		super(msg);
		System.out.println("=======================================================");
		System.out.println("EmployeeNotFoundException.EmployeeNotFoundException()");
	}
}
