package com.ss.lms.controller;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ss.lms.entity.Author;
import com.ss.lms.service.AuthorService;

@RestController
@RequestMapping(value = "/lms/admin*")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class AuthorController {	
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(value = "/authors", method = RequestMethod.POST)
	public ResponseEntity<?> addAuthor(@RequestBody Author author) throws SQLException {
		       
		   if(authorService.addAuthor(author)) {
			   return new ResponseEntity<Author>(author, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Author>(author, HttpStatus.CONFLICT);
		   }	
	}
	
	@RequestMapping(value = "/authors/{authorId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAuthor(@RequestBody Author author, @PathVariable int authorId) throws SQLException {
		 
		   author.setAuthorId(authorId);
		   if(authorService.updateAuthor(author)) {
			   return new ResponseEntity<Author>(author, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
		   }
	}
	
	@RequestMapping(value = "/authors/{authorId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAuthor(@PathVariable int authorId) throws SQLException {
		Author author = new Author();
		author.setAuthorId(authorId);
		
		  if(authorService.deleteAuthor(author)) {
			   return new ResponseEntity<Author>(HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		   }
	}

}
