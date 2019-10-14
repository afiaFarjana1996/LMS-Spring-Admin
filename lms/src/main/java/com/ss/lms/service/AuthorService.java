package com.ss.lms.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ss.lms.dao.AuthorDao;
import com.ss.lms.entity.Author;

@Component
public class AuthorService {

	@Autowired
	AuthorDao authorDao;
	
	public String addAuthor(int authorId, String authorName) throws SQLException {
		List<Integer> authorList = authorDao.findAll();	
		if(!authorList.contains(authorId)) {
			Author author = new Author();
			author.setAuthorId(authorId);
			author.setAuthorName(authorName);
			authorDao.addAuthor(author);
			return "<h3>Add author successfully.</h3>";
		} 	
			return "<h3>Unable to add author.Author id is already exist.</h3>";		
	}
	
	public String updateAuthor(int authorId, String authorName) throws SQLException {
		List<Integer> authorList = authorDao.findAll();	
		if(authorList.contains(authorId)) {
			Author author = new Author();
			author.setAuthorId(authorId);
			author.setAuthorName(authorName);
			authorDao.updateAuthor(author);
			return "<h3>Update author successfully.</h3>";
		} 	
			return "<h3>Unable to update author.Author id doesn't exist.</h3>";	
	}

	public String deleteAuthor(int authorId) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> authorList = authorDao.findAll();	
		if(authorList.contains(authorId)) {
			Author author = new Author();
			author.setAuthorId(authorId);
			authorDao.deleteAuthor(author);
			return "<h3>Delete author successfully.</h3>";
		} 	
			return "<h3>Unable to delete author.Author id doesn't exist.</h3>";	
	}
	
	
}
