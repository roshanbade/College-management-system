package com.cms.service;

import java.util.List;
import java.util.Set;

import com.cms.domain.Book;

public interface BooksService {
	public void addBooks(Book book);
	public Book getBookInfoById(int bookId);
	public void deleteBookById(int bookId);
	//public List<Book> showAllBooks();
	public Set<Book> showAllBooks();
	public void updateBook(Book book);
	public void deleteBOok(Book book);
	public void deleteStudentBook(Book book);
}
