package com.ss.lms.controller;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

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
@RequestMapping(value = "/lms/admin*")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<?> addBook(@RequestBody Book book) throws SQLException {

		   
		   if(bookService.addBook(book)) {
			   return new ResponseEntity<Book>(book, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Book>(book, HttpStatus.BAD_REQUEST);
		   }	
	}
	
	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable int bookId) throws SQLException {
		
		  book.setBookId(bookId);
		 if(bookService.updateBook(book)) {
			   return new ResponseEntity<Book>(book, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
		   }
	}
	
	
	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@PathVariable int bookId) throws SQLException {
	   
		Book book = new Book();
		book.setBookId(bookId);
		
		 if(bookService.deleteBook(book)) {
			   return new ResponseEntity<Book>(HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		   }
	}

	
}
