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
	
	public boolean addBorrower(Borrower borrower) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> borrowerList = borrowerDao.findAll();	
		if(!borrowerList.contains(borrower.getCardNo())) {
		    Borrower newBorrower = new Borrower();
		    newBorrower.setCardNo(borrower.getCardNo());
		    newBorrower.setName(borrower.getName());
			borrowerDao.addBorrower(newBorrower);
			return true;
		} 	
			return false;
	}

	public boolean updateBorrower(Borrower borrower) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> borrowerList = borrowerDao.findAll();	
		if(borrowerList.contains(borrower.getCardNo())) {
		    Borrower newBorrower = new Borrower();
		    newBorrower.setCardNo(borrower.getCardNo());
		    newBorrower.setName(borrower.getName());
			borrowerDao.updateBorrower(newBorrower);
			return true;
		} 	
			return false;
	}

	public boolean deleteBorrower(Borrower borrower) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> borrowerList = borrowerDao.findAll();	
		if(borrowerList.contains(borrower.getCardNo())) {
		    Borrower deleteBorrower = new Borrower();
		    deleteBorrower.setCardNo(borrower.getCardNo());
			borrowerDao.deleteBorrower(deleteBorrower);
			return true;
		} 	
			return false;
	}

	
}
