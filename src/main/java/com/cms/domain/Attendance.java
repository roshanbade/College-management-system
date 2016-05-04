package com.cms.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Attendance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 974702844003245223L;

	@ElementCollection(fetch=FetchType.EAGER)
	private Map<String , Boolean> listOfStudents = new HashMap<String, Boolean>();
	
	@EmbeddedId
	private AttendanceId attendanceId;
	
	public AttendanceId getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(AttendanceId attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Map<String, Boolean> getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(Map<String, Boolean> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}
}
