package com.ss.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.ss.lms.dao.AuthorDao;
import com.ss.lms.entity.Author;

@Component
public class AuthorService {

	@Autowired
	AuthorDao authorDao;

	public boolean addAuthor(Author author) throws SQLException {
		List<Integer> authorList = authorDao.findAll();
		if (!authorList.contains(author.getAuthorId())) {
			Author newAuthor = new Author();
			newAuthor.setAuthorId(author.getAuthorId());
			newAuthor.setAuthorName(author.getAuthorName());
			authorDao.addAuthor(newAuthor);
			return true;
		}
		return false;

	}

	public boolean updateAuthor(Author author) throws SQLException {
		List<Integer> authorList = authorDao.findAll();
		if (authorList.contains(author.getAuthorId())) {
			Author uopdateAuthor = new Author();
			uopdateAuthor.setAuthorId(author.getAuthorId());
			uopdateAuthor.setAuthorName(author.getAuthorName());
			authorDao.updateAuthor(uopdateAuthor);
			return true;
		}
		return false;
	}

	public boolean deleteAuthor(Author author) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> authorList = authorDao.findAll();
		if (authorList.contains(author.getAuthorId())) {
			Author deleteAuthor = new Author();
			deleteAuthor.setAuthorId(author.getAuthorId());
			authorDao.deleteAuthor(deleteAuthor);
			return true;
		}
		return false;
	}

}
