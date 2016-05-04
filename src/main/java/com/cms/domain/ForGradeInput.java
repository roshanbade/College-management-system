package com.cms.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ForGradeInput {
	@Min(value=0, message="{min.ForGradeInput.semester}")
	@Digits(integer=2, fraction=0, message="{digits.ForGradeInput.semester}")
	private int semester;
	
	@Size(min=1, max=50, message="{size.ForGradeInput.department}")
	private String department;
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
