package com.cms.repository;

import java.util.List;
import java.util.Set;

import com.cms.domain.Book;

public interface BooksRepository {
	public void addBooks(Book book);
	public Book getBookInfoById(int bookId);
	public void deleteBookById(int bookId);
	//public List<Book> showAllBooks();
	public Set<Book> showAllBooks();
	public void updateBook(Book book);
	public void deleteBook(Book book);
	public void deleteStudentBookById(Book book);
}
