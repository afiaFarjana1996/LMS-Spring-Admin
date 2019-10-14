package com.ss.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.lms.dao.BookDao;
import com.ss.lms.entity.Author;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.Publisher;

@Component
public class BookService {
	
	@Autowired
	BookDao bookDao;

	public String addBook(int bookId, String title, int authId, int pubId) {
		// TODO Auto-generated method stub
		List<Integer> bookList = bookDao.findAll();	
		if(!bookList.contains(bookId)) {
			Book book = new Book();
			book.setBookId(bookId);
			book.setTitle(title);
			
			Author author = new Author();
			author.setAuthorId(authId);
			book.setAuthor(author);
			
			Publisher publisher = new Publisher();
			publisher.setPublisherId(pubId);
			book.setPublisher(publisher);
			
			bookDao.addBook(book);
			return "<h3>Add book successfully.</h3>";
		} 	
			return "<h3>Unable to add book.Book id is already exist.</h3>";	
	}

	public String updateBook(int bookId, String title, int authId, int pubId) {
		// TODO Auto-generated method stub

		List<Integer> bookList = bookDao.findAll();	
		if(bookList.contains(bookId)) {
			Book book = new Book();
			book.setBookId(bookId);
			book.setTitle(title);
			
			Author author = new Author();
			author.setAuthorId(authId);
			book.setAuthor(author);
			
			Publisher publisher = new Publisher();
			publisher.setPublisherId(pubId);
			book.setPublisher(publisher);
			
			bookDao.updateBook(book);
			return "<h3>Update book successfully.</h3>";
		} 	
			return "<h3>Unable to update book.Book id doenn't exist.</h3>";	
		
		
	}

	public String deleteBook(int bookId) {
		// TODO Auto-generated method stub
		List<Integer> bookList = bookDao.findAll();	
		if(bookList.contains(bookId)) {
			Book book = new Book();
			book.setBookId(bookId);		
			bookDao.deleteBook(book);
			return "<h3>Delete book successfully.</h3>";
		} 	
			return "<h3>Unable to delete book.Book id doesn't exist.</h3>";	
	}

}
