package com.cms.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account_Admin {
	@Id
	private int StudentId;

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	
	
}
