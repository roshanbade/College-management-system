package com.cms.exception;

public class CombinationFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4107820580668022241L;

	String faculty;
	String courseCode;
	int semester;
	
	public CombinationFailedException( String courseCode, String faculty, int semester) {
		this.faculty = faculty;
		this.courseCode = courseCode;
		this.semester = semester;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
}
