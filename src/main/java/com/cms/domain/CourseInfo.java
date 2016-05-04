package com.cms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CourseInfo {
	@Id
	private String courseCode;
	private String courseName;
	private int credit;
	
	@OneToMany(mappedBy="courseCode")
	List<CourseOffered> listOfCourseOffered = new ArrayList<CourseOffered>();
	
	public List<CourseOffered> getListOfCourseOffered() {
		return listOfCourseOffered;
	}

	public void setListOfCourseOffered(List<CourseOffered> listOfCourseOffered) {
		this.listOfCourseOffered = listOfCourseOffered;
	}

	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
}
