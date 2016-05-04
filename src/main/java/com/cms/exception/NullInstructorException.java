package com.cms.exception;

public class NullInstructorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3809922734246946018L;

	private String instructorId;
	
	public NullInstructorException(String instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorId() {
		return instructorId;
	}
	
}
