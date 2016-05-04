package com.cms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRegistry;

@Entity
public class Instructor {
	@Id
	@Size(min=1, max=50, message="{size.Instructor.instructorId}")
	@Pattern(regexp="i[0-9]+", message="{pattern.Instructor.instructorId}" )
	private String instructorId;
	
	@Size(min=1, max=50, message="{size.Instructor.firstName}")
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy="listOfInstructorCourse", fetch=FetchType.EAGER)
	List<CourseOffered> listOfCourseOffered = new ArrayList<CourseOffered>();
	
	@ManyToMany(mappedBy="listOfInstructorFaculty", fetch=FetchType.EAGER)
	List<Faculty> listOfFaculty = new ArrayList<Faculty>();
	
	@ManyToOne
	private Attendance attendanceInInstructor;
	
	public Attendance getAttendanceInInstructor() {
		return attendanceInInstructor;
	}
	public void setAttendanceInInstructor(Attendance attendanceInInstructor) {
		this.attendanceInInstructor = attendanceInInstructor;
	}
	public List<Faculty> getListOfFaculty() {
		return listOfFaculty;
	}
	public void setListOfFaculty(List<Faculty> listOfFaculty) {
		this.listOfFaculty = listOfFaculty;
	}
	public List<CourseOffered> getListOfCourseOffered() {
		return listOfCourseOffered;
	}
	public void setListOfCourseOffered(List<CourseOffered> listOfCourseOffered) {
		this.listOfCourseOffered = listOfCourseOffered;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
