package com.ss.lms.controller;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.entity.Author;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookLoans;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.LibraryBranch;
import com.ss.lms.service.BookLoansService;


@RestController
@RequestMapping("/admin")
public class BooklLoansController {
	
	@Autowired
	BookLoansService bookLoansService;
	
	@RequestMapping(value = "/override_duedates/{bookId}/{branchId}/{cardNo}/{duedate}", method = RequestMethod.PUT)
	public ResponseEntity<?>  overrideDuedate(@PathVariable int bookId, @PathVariable int branchId, 
			@PathVariable int cardNo, @PathVariable Date duedate) throws SQLException {
				
		Book book = new Book();
		book.setBookId(bookId);
		LibraryBranch libraryBranch = new LibraryBranch();
		libraryBranch.setBranchId(branchId);
		Borrower borrower = new Borrower();
		borrower.setCardNo(cardNo);
		
		BookLoans bookLoans = new BookLoans();
		bookLoans.setBook(book);
		bookLoans.setLibraryBranch(libraryBranch);
		bookLoans.setBorrower(borrower);
		bookLoans.setDueDate(duedate);
		
		   if(bookLoansService.overrideDuedate(bookLoans)) {
			   return new ResponseEntity<BookLoans>(bookLoans, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<BookLoans>(bookLoans, HttpStatus.CONFLICT);
		   }
		
	}
}
