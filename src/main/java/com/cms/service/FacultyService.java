package com.cms.service;

import java.util.List;

import com.cms.domain.Faculty;

public interface FacultyService {
	public void addFaculty(Faculty faculty);
	public Faculty getFacultyByName(String facultyName);
	public void updateFaculty(Faculty faculty);
	public List<Faculty> getAllFaculty();
	public List<String> getAllFacultyName();
}
