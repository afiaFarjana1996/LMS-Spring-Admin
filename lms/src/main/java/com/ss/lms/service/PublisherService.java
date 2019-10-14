package com.ss.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.lms.dao.AuthorDao;
import com.ss.lms.dao.PublisherDao;
import com.ss.lms.entity.Author;
import com.ss.lms.entity.Publisher;

@Component
public class PublisherService {

	@Autowired
	PublisherDao publisherDao;
	
	public String addPublisher(int publisherId, String publisherName) throws SQLException {
		List<Integer> publisherList = publisherDao.findAll();	
		if(!publisherList.contains(publisherId)) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(publisherId);
			publisher.setPublisherName(publisherName);
			publisherDao.addPublisher(publisher);
			return "<h3>Add publisher successfully.</h3>";
		} 	
			return "<h3>Unable to add publisher.Publisher id is already exist.</h3>";		
	}
	
	public String updatePublisher(int publisherId, String publisherName) throws SQLException {
		List<Integer> publisherList = publisherDao.findAll();	
		if(publisherList.contains(publisherId)) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(publisherId);
			publisher.setPublisherName(publisherName);
			publisherDao.updatePublisher(publisher);
			return "<h3>Update publisher successfully.</h3>";
		} 	
			return "<h3>Unable to update publisher.Publisher id doesn't exist.</h3>";
	}

	public String deletePublisher(int publisherId) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> publisherList = publisherDao.findAll();	
		if(publisherList.contains(publisherId)) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(publisherId);
			publisherDao.deletePublisher(publisher);
			return "<h3>Delete publisher successfully.</h3>";
		} 	
			return "<h3>Unable to delete publisher.Publisher id doesn't exist.</h3>";
	}
	
	
}
