package com.cms.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.domain.Faculty;
import com.cms.repository.FacultyRepository;

@Repository
@Transactional
public class FacultyRepositoryImpl implements FacultyRepository{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addFaculty(Faculty faculty) {
		sessionFactory.getCurrentSession().save(faculty);		
	}

	@Override
	public Faculty getFacultyByName(String facultyName) {
		return (Faculty) sessionFactory.getCurrentSession().get(Faculty.class, facultyName);
	}

	@Override
	public void updateFaculty(Faculty faculty) {
		sessionFactory.getCurrentSession().update(faculty);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();		
	}

	@Override
	public List<Faculty> getAllFaculty() {
		return sessionFactory.getCurrentSession().createQuery("from Faculty").list();
	}

}
