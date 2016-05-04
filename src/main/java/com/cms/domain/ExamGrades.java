package com.cms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class ExamGrades {
	@Id @GeneratedValue
	private int rowId;
	private String courseCode;
	private String courseName;
	@Min(value=0, message="{min.ExamGrades.grade}")
	@Max(value=4, message="{max.ExamGrades.grade}")
	@Digits(integer=1, fraction=2, message="{digits.ExamGrades.grade}")
	private float firstTerm;

	@Min(value=0, message="{min.ExamGrades.grade}")
	@Max(value=4, message="{max.ExamGrades.grade}")
	@Digits(integer=1, fraction=2, message="{digits.ExamGrades.grade}")
	private float secondTerm;

	@Min(value=0, message="{min.ExamGrades.grade}")
	@Max(value=4, message="{max.ExamGrades.grade}")
	@Digits(integer=1, fraction=2, message="{digits.ExamGrades.grade}")
	private float boardExamGrade;
	
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public float getFirstTerm() {
		return firstTerm;
	}
	public void setFirstTerm(float firstTerm) {
		this.firstTerm = firstTerm;
	}
	public float getSecondTerm() {
		return secondTerm;
	}
	public void setSecondTerm(float secondTerm) {
		this.secondTerm = secondTerm;
	}
	public float getBoardExamGrade() {
		return boardExamGrade;
	}
	public void setBoardExamGrade(float boardExamGrade) {
		this.boardExamGrade = boardExamGrade;
	}
}
