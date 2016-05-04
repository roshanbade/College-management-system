package com.cms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Faculty {
	@Id
	@Size(min=1, max=50, message="{size.Faculty.facultyName}")
	private String facultyName;
	
	private String facultyCoordinatorId;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Instructor> listOfInstructorFaculty = new ArrayList<Instructor>();

	public String getFacultyCoordinatorId() {
		return facultyCoordinatorId;
	}

	public void setFacultyCoordinatorId(String facultyCoordinatorId) {
		this.facultyCoordinatorId = facultyCoordinatorId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public List<Instructor> getListOfInstructor() {
		return listOfInstructorFaculty;
	}

	public void setListOfInstructor(List<Instructor> listOfInstructor) {
		this.listOfInstructorFaculty = listOfInstructor;
	}

	@Override
	public String toString() {
		return facultyName;
	}
	
	
}
