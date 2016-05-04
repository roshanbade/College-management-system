package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cms.domain.Attendance;
import com.cms.domain.AttendanceId;
import com.cms.domain.CourseOffered;
import com.cms.domain.Faculty;
import com.cms.domain.Instructor;
import com.cms.exception.HandleConstraintViolationException;
import com.cms.repository.InstructorRepository;
import com.cms.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService{
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Override
	public void addInstructor(Instructor instructor) {
		try {
		instructorRepository.addInstructor(instructor);
		} catch (DataIntegrityViolationException e) {
			throw new HandleConstraintViolationException(instructor.getInstructorId());
		}
	}

	@Override
	public Instructor getInstructorById(String id) {
		return instructorRepository.getInstructorById(id);
	}

	@Override
	public void updateInstructor(Instructor instructor) {
		instructorRepository.updateInstructor(instructor);
	}

	@Override
	public List<Instructor> getAllInstructors() {
		return instructorRepository.getAllInstructors();
	}

	@Override
	public List<Instructor> getInstructorsByDepartment(String department) {
		List <Instructor> allInstructors = instructorRepository.getInstructorsByDepartment(department);
		//System.out.println("All instructors :" + allInstructors);
		List<Instructor> requiredInstructors = new ArrayList<Instructor>();
		Instructor tempInstructor;
		
		for (Instructor instructor: allInstructors) {
			for (Faculty faculty: instructor.getListOfFaculty()) {
				//System.out.println("-------------------Faculty name : " + faculty.getFacultyName());
				if (faculty.getFacultyName().contains(department)) {
					tempInstructor = new Instructor();
					tempInstructor.setFirstName(instructor.getFirstName());
					tempInstructor.setLastName(instructor.getLastName());
					tempInstructor.setInstructorId(instructor.getInstructorId());
					tempInstructor.getListOfFaculty().add(faculty);
					for (CourseOffered courseOffered : instructor.getListOfCourseOffered()) {
						if (courseOffered.getFaculty().contains(department)) {							
							tempInstructor.getListOfCourseOffered().add(courseOffered);					
						}
					}
					requiredInstructors.add(tempInstructor);
				}
			}
		}
		return requiredInstructors;
	}

	@Override
	public void addAttendance(Attendance attendance) {
		instructorRepository.addAttendance(attendance);
		
	}

	@Override
	public void updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Attendance> getAttendance(AttendanceId attendanceId) {
		return instructorRepository.getAttendance(attendanceId);
	}
}
