package com.cms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CourseOffered implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8077617941564772927L;
	
	@Id @GeneratedValue
	private int rowId;
	
	private String faculty;
	private int semester;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<Instructor> listOfInstructorCourse = new ArrayList<Instructor>();
	
	@ManyToOne
	private Attendance attendanceInCourse;	
	
	@ManyToOne()
	private CourseInfo courseCode;
	
	public Attendance getAttendanceInCourse() {
		return attendanceInCourse;
	}

	public void setAttendanceInCourse(Attendance attendanceInCourse) {
		this.attendanceInCourse = attendanceInCourse;
	}

	public List<Instructor> getListOfInstructorCourse() {
		return listOfInstructorCourse;
	}

	public void setListOfInstructorCourse(List<Instructor> listOfInstructorCourse) {
		this.listOfInstructorCourse = listOfInstructorCourse;
	}


	public List<Instructor> getListOfInstructor() {
		return listOfInstructorCourse;
	}

	public void setListOfInstructor(List<Instructor> listOfInstructor) {
		this.listOfInstructorCourse = listOfInstructor;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
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

	public CourseInfo getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(CourseInfo courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return courseCode.getCourseName();
	}
	
	
}