package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cms.domain.CourseInfo;
import com.cms.domain.CourseOffered;
import com.cms.domain.ExamGrades;
import com.cms.domain.FullCourseInfo;
import com.cms.domain.StudentInfo;
import com.cms.exception.HandleCourseConstrainViolation;
import com.cms.repository.CourseRepository;
import com.cms.service.CourseService;
import com.cms.service.StudentService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public void addCourseInfo(CourseInfo courseInfo) {
		courseRepository.addCourseInfo(courseInfo);
	}

	@Override
	public void addCourseOffered(CourseOffered courseOffered) {
		courseRepository.addCourseOffered(courseOffered);
	}
	
	public void fullCourseInfo(FullCourseInfo fullCourseInfo) {
		CourseInfo courseInfo = new CourseInfo();
		CourseOffered courseOffered = new CourseOffered();
		
		courseInfo.setCredit(fullCourseInfo.getCredit());
		courseInfo.setCourseCode(fullCourseInfo.getCourseId());
		courseInfo.setCourseName(fullCourseInfo.getCourseName());		
	
		courseOffered.setCourseCode(courseInfo);
		courseOffered.setFaculty(fullCourseInfo.getFaculty());
		courseOffered.setSemester(fullCourseInfo.getSemester());
		
		courseInfo.getListOfCourseOffered().add(courseOffered);
		courseOffered.setCourseCode(courseInfo);
		try {
			addCourseInfo(courseInfo);
			addCourseOffered(courseOffered);
		} catch (DataIntegrityViolationException e) {
			System.out.println("Exception caught");
			throw new HandleCourseConstrainViolation(courseInfo.getCourseCode());
		}
		
		List<StudentInfo> studentInfo = studentService.getStudentByFaculty(courseOffered.getFaculty());
		
		for (StudentInfo student: studentInfo) {
			ExamGrades examGrades = new ExamGrades();
			examGrades.setCourseCode(courseInfo.getCourseCode());
			examGrades.setCourseName(courseInfo.getCourseName());
			studentService.addGrade(examGrades);
			student.getListOfExamGrades().add(examGrades);
			studentService.updateStudent(student);
		}
	}

	@Override
	public List<FullCourseInfo> getCourseInfoByDepartment(String department) {
		List<Object[]> fullCourseInfo = courseRepository.getCourseInfoByDepartment(department);
		List<FullCourseInfo> listOfCourse = new ArrayList<FullCourseInfo>();
		FullCourseInfo course;
		
		for (Object[] aRow: fullCourseInfo) {
			course = new FullCourseInfo();
			course.setCourseId(aRow[0].toString());
			course.setCourseName(aRow[1].toString());
			course.setCredit(Integer.parseInt(aRow[2].toString()));
			course.setFaculty(aRow[3].toString());
			course.setSemester(Integer.parseInt(aRow[4].toString()));
			listOfCourse.add(course);
		}
		return listOfCourse;
	}

	@Override
	public void deleteCourseById(String id) {
		
	}

	@Override
	public List<CourseOffered> getCourseOfferedById(String id) {
		return courseRepository.getCourseOfferedById(id);
	}

	@Override
	public void updateCourse(FullCourseInfo course) {
		courseRepository.updateCourse(course);
	}

	@Override
	public CourseInfo getCourseInfoById(String id) {
		return courseRepository.getCourseInfoById(id);
	}

	@Override
	public void updateCourseOffered(CourseOffered courseOffered) {
		courseRepository.updateCourseOffered(courseOffered);
		
	}

	@Override
	public List<CourseOffered> getCourseOfferedByDepartment(String department) {
		return courseRepository.getCourseOfferedByDepartment(department);
	}
}
