package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.domain.Faculty;
import com.cms.repository.FacultyRepository;
import com.cms.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Override
	public void addFaculty(Faculty faculty) {
		facultyRepository.addFaculty(faculty);
	}

	@Override
	public Faculty getFacultyByName(String facultyName) {
		return facultyRepository.getFacultyByName(facultyName);
	}

	@Override
	public void updateFaculty(Faculty faculty) {
		facultyRepository.updateFaculty(faculty);
		
	}

	@Override
	public List<Faculty> getAllFaculty() {
		return facultyRepository.getAllFaculty();
	}
	
	public List<String> getAllFacultyName() {
		List<String> names = new ArrayList<String>();
		for (Faculty faculty : getAllFaculty()) {
			names.add(faculty.getFacultyName());
		}
		return names;
	}

}
