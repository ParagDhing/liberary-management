package com.microservice.liberary_management.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "liberary")
public class Liberary {

	@Id
	private long recordId;
	private int issuerId;
	private int bookId;
	private Date issuedDate;
	private Date submitedDate;
	public Liberary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Liberary(long recordId, int issuerId, int bookId, Date issuedDate, Date submitedDate) {
		super();
		this.recordId = recordId;
		this.issuerId = issuerId;
		this.bookId = bookId;
		this.issuedDate = issuedDate;
		this.submitedDate = submitedDate;
	}
	public long getRecordId() {
		return recordId;
	}
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	public int getIssuerId() {
		return issuerId;
	}
	public void setIssuerId(int issuerId) {
		this.issuerId = issuerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getSubmitedDate() {
		return submitedDate;
	}
	public void setSubmitedDate(Date submitedDate) {
		this.submitedDate = submitedDate;
	}
	
	
}
