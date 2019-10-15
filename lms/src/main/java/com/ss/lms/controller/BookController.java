package com.ss.lms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.entity.Author;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.Publisher;
import com.ss.lms.service.BookService;

@RestController
@RequestMapping("/admin")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/add_books/{bookId}/{title}/{authId}/{pubId}", method = RequestMethod.POST)
	public ResponseEntity<?> addBook(@PathVariable int bookId,@PathVariable String title,
			@PathVariable int authId, @PathVariable int pubId) throws SQLException {

		   Book book = new Book();
		   book.setBookId(bookId);
		   book.setTitle(title);
		   Author author = new Author();
		   author.setAuthorId(authId);
		   book.setAuthor(author);
		   Publisher publisher = new Publisher();
		   publisher.setPublisherId(pubId);
		   book.setPublisher(publisher);
		   
		   if(bookService.addBook(book)) {
			   return new ResponseEntity<Book>(book, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Book>(book, HttpStatus.CONFLICT);
		   }	
	}
	
	@RequestMapping(value = "/update_books/{bookId}/{title}/{authId}/{pubId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBook(@PathVariable int bookId,@PathVariable String title,
			@PathVariable int authId, @PathVariable int pubId) throws SQLException {
		
		   Book book = new Book();
		   book.setBookId(bookId);
		   book.setTitle(title);
		   Author author = new Author();
		   author.setAuthorId(authId);
		   book.setAuthor(author);
		   Publisher publisher = new Publisher();
		   publisher.setPublisherId(pubId);
		   book.setPublisher(publisher);
		   
		 if(bookService.updateBook(book)) {
			   return new ResponseEntity<Book>(book, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Book>(book, HttpStatus.CONFLICT);
		   }
	}
	
	@RequestMapping(value = "/delete_books/{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@PathVariable int bookId) throws SQLException {
	   
		Book book = new Book();
		book.setBookId(bookId);
		
		 if(bookService.deleteBook(book)) {
			   return new ResponseEntity<Book>(book, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
		   }
	}

	
}
