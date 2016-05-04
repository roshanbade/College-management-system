package com.cms.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class FullCourseInfo {
	
	@Size(min=1, max=10, message="{size.FullCourseInfo.courseId}")
	private String courseId;
	
	@Size(min=1, max=50, message="{size.FullCourseInfo.courseName}")	
	private String courseName;
	
	@Min(value=1, message="{min.FullCourseInfo.credit}")	
	private int credit;
	
	@Size(min=1, max=50, message="{size.FullCourseInfo.faculty}")	
	private String faculty;
	
	@Min(value=1, message="{min.FullCourseInfo.semester}")
	@Max(value=8, message="{max.FullCourseInfo.semester}")
	private int semester;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
}
