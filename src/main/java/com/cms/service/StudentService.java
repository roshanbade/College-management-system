package com.cms.service;

import java.util.List;

import com.cms.domain.Account_Admin;
import com.cms.domain.CourseInfo;
import com.cms.domain.CourseOffered;
import com.cms.domain.ExamGrades;
import com.cms.domain.Fee;
import com.cms.domain.FeePayment;
import com.cms.domain.StudentInfo;

public interface StudentService {
	public void addStudent(StudentInfo student);
	public void addStudentFee(Fee fee);
	public void addFeePayment(FeePayment feePayment);
	public void addGrade(ExamGrades examGrades);
	
	public List<Account_Admin> getAccountAdmin();
	public void setAccountAdmin(int studentId);
	public StudentInfo getStudentById(int studentId);
	public Fee getFeeById(int studentId);
	public void deleteAccountAdmin(int studentId);
	public List<StudentInfo> getStudentInfo();
	public void updateStudent(StudentInfo student);
	public void updateFee(Fee fee);
	public void updateGrade(ExamGrades examGrades);
	
	public int getCurrentSemester(StudentInfo student);
	public List<StudentInfo> getStudentByFaculty(String faculty);
	
}
