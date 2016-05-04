package com.cms.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Fee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6894877057424937204L;

	@Id
	@OneToOne
	private StudentInfo studentInfo;
	
	@Digits(fraction=3, integer = 10, message="{digits.Fee.totalCost}")
	@Min(value=0, message="{min.Fee.totalCost}")
	@NotNull(message="{notNull.Fee.totalCost}")
	private BigDecimal totalCost;
	
	//@Digits(fraction=2, integer = 0)
	private BigDecimal scholarship;
	private BigDecimal first;
	private BigDecimal second;
	private BigDecimal third;
	private BigDecimal fourth;
	private BigDecimal fifth;
	private BigDecimal sixth;
	private BigDecimal seventh;
	private BigDecimal eighth;
	private BigDecimal totalPaid;
	
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	public BigDecimal getScholarship() {
		return scholarship;
	}
	public void setScholarship(BigDecimal scholarship) {
		this.scholarship = scholarship;
	}
	public BigDecimal getFirst() {
		return first;
	}
	public void setFirst(BigDecimal first) {
		this.first = first;
	}
	public BigDecimal getSecond() {
		return second;
	}
	public void setSecond(BigDecimal second) {
		this.second = second;
	}
	public BigDecimal getThird() {
		return third;
	}
	public void setThird(BigDecimal third) {
		this.third = third;
	}
	public BigDecimal getFourth() {
		return fourth;
	}
	public void setFourth(BigDecimal fourth) {
		this.fourth = fourth;
	}
	public BigDecimal getFifth() {
		return fifth;
	}
	public void setFifth(BigDecimal fifth) {
		this.fifth = fifth;
	}
	public BigDecimal getSixth() {
		return sixth;
	}
	public void setSixth(BigDecimal sixth) {
		this.sixth = sixth;
	}
	public BigDecimal getSeventh() {
		return seventh;
	}
	public void setSeventh(BigDecimal seventh) {
		this.seventh = seventh;
	}
	public BigDecimal getEighth() {
		return eighth;
	}
	public void setEighth(BigDecimal eighth) {
		this.eighth = eighth;
	}
	public BigDecimal getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
	}	
	
}

