package com.ss.lms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.service.BorrowerService;

@RestController
public class BorrowerController {

	@Autowired
	BorrowerService borowerService;
	
	@RequestMapping(value = "/lms/add_borrowers/cardNo/{cardNo}/name/{name}")
	public String addBorrower(@PathVariable int cardNo,@PathVariable String name) throws SQLException {
		return borowerService.addBorrower(cardNo, name);
	}
	
	@RequestMapping(value = "/lms/update_borrowers/cardNo/{cardNo}/name/{name}")
	public String updateBorrower(@PathVariable int cardNo,@PathVariable String name) throws SQLException {
		return borowerService.updateBorrower(cardNo, name);
	}
	
	@RequestMapping(value = "/lms/delete_borrowers/cardNo/{cardNo}")
	public String deleteBorrower(@PathVariable int cardNo) throws SQLException {
		return borowerService.deleteBorrower(cardNo);
	}
	
}
