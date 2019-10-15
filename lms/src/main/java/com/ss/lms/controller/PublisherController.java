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
import com.ss.lms.entity.Publisher;
import com.ss.lms.service.AuthorService;
import com.ss.lms.service.PublisherService;

@RestController
@RequestMapping("/admin")
public class PublisherController {
	@Autowired
	PublisherService publisherService;
	
	
	@RequestMapping(value = "/add_publishers", method = RequestMethod.POST)
	public ResponseEntity<?> addPublisher(@RequestBody Publisher publisher) throws SQLException {
		
		   if(publisherService.addPublisher(publisher)) {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/update_publishers", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePublisher(@RequestBody Publisher publisher) throws SQLException {
		
		   if(publisherService.updatePublisher(publisher)) {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.CONFLICT);
		   }		     
	}
	@RequestMapping(value = "/delete_publishers", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePublisher(@RequestBody Publisher publisher) throws SQLException {
		
		   if(publisherService.deletePublisher(publisher)) {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.NOT_FOUND);
		   }		     
	}
	
	
}
