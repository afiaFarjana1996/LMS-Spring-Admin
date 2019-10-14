package com.ss.lms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.service.AuthorService;
import com.ss.lms.service.PublisherService;

@RestController
public class PublisherController {
	@Autowired
	PublisherService publisherService;
	
	@RequestMapping(value = "/lms/add_publishers/publisherId/{publisherId}/publisherName/{publisherName}")
	public String addPublisher(@PathVariable int publisherId,@PathVariable String publisherName) throws SQLException {
		return publisherService.addPublisher(publisherId, publisherName);
	}
	
	@RequestMapping(value = "/lms/update_publishers/publisherId/{publisherId}/publisherName/{publisherName}")
	public String updatePublisher(@PathVariable int publisherId,@PathVariable String publisherName) throws SQLException {
		return publisherService.updatePublisher(publisherId, publisherName);
	}
	
	@RequestMapping(value = "/lms/delete_publishers/publisherId/{publisherId}")
	public String addPublisher(@PathVariable int publisherId) throws SQLException {
		return publisherService.deletePublisher(publisherId);
	}
	
	
}
