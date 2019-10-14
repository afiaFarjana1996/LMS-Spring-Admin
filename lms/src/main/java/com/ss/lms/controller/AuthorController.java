package com.ss.lms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.entity.Author;
import com.ss.lms.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(value = "/lms/add_authors/authorId/{authorId}/authorName/{authorName}")
	public String addAuthor(@PathVariable int authorId,@PathVariable String authorName) throws SQLException {
		return authorService.addAuthor(authorId, authorName);
	}
	
	@RequestMapping(value = "/lms/update_authors/authorId/{authorId}/authorName/{authorName}")
	public String updateAuthor(@PathVariable int authorId,@PathVariable String authorName) throws SQLException {
		return authorService.updateAuthor(authorId, authorName);
	}
	
	@RequestMapping(value = "/lms/update_authors/authorId/{authorId}")
	public String deleteAuthor(@PathVariable int authorId) throws SQLException {
		return authorService.deleteAuthor(authorId);
	}

}
