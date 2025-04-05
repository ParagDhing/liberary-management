package com.microservice.liberary_management.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.liberary_management.dto.BookDTO;
import com.microservice.liberary_management.model.Book;
import com.microservice.liberary_management.model.Liberary;
import com.microservice.liberary_management.repository.BookRepository;
import com.microservice.liberary_management.repository.LiberaryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private LiberaryRepository liberaryRepository;
	
	public void addNewBook(BookDTO book) {
		bookRepository.save(book.mapToBook());
	}
	
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id) {
		Optional<Book> book = bookRepository.findById(id);
		if(book.isEmpty()) {
			return null;
		}
		return book.get();
	}
	
	public List<Liberary> getIssuedBookByIssuerId(int id) {
		return liberaryRepository.findByIssuerId(id);
	}
	
	@Transactional
	public String issueBook(int bookId, int issuerId) {
		Book book = bookRepository.findById(bookId).get();
		if(book.isIssued()) {
			return "already issued, not available at the time";
		}
		book.setIssued(true);
		bookRepository.save(book);
		
		long recordId = liberaryRepository.findTopByOrderByRecordIdDesc().get().getRecordId();
		liberaryRepository.save(new Liberary(recordId, issuerId, bookId, new Date(), null));
		return "issued successfully";
	}
}
