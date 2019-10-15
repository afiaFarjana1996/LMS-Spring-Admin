package com.ss.lms.controller;

import java.sql.SQLException;

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
@RequestMapping("/admin")
public class AuthorController {	
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(value = "/add_authors", method = RequestMethod.POST)
	public ResponseEntity<?> addAuthor(@RequestBody Author author) throws SQLException {
		
		   if(authorService.addAuthor(author)) {
			   return new ResponseEntity<Author>(author, HttpStatus.CREATED);
		   }else {
			   return new ResponseEntity<Author>(author, HttpStatus.CONFLICT);
		   }		     
	}
	
	@RequestMapping(value = "/update_authors", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAuthor(@RequestBody Author author) throws SQLException {
		 
		   if(authorService.updateAuthor(author)) {
			   return new ResponseEntity<Author>(author, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Author>(author, HttpStatus.CONFLICT);
		   }
	}
	
	@RequestMapping(value = "/delete_authors", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAuthor(@RequestBody Author author) throws SQLException {
		
		  if(authorService.deleteAuthor(author)) {
			   return new ResponseEntity<Author>(author, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<Author>(author, HttpStatus.NOT_FOUND);
		   }
	}

}
