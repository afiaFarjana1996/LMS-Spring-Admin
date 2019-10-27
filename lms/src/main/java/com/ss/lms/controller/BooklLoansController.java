package com.ss.lms.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookLoans;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.LibraryBranch;
import com.ss.lms.service.BookLoansService;


@RestController
@RequestMapping(value = "/lms/admin*")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class BooklLoansController {
	
	@Autowired
	BookLoansService bookLoansService;
	
	@RequestMapping(value = "/duedates", method = RequestMethod.PUT)
	public ResponseEntity<?>  overrideDuedate(@RequestBody BookLoans bookLoans) throws SQLException, ParseException {
		
		   if(bookLoansService.overrideDuedate(bookLoans)) {
			   return new ResponseEntity<BookLoans>(bookLoans, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<BookLoans>(bookLoans, HttpStatus.NOT_FOUND);
		   }
		
	}
}
