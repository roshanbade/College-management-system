package com.cms.service;

import java.util.List;

import com.cms.domain.CourseInfo;
import com.cms.domain.CourseOffered;
import com.cms.domain.FullCourseInfo;

public interface CourseService {
	public void addCourseInfo(CourseInfo courseInfo);
	public void addCourseOffered(CourseOffered courseOffered);
	public void fullCourseInfo(FullCourseInfo fullCourseInfo);
	public List<FullCourseInfo> getCourseInfoByDepartment(String department);
	public CourseInfo getCourseInfoById(String id);
	public List<CourseOffered> getCourseOfferedByDepartment(String department);
	public void deleteCourseById(String id);
	public List<CourseOffered> getCourseOfferedById(String id);
	public void updateCourse(FullCourseInfo course);
	public void updateCourseOffered(CourseOffered courseOffered);
}
