package com.cms.exception;

public class NoDepartmentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7615347410269288715L;
	
	private String departmentName;
	
	public NoDepartmentException(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}		
}
