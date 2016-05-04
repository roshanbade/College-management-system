package com.cms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class StudentInfo implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8556390369375079864L;
	@Id
	@Min(value=0, message="{min.StudentInfo.studentId}")
	@Digits(integer = 6, fraction=0,  message="{digits.StudentInfo.studentId}")
	private int studentId;
	
	@Size(min=1, max=50, message="{size.StudentInfo.firstName}")
	private String firstName;
	
	private String lastName;
	
	@Size(min=1, max=50,message="{size.StudentInfo.faculty}")
	private String faculty;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@NotNull(message="{NotNull.StudentInfo.date}")
	private Date joinDate;   
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="studentInfo")
	private Fee fee;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="student")
	private List<FeePayment> listOfFeePayment = new ArrayList<FeePayment>();
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<ExamGrades> listOfExamGrades = new ArrayList<ExamGrades>();

	@OneToMany(fetch=FetchType.EAGER)
	private Set<Book> listOfBooks = new HashSet<Book>();
	//private List<Book> listOfBooks = new ArrayList<Book>();
	
	public List<ExamGrades> getListOfExamGrades() {
		return listOfExamGrades;
	}
	public void setListOfExamGrades(List<ExamGrades> listOfExamGrades) {
		this.listOfExamGrades = listOfExamGrades;
	}
	public List<FeePayment> getListOfFeePayment() {
		return listOfFeePayment;
	}
	public void setListOfFeePayment(List<FeePayment> listOfFeePayment) {
		this.listOfFeePayment = listOfFeePayment;
	}
	public Fee getFee() {
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	/*public List<Book> getListOfBooks() {
		return listOfBooks;
	}
	public void setListOfBooks(List<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}*/
	public Set<Book> getListOfBooks() {
		return listOfBooks;
	}
	public void setListOfBooks(Set<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}	
	
	
}
