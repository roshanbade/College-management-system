package com.cms.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Classroom {
	@Id
	@Size(min=1, max=50, message="{size.Classsroom.className}")
	private String className;
	
	@Min(value=1, message="{min.Classroom.rows}")
	@Digits(integer=3, fraction=0, message= "{digits.Classroom.rows}")
	private int rows;
	@Min(value=1, message="{min.Classroom.columns}")
	@Digits(integer=3, fraction=0, message= "{digits.Classroom.columns}")
	private int columns;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
}
