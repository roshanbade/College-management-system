package com.cms.repository;

import java.util.List;

import com.cms.domain.CourseInfo;
import com.cms.domain.CourseOffered;
import com.cms.domain.FullCourseInfo;

public interface CourseRepository {
	public void addCourseInfo(CourseInfo courseInfo);
	public void addCourseOffered(CourseOffered courseOffered);
	
	public List<Object[]> getCourseInfoByDepartment(String department);
	public CourseInfo getCourseInfoById(String id);
	public List<CourseOffered> getCourseOfferedById(String id);
	public List<CourseOffered> getCourseOfferedByDepartment(String department);
	
	public CourseOffered deleteCourseOfferedById(String id);
	
	public void updateCourse(FullCourseInfo course);
	public void updateCourseOffered(CourseOffered courseOffered);
	
}
