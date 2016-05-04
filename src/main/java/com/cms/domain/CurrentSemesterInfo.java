package com.cms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentSemesterInfo {
	@Id
	private int id;
	private Date semesterStartDate;
	private Date semesterEndDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSemesterStartDate() {
		return semesterStartDate;
	}
	public void setSemesterStartDate(Date semesterStartDate) {
		this.semesterStartDate = semesterStartDate;
	}
	public Date getSemesterEndDate() {
		return semesterEndDate;
	}
	public void setSemesterEndDate(Date semesterEndDate) {
		this.semesterEndDate = semesterEndDate;
	}
}
