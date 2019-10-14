package com.ss.lms.controller;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ss.lms.service.BookLoansService;


@RestController
public class BoolLoansController {
	
	@Autowired
	BookLoansService bookLoansService;
	
	@RequestMapping(value = "/lms/override_duedate/bookId/{bookId}/branchId/{branchId}/cardNo/{cardNo}/new_duedate/{duedate}")
	public String addAuthor(@PathVariable int bookId,@PathVariable int branchId, 
			@PathVariable int cardNo, @PathVariable Date duedate) throws SQLException {
		return bookLoansService.overrideDuedate(bookId, branchId,cardNo,duedate);
	}
}
