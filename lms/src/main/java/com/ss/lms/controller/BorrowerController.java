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
import com.ss.lms.entity.Borrower;
import com.ss.lms.service.BorrowerService;

@RestController
@RequestMapping("/admin")
public class BorrowerController {

	@Autowired
	BorrowerService borowerService;
	
	@RequestMapping(value = "/add_borrowers", method = RequestMethod.POST)
	public ResponseEntity<?> addBorrower(@RequestBody Borrower borrower) throws SQLException {
		   if(borowerService.addBorrower(borrower)) {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/update_borrowers", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBorrower(@RequestBody Borrower borrower) throws SQLException {
		 
		   if(borowerService.updateBorrower(borrower)) {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.CONFLICT);
		   }
	}
	
	@RequestMapping(value = "/delete_borrowers", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBorrower(@RequestBody Borrower borrower) throws SQLException {
		
		   if(borowerService.deleteBorrower(borrower)) {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.NOT_FOUND);
		   }
	}
	
}
