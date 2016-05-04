package com.cms.repository;

import java.util.List;

import com.cms.domain.Faculty;

public interface FacultyRepository {
	public void addFaculty(Faculty faculty);
	public Faculty getFacultyByName(String facultyName);
	public void updateFaculty(Faculty faculty);
	public List<Faculty> getAllFaculty();
}
