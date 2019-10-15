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
	
	public boolean addPublisher(Publisher publisher) throws SQLException {
		List<Integer> publisherList = publisherDao.findAll();	
		if(!publisherList.contains(publisher.getPublisherId())) {
			Publisher newPublisher = new Publisher();
			newPublisher.setPublisherId(publisher.getPublisherId());
			newPublisher.setPublisherName(publisher.getPublisherName());
			publisherDao.addPublisher(newPublisher);
			return true;
		} 	
			return false;	
	}
	
	public boolean updatePublisher(Publisher publisher) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> publisherList = publisherDao.findAll();	
		if(publisherList.contains(publisher.getPublisherId())) {
			Publisher newPublisher = new Publisher();
			newPublisher.setPublisherId(publisher.getPublisherId());
			newPublisher.setPublisherName(publisher.getPublisherName());
			publisherDao.updatePublisher(newPublisher);
			return true;
		} 	
			return false;	
	}

	public boolean deletePublisher(Publisher publisher) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> publisherList = publisherDao.findAll();	
		if(publisherList.contains(publisher.getPublisherId())) {
			Publisher deletePublisher = new Publisher();
			deletePublisher.setPublisherId(publisher.getPublisherId());
			publisherDao.deletePublisher(deletePublisher);
			return true;
		} 	
			return false;	
	}
	
	
}
