package com.microservice.liberary_management.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.microservice.liberary_management.dto.BookDTO;

@Document(collection = "book")
public class Book {

	@Id
	private int id;
	
	private String bookName;
	private boolean issued;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String bookName, boolean issued) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.issued = issued;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public BookDTO mapToDTO() {
		return new BookDTO(bookName, issued);
	}
}
