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
import com.ss.lms.entity.LibraryBranch;
import com.ss.lms.service.BorrowerService;
import com.ss.lms.service.LibraryBranchService;

@RestController
@RequestMapping(value = "/lms/admin*")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class LibraryBranchController {

	@Autowired
	LibraryBranchService libraryBranchService;	
	
	@RequestMapping(value = "/libraryBranches", method = RequestMethod.POST)
	public ResponseEntity<?> addLibraryBranch(@RequestBody LibraryBranch libraryBranch) throws SQLException {
		
		   if(libraryBranchService.addLibraryBranch(libraryBranch)) {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/libraryBranches/{branchId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateLibraryBranch(@RequestBody LibraryBranch libraryBranch,@PathVariable int branchId) throws SQLException {
		   libraryBranch.setBranchId(branchId);
		   if(libraryBranchService.updateLibraryBranch(libraryBranch)) {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/libraryBranches/{branchId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteLibraryBranch(@PathVariable int branchId) throws SQLException {
		 LibraryBranch libraryBranch = new LibraryBranch();
		 libraryBranch.setBranchId(branchId);
		   if(libraryBranchService.deleteLibraryBranch(libraryBranch)) {
			   return new ResponseEntity<LibraryBranch>(HttpStatus.OK);
		   }else {
			   return new ResponseEntity<LibraryBranch>(HttpStatus.NOT_FOUND);
		   }		     
	}

	
}
