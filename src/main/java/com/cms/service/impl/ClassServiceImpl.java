package com.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.domain.Classroom;
import com.cms.repository.ClassRepository;
import com.cms.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	ClassRepository classRepository;
	
	@Override
	public void addClass(Classroom classroom) {
		classRepository.addClass(classroom);
	}

	@Override
	public void updateClass(Classroom classroom) {
		classRepository.updateClass(classroom);
	}

	@Override
	public List<Classroom> getClassroom() {
		return classRepository.getClassroom();
	}

	@Override
	public Classroom getClassByName(String className) {
		return classRepository.getClassByName(className);
	}

}
