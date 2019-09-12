package com.comakeit.mrbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class MRBSUnAuthorizedException extends RuntimeException {

	private static final long serialVersionUID = 401L;

}
