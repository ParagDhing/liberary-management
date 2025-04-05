package com.microservice.liberary_management.dto;

import com.microservice.liberary_management.model.Book;

public class BookDTO {

	private String bookName;
	private boolean issued;
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDTO(String bookName, boolean issued) {
		super();
		this.bookName = bookName;
		this.issued = issued;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public boolean isIssued() {
		return issued;
	}
	public void setIssued(boolean issued) {
		this.issued = issued;
	}
	
	public Book mapToBook() {
		return new Book(0, bookName, issued);
	}
}
