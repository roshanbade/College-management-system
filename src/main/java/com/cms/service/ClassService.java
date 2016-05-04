package com.cms.service;

import java.util.List;

import com.cms.domain.Classroom;

public interface ClassService {
	public void addClass(Classroom classroom);
	public void updateClass(Classroom classroom);
	public List<Classroom> getClassroom();
	public Classroom getClassByName(String className);
	
}
