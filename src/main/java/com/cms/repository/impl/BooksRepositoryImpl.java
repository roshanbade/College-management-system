package com.cms.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.domain.Book;
import com.cms.exception.BookNotFound;
import com.cms.repository.BooksRepository;

@Repository
@Transactional
public class BooksRepositoryImpl implements BooksRepository{

	@Autowired
	SessionFactory factory;
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void addBooks(Book book) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().save(book);
		/*factory.getCurrentSession().flush();
		factory.getCurrentSession().clear();*/
	}

	@Override
	public Book getBookInfoById(int bookId) {
		// TODO Auto-generated method stub
		Book book = (Book) factory.getCurrentSession().get(Book.class, bookId);
		
		if(book == null){
			throw new BookNotFound("No book found with the book id : " + bookId);
		}
		
		return book;
		
	}

	@Override
	public void deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().delete(Book.class);
		
	}

	
	/*@Override
	public List<Book> showAllBooks() {
		// TODO Auto-generated method stub
		
		List<Book> bookList = new ArrayList<Book>();
		
		Query query = factory.getCurrentSession().createQuery("from Book");
		bookList = (List<Book>) query.list();
		
		return bookList;
	}*/

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().update(book);
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().delete(book);
	}

	@Override
	public void deleteStudentBookById(Book book) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().delete(book);
	}

	@Override
	public Set<Book> showAllBooks() {
		// TODO Auto-generated method stub
		Set<Book> bookList = new HashSet<Book>();
		
		Query query = factory.getCurrentSession().createQuery("from Book");
		
		Iterator<Book> books = query.list().iterator();
		
		while(books.hasNext()){
			bookList.add(books.next());
		}
		//bookList = (Set<Book>) query.list();
		return bookList;
	}

}
