package com.cms.repository.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.domain.Attendance;
import com.cms.domain.AttendanceId;
import com.cms.domain.Instructor;
import com.cms.domain.StudentInfo;
import com.cms.repository.InstructorRepository;

@Repository
@Transactional
public class InstructorRepositoryImpl implements InstructorRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void addInstructor(Instructor instructor) {
		sessionFactory.getCurrentSession().save(instructor);
		
	}

	@Override
	@Transactional
	public Instructor getInstructorById(String id) {
		return (Instructor) sessionFactory.getCurrentSession().get(Instructor.class, id);
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor instructor) {
		sessionFactory.getCurrentSession().update(instructor);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Instructor> getInstructorsByDepartment(String department) {
		return (List<Instructor>) sessionFactory.getCurrentSession().createQuery("from Instructor").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Instructor> getAllInstructors() {
		return (List<Instructor>) sessionFactory.getCurrentSession().createQuery("from Instructor").list();
	}

	@Override
	public void addAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().save(attendance);
	}

	@Override
	public void updateAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().update(attendance);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	@Override
	public List<Attendance> getAttendanceByStudentId() {
		
		return null;
	}

	@Override
	public List<Attendance> getAttendance(AttendanceId attendanceId) {
		System.out.println(attendanceId.getCourseId());
		System.out.println(attendanceId.getFaculty());
		System.out.println(attendanceId.getYear());
		System.out.println(attendanceId.getSemester());
		
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Attendance a where a.attendanceId.courseId = :courseId AND a.attendanceId.faculty = :faculty AND a.attendanceId.semester = :semester AND a.attendanceId.year= :year");
		query.setString("faculty", attendanceId.getFaculty());
		query.setString("courseId", attendanceId.getCourseId());
		query.setInteger("semester", attendanceId.getSemester());
		query.setInteger("year", attendanceId.getYear());
		
		List<Attendance> list = query.list();
		return list;
		//System.out.println("Attendance received----- = " + list.size());
		
		/*for (Attendance attendance: list) {
			System.out.println(attendance.getAttendanceId().getCourseId());
			System.out.println(attendance.getAttendanceId().getFaculty());
			System.out.println(attendance.getAttendanceId().getSemester());
			System.out.println(attendance.getAttendanceId().getYear());
			System.out.println(attendance.getAttendanceId().getMonth());
			System.out.println(attendance.getAttendanceId().getDate());
			
			Set studentId = attendance.getListOfStudents().keySet();
			System.out.println(studentId);
			
		}*/
	}
}
