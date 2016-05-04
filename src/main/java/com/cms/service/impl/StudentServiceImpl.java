package com.cms.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.domain.Account_Admin;
import com.cms.domain.CourseOffered;
import com.cms.domain.ExamGrades;
import com.cms.domain.Fee;
import com.cms.domain.FeePayment;
import com.cms.domain.StudentInfo;
import com.cms.exception.HandleConstraintViolationException;
import com.cms.repository.StudentRepository;
import com.cms.service.CourseService;
import com.cms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Override
	public void addStudent(StudentInfo student) {		
		List<CourseOffered> courseOffered = courseService.getCourseOfferedByDepartment(student.getFaculty());
		List<ExamGrades> listOfExamGrade = new ArrayList<ExamGrades>();
		
		for (CourseOffered course : courseOffered) {
			ExamGrades examGrade = new ExamGrades();
			examGrade.setCourseCode(course.getCourseCode().getCourseCode());
			examGrade.setCourseName(course.getCourseCode().getCourseName());
			addGrade(examGrade);
			listOfExamGrade.add(examGrade);			
		}
		student.setListOfExamGrades(listOfExamGrade);
		try {
		studentRepository.addStudent(student);
		} catch (Exception e) {
			throw new HandleConstraintViolationException("" + student.getStudentId());
		}
		setAccountAdmin(student.getStudentId());
	}

	@Override
	public List<Account_Admin> getAccountAdmin() {
		return studentRepository.getAccountAdmin();
	}

	@Override
	public void setAccountAdmin(int studentId) {
		studentRepository.setAccountAdmin(studentId);
	}

	@Override
	public StudentInfo getStudentById(int studentId) {
		return studentRepository.getStudentById(studentId);
	}

	@Override
	public void deleteAccountAdmin(int studentId) {
		studentRepository.deleteAccountAdmin(studentId);
	}

	@Override
	public List<StudentInfo> getStudentInfo() {
		return studentRepository.getStudentInfo();
	}

	@Override
	public void updateStudent(StudentInfo student) {
		studentRepository.updateStudent(student);
	}

	@Override
	public void addStudentFee(Fee fee) {
		BigDecimal totalCost = fee.getTotalCost();
		BigDecimal perSem = totalCost.divide(new BigDecimal(8));
		fee.setFirst(perSem);
		fee.setSecond(perSem);
		fee.setThird(perSem);
		fee.setFourth(perSem);
		fee.setFifth(perSem);
		fee.setSixth(perSem);
		fee.setSeventh(perSem);
		fee.setEighth(perSem);
		
		studentRepository.addStudentFee(fee);
		
	}

	@Override
	public Fee getFeeById(int studentId) {
		return studentRepository.getFeeById(studentId); 
	}

	@Override
	public void addFeePayment(FeePayment feePayment) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		feePayment.setPaidDate(date);
		studentRepository.addFeePayment(feePayment);
	}

	@Override
	public void updateFee(Fee fee) {
		studentRepository.updateFee(fee);
		
	}

	@Override
	public int getCurrentSemester(StudentInfo student) {
		int semester = 0;
		
		Date currentDate = new Date();
		Date joinDate = student.getJoinDate();

		DateTime dt1 = new DateTime(joinDate);
		DateTime dt2 = new DateTime(currentDate);

		int days = Days.daysBetween(dt1, dt2).getDays();
		

		if (days <= 180) {
			semester = 1; 
		} else if (days > 180 && days <= 360) {
			semester = 2;
		} else if (days > 360 && days <= 540) {
			semester = 3;
		} else if (days > 540 && days <= 720) {
			semester = 4;
		} else if (days > 720 && days <= 900) {
			semester = 5;
		} else if (days > 900 && days <= 1080) {
			semester = 6;
		} else if (days > 1080 && days <= 1260) {
			semester = 7;
		} else if (days > 1260 && days <= 1440) {
			semester = 8;
		}
		
		return semester;		
	}

	@Override
	public List<StudentInfo> getStudentByFaculty(String faculty) {
		List<StudentInfo> allStudents = getStudentInfo();
		
		List<StudentInfo> students = new ArrayList<StudentInfo>();
		
		for (StudentInfo student: allStudents) {
			if (student.getFaculty().contains(faculty)) {
				students.add(student);
			}
		}
		
		return students;
	}

	@Override
	public void addGrade(ExamGrades examGrades) {
		studentRepository.addGrade(examGrades);
	}

	@Override
	public void updateGrade(ExamGrades examGrades) {
		studentRepository.updateGrade(examGrades);
	}
}
