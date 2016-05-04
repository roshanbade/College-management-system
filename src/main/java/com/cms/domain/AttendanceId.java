package com.cms.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Embeddable
public class AttendanceId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1447029076694578599L;
	
	private int year;
	private int month;
	private int date;
	
	@Size(min=1, max= 10, message="{size.AttendanceId.courseId}")
	private String courseId;
	@Size(min=1, max= 50, message="{size.AttendanceId.faculty}")
	private String faculty;
	@Min(value=1, message="{min.AttendanceId.semester}")
	@Max(value=8, message="{max.AttendanceId.semester}")
	private int semester;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
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
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
}
