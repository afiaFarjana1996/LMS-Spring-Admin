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
import com.ss.lms.entity.LibraryBranch;
import com.ss.lms.service.BorrowerService;
import com.ss.lms.service.LibraryBranchService;

@RestController
@RequestMapping("/admin")
public class LibraryBranchController {

	@Autowired
	LibraryBranchService libraryBranchService;	
	
	@RequestMapping(value = "/add_libraryBranch", method = RequestMethod.POST)
	public ResponseEntity<?> addLibraryBranch(@RequestBody LibraryBranch libraryBranch) throws SQLException {
		
		   if(libraryBranchService.addLibraryBranch(libraryBranch)) {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/update_libraryBranch", method = RequestMethod.PUT)
	public ResponseEntity<?> updateLibraryBranch(@RequestBody LibraryBranch libraryBranch) throws SQLException {
		
		   if(libraryBranchService.updateLibraryBranch(libraryBranch)) {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/delete_libraryBranch", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteLibraryBranch(@RequestBody LibraryBranch libraryBranch) throws SQLException {
		
		   if(libraryBranchService.deleteLibraryBranch(libraryBranch)) {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.NOT_FOUND);
		   }		     
	}

	
}
