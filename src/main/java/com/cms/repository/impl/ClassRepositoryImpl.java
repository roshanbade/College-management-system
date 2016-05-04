package com.cms.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.domain.Classroom;
import com.cms.repository.ClassRepository;

@Repository
@Transactional
public class ClassRepositoryImpl implements ClassRepository{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addClass(Classroom classroom) {
		sessionFactory.getCurrentSession().save(classroom);
	}

	@Override
	public void updateClass(Classroom classroom) {
		sessionFactory.getCurrentSession().update(classroom);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> getClassroom() {
		return (List<Classroom>) sessionFactory.getCurrentSession().createQuery("from Classroom").list();
	}

	@Override
	public Classroom getClassByName(String className) {
		return (Classroom)sessionFactory.getCurrentSession().get(Classroom.class, className) ;
	}
}
