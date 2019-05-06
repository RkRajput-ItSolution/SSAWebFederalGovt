
package com.ssa.federal.gov.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class SSAAppSsnNotFoundRestExceptionMapper {

	public SSAAppSsnNotFoundRestExceptionMapper() {
		System.out.println("SSNNotFoundExceptionMapper.SSNNotFoundExceptionMapper()");
	}

	@ExceptionHandler(value = { SsaAppRestException.class })
	public ResponseEntity<ApiError> exceptionHandler() {
		ApiError apiError = new ApiError();
		apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		apiError.setErrorDesc("InValid Ssn Number Please Try Again....!!");
		apiError.setDate(new Date());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
	}
}
