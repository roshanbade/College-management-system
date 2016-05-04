package com.cms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@Digits(integer=6,fraction=0,message="{Digits.Book.bookId.validation}")
	@Min(value = 0, message = "Book id cannot be negative!")
	private int bookId;
	@Size(min=1,max=50,message="Name cannot be empty")
	private String name;
	@NotNull(message = "NotNull.Book.author.validation")
	private String author;
	@NotNull(message = "{NotNull.Book.faculty.validation}")
	private String faculty;
	@NotNull(message = "{NotNull.Book.semester.validation}")
	private int semester;
	@NotNull(message = "{NotNull.Book.publisher.validation}")
	private String publisher;

	@ManyToOne
	private StudentInfo student;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
