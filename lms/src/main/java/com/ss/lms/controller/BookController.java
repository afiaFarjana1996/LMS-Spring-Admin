package com.ss.lms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/lms/add_books/bookId/{bookId}/title/{title}/authId/{authId}/pubId/{pubId}")
	public String addPublisher(@PathVariable int bookId,@PathVariable String title,
			@PathVariable int authId, @PathVariable int pubId) throws SQLException {
		return bookService.addBook(bookId, title, authId, pubId);
	}
	
	@RequestMapping(value = "/lms/update_books/bookId/{bookId}/title/{title}/authId/{authId}/pubId/{pubId}")
	public String updatePublisher(@PathVariable int bookId,@PathVariable String title,
			@PathVariable int authId, @PathVariable int pubId) throws SQLException {
		return bookService.updateBook(bookId, title, authId, pubId);
	}
	
	@RequestMapping(value = "/lms/delete_books/bookId/{bookId}")
	public String deletePublisher(@PathVariable int bookId) throws SQLException {
		return bookService.deleteBook(bookId);
	}
	
	
}
