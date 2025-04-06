package com.microservice.liberary_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.liberary_management.dto.BookDTO;
import com.microservice.liberary_management.exception.BookNotFoundException;
import com.microservice.liberary_management.model.Book;
import com.microservice.liberary_management.model.Liberary;
import com.microservice.liberary_management.service.BookService;

@RestController()
@RequestMapping("/liberary/v1")
public class LiberaryController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/all/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Liberary> getAllIssuedBooksByStudentId(@PathVariable("id") int id) {
		return bookService.getIssuedBookByIssuerId(id);
	}
	
	@PostMapping("/book/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addBookToLiberary(BookDTO book) {
		bookService.addNewBook(book);
	}
	
	@GetMapping("/book")
	@ResponseStatus(HttpStatus.OK)
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) throws Exception {
		 Book bookById = bookService.getBookById(id);
		 if(bookById == null) {
			 throw new BookNotFoundException("No book found for ID: " + id);
		 }
		 return ResponseEntity.ok(bookById);
	}
	
	@PutMapping("/issue/book")
	public ResponseEntity<String> issueBook(@RequestParam int issuerId, @RequestParam int bookId) {
		String responce = bookService.issueBook(bookId, issuerId);
		
		return ResponseEntity.accepted().body(responce);
	}
}
