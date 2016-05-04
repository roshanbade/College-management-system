package com.cms.exception;

public class HandleConstraintViolationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152716835633001292L;
	
	private String id;
	
	public HandleConstraintViolationException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
