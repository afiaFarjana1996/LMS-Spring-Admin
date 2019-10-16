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
import com.ss.lms.entity.Borrower;
import com.ss.lms.service.BorrowerService;

@RestController
@RequestMapping(value = "/lms/admin*")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class BorrowerController {

	@Autowired
	BorrowerService borowerService;
	
	@RequestMapping(value = "/borrowers", method = RequestMethod.POST)
	public ResponseEntity<?> addBorrower(@RequestBody Borrower borrower) throws SQLException {
		   if(borowerService.addBorrower(borrower)) {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/borrowers/{cardNo}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBorrower(@RequestBody Borrower borrower, @PathVariable int cardNo) throws SQLException {
		   borrower.setCardNo(cardNo);
		   if(borowerService.updateBorrower(borrower)) {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Borrower>(borrower, HttpStatus.CONFLICT);
		   }
	}
	
	@RequestMapping(value = "/borrowers/{cardNo}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBorrower(@PathVariable int cardNo) throws SQLException {
		
		Borrower borrower = new Borrower();
		borrower.setCardNo(cardNo);
		   if(borowerService.deleteBorrower(borrower)) {
			   return new ResponseEntity<Borrower>(HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Borrower>(HttpStatus.NOT_FOUND);
		   }
	}
	
}
