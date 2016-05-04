package com.cms.exception;

public class HandleNullFeeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3141397876032487546L;
	
	private String studentId;
	
	public HandleNullFeeException(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}
}
