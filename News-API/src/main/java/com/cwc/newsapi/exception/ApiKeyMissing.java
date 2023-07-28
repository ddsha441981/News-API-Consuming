package com.cwc.newsapi.exception;

public class ApiKeyMissing extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ApiKeyMissing() {
		
	}
	
	public ApiKeyMissing(String msg) {
		super(msg);
	}

}
