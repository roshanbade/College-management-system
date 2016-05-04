package com.cms.exception;


public class StudentNotFound extends RuntimeException{
	
	private static final long serialVersionUID = -694354952032299587L;
		
	private String error;
	private int id;

	public StudentNotFound(String error, int id) {
		this.error = error;
		this.id = id;
	}
	
	public String getStudentError(){
		return error;
	}
	public int getStudentId() {
		return id;
	}
}