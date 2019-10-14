package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.springframework.stereotype.Component;

import com.ss.lms.db.DBConnection;
import com.ss.lms.entity.Author;

@Component
public class AuthorDao {
	 private DBConnection db;
	 public AuthorDao(DBConnection db) {
	        this.db = db;
	    }
	 public List<Integer> findAll() throws SQLException {
			List<Integer> authorList = new ArrayList<>();
			Connection conn = db.getConnection();
			String query = "SELECT * FROM tbl_author";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				authorList.add(rs.getInt("authorId"));
			}
			st.close();
			return authorList;
		}
	 
	public void addAuthor(Author author) {	
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = db.getConnection();
			String query = " insert into tbl_author (authorId, authorName)" + " values (?,?)";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, author.getAuthorId());
			preparedStmt.setString(2, author.getAuthorName());
			preparedStmt.execute();
			System.out.println("Add author completed");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	
	}
	public void updateAuthor(Author author) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = db.getConnection();
			String sql = "update tbl_author set authorName=? where authorId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, author.getAuthorName());
			stmt.setInt(2, author.getAuthorId());
			stmt.executeUpdate();
			System.out.println("Update author completed");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}	
	}
	
	public void deleteAuthor(Author author) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = db.getConnection();
			String sqlDeleteBook = "delete from tbl_book where authId=?";
			PreparedStatement stmtDeleteBook = conn.prepareStatement(sqlDeleteBook);
			stmtDeleteBook.setInt(1, author.getAuthorId());
			stmtDeleteBook.executeUpdate();

			String sql = "delete from tbl_author where authorId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, author.getAuthorId());
			stmt.executeUpdate();
			System.out.println("Delete author completed");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}	
	}
	
}