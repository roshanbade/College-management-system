package com.cms.repository;

import java.util.List;

import com.cms.domain.Account_Admin;
import com.cms.domain.ExamGrades;
import com.cms.domain.Fee;
import com.cms.domain.FeePayment;
import com.cms.domain.StudentInfo;

public interface StudentRepository {
	public void addStudent(StudentInfo student);
	public void addStudentFee(Fee fee);
	public void addFeePayment(FeePayment feePayment);
	
	public void addGrade(ExamGrades examGrades);

	//public String getStudentByAttribute(int StudentId, String attribute);
	public List<Account_Admin> getAccountAdmin();
	public void setAccountAdmin(int studentId);
	
	public void deleteAccountAdmin(int studentId);
	
	public StudentInfo getStudentById(int studentId);
	public List<StudentInfo> getStudentInfo();
	public Fee getFeeById(int studentId);
	
	void updateStudent(StudentInfo student);
	public void updateFee(Fee fee);
	public void updateGrade(ExamGrades examGrades);
}
