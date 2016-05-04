package com.cms.exception;

public class HandleCourseConstrainViolation extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9144820915322993075L;
	private String courseCode;
	
	public HandleCourseConstrainViolation(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
}
