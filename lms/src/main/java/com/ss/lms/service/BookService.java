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

	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		List<Integer> bookList = bookDao.findAll();	
		if(!bookList.contains(book.getBookId())) {
			Book newBook = new Book();
			newBook.setBookId(book.getBookId());
			newBook.setTitle(book.getTitle());
			
			Author author = new Author();
			author.setAuthorId(book.getAuthor().getAuthorId());
			newBook.setAuthor(author);
			
			Publisher publisher = new Publisher();
			publisher.setPublisherId(book.getPublisher().getPublisherId());
			newBook.setPublisher(publisher);
			
			bookDao.addBook(newBook);
			return true;
		} 	
		return false;
	}

	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub

		List<Integer> bookList = bookDao.findAll();	
		if(bookList.contains(book.getBookId())) {
			Book newBook = new Book();
			newBook.setBookId(book.getBookId());
			newBook.setTitle(book.getTitle());
			
			Author author = new Author();
			author.setAuthorId(book.getAuthor().getAuthorId());
			newBook.setAuthor(author);
			
			Publisher publisher = new Publisher();
			publisher.setPublisherId(book.getPublisher().getPublisherId());
			newBook.setPublisher(publisher);
			
			bookDao.updateBook(newBook);
			return true;
		} 	
		return false;
	
	}

	public boolean deleteBook(Book book ) {
		// TODO Auto-generated method stub
		List<Integer> bookList = bookDao.findAll();	
		if(bookList.contains(book.getBookId())) {
			Book deleteBook = new Book();
			deleteBook.setBookId(book.getBookId());	
			bookDao.deleteBook(deleteBook);
			return true;
		} 	
		return false;
	}

}
