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
	
	public String overrideDuedate(int bookId, int branchId, int cardNo, Date duedate) throws SQLException {
		// TODO Auto-generated method stub	
		
		List<Integer> bookList = bookDao.findAll();	
		List<Integer> branchList = libraryBranchDao.findAll();	
		List<Integer> borrowerList = borrowerDao.findAll();	
		if(bookList.contains(bookId) && branchList.contains(branchId) && borrowerList.contains(cardNo)) {
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
		
			bookLoansDao.overrideDuedate(bookLoans);
			return "<h3>Over_ride due date successfully.</h3>";
		}
		
		
		return "<h3>Unable to override duedate. Book loan doesn't exist.</h3>";
	}

}
