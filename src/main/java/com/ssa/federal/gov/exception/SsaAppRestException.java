package com.ssa.federal.gov.exception;

public class SsaAppRestException extends RuntimeException {

	public SsaAppRestException() {
		System.out.println("SsaAppRestException::0 param Constructor");
	}

	public SsaAppRestException(String msg) {
		super(msg);
	}
}
