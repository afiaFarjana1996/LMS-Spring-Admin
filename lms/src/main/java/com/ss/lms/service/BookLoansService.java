package com.ss.lms.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.lms.dao.AuthorDao;
import com.ss.lms.dao.BookDao;
import com.ss.lms.dao.BookLoansDao;
import com.ss.lms.dao.BorrowerDao;
import com.ss.lms.dao.LibraryBranchDao;
import com.ss.lms.dao.PublisherDao;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookLoans;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.LibraryBranch;

@Component
public class BookLoansService {

	@Autowired
	BookLoansDao bookLoansDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	LibraryBranchDao libraryBranchDao;
	@Autowired
	BorrowerDao borrowerDao;
	
	public boolean overrideDuedate(BookLoans bookLoans) throws SQLException {
		// TODO Auto-generated method stub	
		
		List<Integer> bookList = bookDao.findAll();	
		List<Integer> branchList = libraryBranchDao.findAll();	
		List<Integer> borrowerList = borrowerDao.findAll();	
		
		if(bookList.contains(bookLoans.getBook().getBookId()) && 
				branchList.contains(bookLoans.getLibraryBranch().getBranchId()) 
				&& borrowerList.contains(bookLoans.getBorrower().getCardNo())) {
			
			Book book = new Book();
			book.setBookId(bookLoans.getBook().getBookId());
			
			LibraryBranch libraryBranch = new LibraryBranch();
			libraryBranch.setBranchId(bookLoans.getLibraryBranch().getBranchId());
			
			Borrower borrower = new Borrower();
			borrower.setCardNo(bookLoans.getBorrower().getCardNo());
			
			BookLoans newBookLoans = new BookLoans();
			newBookLoans.setBook(book);
			newBookLoans.setLibraryBranch(libraryBranch);
			newBookLoans.setBorrower(borrower);
			newBookLoans.setDueDate(bookLoans.getDueDate());
		
			bookLoansDao.overrideDuedate(newBookLoans);
			return true;
		}
		return false;
	}

}
