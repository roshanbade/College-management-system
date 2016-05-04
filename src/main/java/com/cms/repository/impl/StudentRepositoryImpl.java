package com.cms.repository.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cms.domain.Account_Admin;
import com.cms.domain.ExamGrades;
import com.cms.domain.Fee;
import com.cms.domain.FeePayment;
import com.cms.domain.StudentInfo;
import com.cms.exception.HandleConstraintViolationException;
import com.cms.repository.StudentRepository;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void addStudent(StudentInfo student) {		
		sessionFactory.getCurrentSession().save(student);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Account_Admin> getAccountAdmin() {
		List<Account_Admin> students;
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Account_Admin");
		
		students = (List<Account_Admin>) query.list();
		
		return students;
	}

	@Override
	public void setAccountAdmin(int studentId) {
		Account_Admin accountAdmin = new Account_Admin();
		accountAdmin.setStudentId(studentId);
		sessionFactory.getCurrentSession().save(accountAdmin);
		
	}

	@Override
	public StudentInfo getStudentById(int studentId) {
		
		return (StudentInfo) sessionFactory.getCurrentSession().get(StudentInfo.class, studentId);
		
	}

	@Override
	public void deleteAccountAdmin(int studentId) {
		Account_Admin accountAdmin = (Account_Admin)sessionFactory.getCurrentSession().get(Account_Admin.class, studentId);
		sessionFactory.getCurrentSession().delete(accountAdmin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentInfo> getStudentInfo() {
		return (List<StudentInfo>) sessionFactory.getCurrentSession().createQuery("from StudentInfo").list();
	}

	@Override
	public void updateStudent(StudentInfo student) {
		sessionFactory.getCurrentSession().update(student);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
		
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void addStudentFee(Fee fee) {
		sessionFactory.getCurrentSession().save(fee);		
	}

	@Override
	public Fee getFeeById(int studentId) {
		return (Fee)sessionFactory.getCurrentSession().get(Fee.class, studentId);
		
	}

	@Override
	public void addFeePayment(FeePayment feePayment) {
		sessionFactory.getCurrentSession().save(feePayment);
	}

	@Override
	public void updateFee(Fee fee) {
		sessionFactory.getCurrentSession().update(fee);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	@Override
	public void addGrade(ExamGrades examGrades) {
		sessionFactory.getCurrentSession().save(examGrades);		
	}

	@Override
	public void updateGrade(ExamGrades examGrades) {
		sessionFactory.getCurrentSession().update(examGrades);
	}
}
