package com.cg.ovms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.NOT_FOUND)//when record not found
public class ResourceNotFound extends RuntimeException{

	public ResourceNotFound(String msg) {
		super(msg);
	}
}