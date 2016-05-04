package com.cms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class FeePayment implements Serializable{
	/**
	 * S
	 */
	private static final long serialVersionUID = -4368859211574857116L;
	@Id @GeneratedValue
	private int paymentID;
	
	@Digits(fraction=3, integer = 10, message="{digits.Fee.totalCost}")
	@Min(value=0, message="{min.Fee.totalCost}")
	@NotNull(message="{notNull.Fee.totalCost}")
	private BigDecimal amountPaid;
	@Temporal(TemporalType.DATE)
	private Date paidDate;
	
	@ManyToOne
	private StudentInfo student;
	
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public StudentInfo getStudent() {
		return student;
	}
	public void setStudent(StudentInfo student) {
		this.student = student;
	}	
}
