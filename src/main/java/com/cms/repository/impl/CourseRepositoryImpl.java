package com.cms.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.domain.CourseInfo;
import com.cms.domain.CourseOffered;
import com.cms.domain.FullCourseInfo;
import com.cms.repository.CourseRepository;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void addCourseInfo(CourseInfo courseInfo) {
		sessionFactory.getCurrentSession().save(courseInfo);
	}

	@Override
	public void addCourseOffered(CourseOffered courseOffered) {
		sessionFactory.getCurrentSession().save(courseOffered);
	}
	
	//@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCourseInfoByDepartment(String department) { 
		Query query = sessionFactory.getCurrentSession().createQuery("select c.courseCode, c.courseName, c.credit, co.faculty, co.semester from CourseOffered co join co.courseCode c with co.faculty= :department");
		query.setString("department", department);
		List<Object[]> course = query.list();
		
		return course;
		
	}

	@Override
	public CourseInfo getCourseInfoById(String id) {
		return (CourseInfo)sessionFactory.getCurrentSession().get(CourseInfo.class, id);
		//sessionFactory.getCurrentSession().delete(course);
	}

	@Override
	public CourseOffered deleteCourseOfferedById(String id) {
		String hql = "delete from CourseOffered c where c.courseCode.courseCode = :codeId ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("codeId", id);
		query.executeUpdate();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseOffered> getCourseOfferedById(String id) {
		String hql="from CourseOffered c where c.courseCode.courseCode= :courseId";		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("courseId", id);
		return (List<CourseOffered>) query.list();
	}

	@Override
	public void updateCourse(FullCourseInfo course) {
		List<CourseOffered> courseOffered = getCourseOfferedById(course.getCourseId());
		CourseInfo courseInfo = getCourseInfoById(course.getCourseId());
		
		courseOffered.get(0).setSemester(course.getSemester());
		courseInfo.setCredit(course.getCredit());
		
		sessionFactory.getCurrentSession().update(courseOffered.get(0));
		sessionFactory.getCurrentSession().update(courseInfo);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	@Override
	public void updateCourseOffered(CourseOffered courseOffered) {
		sessionFactory.getCurrentSession().update(courseOffered);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseOffered> getCourseOfferedByDepartment(String department) {
		List<CourseOffered> allCourseOffered;
		allCourseOffered = sessionFactory.getCurrentSession().createQuery("from CourseOffered").list();
		List<CourseOffered> requiredCourse = new ArrayList<CourseOffered>();
		
		for (CourseOffered course:allCourseOffered) {
			if (course.getFaculty().contains(department)) {
				requiredCourse.add(course);
			}
		}
		System.out.println("Required list = "+ requiredCourse);
		return requiredCourse;
	}
}
