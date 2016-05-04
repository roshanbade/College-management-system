package com.cms.service;

import java.util.List;

import com.cms.domain.Attendance;
import com.cms.domain.AttendanceId;
import com.cms.domain.Instructor;

public interface InstructorService {
	public void addInstructor(Instructor instructor);
	public Instructor getInstructorById(String id);
	public void updateInstructor(Instructor instructor);
	public List<Instructor> getAllInstructors();
	public List<Instructor> getInstructorsByDepartment(String department);
	
	public void addAttendance(Attendance attendance);
	public void updateAttendance(Attendance attendance);
	public List<Attendance> getAttendance(AttendanceId attendanceId);
	
}
