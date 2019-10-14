package com.ss.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.lms.dao.BorrowerDao;
import com.ss.lms.entity.Author;
import com.ss.lms.entity.Borrower;

@Component
public class BorrowerService {

	@Autowired
	BorrowerDao borrowerDao;
	
	public String addBorrower(int cardNo, String name) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> borrowerList = borrowerDao.findAll();	
		if(!borrowerList.contains(cardNo)) {
		    Borrower borrower = new Borrower();
		    borrower.setCardNo(cardNo);
		    borrower.setName(name);
			borrowerDao.addBorrower(borrower);
			return "<h3>Add borrower successfully.</h3>";
		} 	
			return "<h3>Unable to add borrower.Borrower id is already exist.</h3>";	
	}

	public String updateBorrower(int cardNo, String name) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> borrowerList = borrowerDao.findAll();	
		if(borrowerList.contains(cardNo)) {
		    Borrower borrower = new Borrower();
		    borrower.setCardNo(cardNo);
		    borrower.setName(name);
			borrowerDao.updateBorrower(borrower);
			return "<h3>Update borrower successfully.</h3>";
		} 	
			return "<h3>Unable to update borrower.Borrower id doesn't exist.</h3>";	
	}

	public String deleteBorrower(int cardNo) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> borrowerList = borrowerDao.findAll();	
		if(borrowerList.contains(cardNo)) {
		    Borrower borrower = new Borrower();
		    borrower.setCardNo(cardNo);
			borrowerDao.deleteBorrower(borrower);
			return "<h3>Delete borrower successfully.</h3>";
		} 	
			return "<h3>Unable to delete borrower.Borrower id doesn't exist.</h3>";	
	}

	
}
