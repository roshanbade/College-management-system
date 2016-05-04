package com.cms.exception;

public class BookNotFound extends RuntimeException{
	
	private static final long serialVersionUID = -694354952032299587L;
		
	private String bookId;

	public BookNotFound(String productId) {
		this.bookId = productId;
	}
	
	public String getBookId() {
		return bookId;
	}
}