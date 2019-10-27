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
import com.ss.lms.entity.Publisher;
import com.ss.lms.service.AuthorService;
import com.ss.lms.service.PublisherService;

@RestController
@RequestMapping(value = "/lms/admin*")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class PublisherController {
	@Autowired
	PublisherService publisherService;
	
	@RequestMapping(value = "/publishers", method = RequestMethod.POST)
	public ResponseEntity<?> addPublisher(@RequestBody Publisher publisher) throws SQLException {
		
		   if(publisherService.addPublisher(publisher)) {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.BAD_REQUEST);
		   }		     
	}
	
	@RequestMapping(value = "/publishers/{publisherId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePublisher(@RequestBody Publisher publisher, @PathVariable int publisherId) throws SQLException {
		
		   publisher.setPublisherId(publisherId);
		   if(publisherService.updatePublisher(publisher)) {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Publisher>(publisher, HttpStatus.NOT_FOUND);
		   }		     
	}
	@RequestMapping(value = "/publishers/{publisherId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePublisher(@PathVariable int publisherId) throws SQLException {
		Publisher publisher = new Publisher();
		publisher.setPublisherId(publisherId);
		
		   if(publisherService.deletePublisher(publisher)) {
			   return new ResponseEntity<Publisher>(HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
		   }		     
	}
	
	
}
