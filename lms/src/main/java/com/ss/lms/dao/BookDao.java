package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ss.lms.db.DBConnection;
import com.ss.lms.entity.Book;

@Component
public class BookDao {
	 private DBConnection db;
	 public BookDao(DBConnection db) {
	        this.db = db;
	    }

	public List<Integer> findAll() {

		List<Integer> bookList = new ArrayList<>();
		try {
			Connection conn = db.getConnection();
			String query = "SELECT * FROM tbl_book";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				bookList.add(rs.getInt("bookId"));
			}
			st.close();
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 
		return bookList;

	}

	public void addBook(Book book) {
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = db.getConnection();
			String query = " insert into tbl_book (bookId, title, authId, pubId)" + " values (?,?,?,?)";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, book.getBookId());
			preparedStmt.setString(2, book.getTitle());
			preparedStmt.setInt(3, book.getAuthor().getAuthorId());
			preparedStmt.setInt(4, book.getPublisher().getPublisherId());
			preparedStmt.execute();
			System.out.println("Add book completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 

	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = db.getConnection();
			String query = "update tbl_book set title=?,authId=?,pubId=? where bookId=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, book.getTitle());
			stmt.setInt(2, book.getAuthor().getAuthorId());
			stmt.setInt(3, book.getPublisher().getPublisherId());
			stmt.setInt(4, book.getBookId());
			stmt.executeUpdate();
			System.out.println("Update book completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 

	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {
			conn = db.getConnection();

			String sqlDeleteBookLoan = "delete from tbl_book_loans where bookId=?";
			PreparedStatement stmtDeleteBookLoan = conn.prepareStatement(sqlDeleteBookLoan);
			stmtDeleteBookLoan.setInt(1, book.getBookId());
			stmtDeleteBookLoan.executeUpdate();

			String sqlDeleteBookCopy = "delete from tbl_book_copies where bookId=?";
			PreparedStatement stmtDeleteBookCopy = conn.prepareStatement(sqlDeleteBookCopy);
			stmtDeleteBookCopy.setInt(1, book.getBookId());
			stmtDeleteBookCopy.executeUpdate();

			String query = " delete from tbl_book where bookId=?";
			PreparedStatement stmtDeleteBook = conn.prepareStatement(query);
			stmtDeleteBook.setInt(1, book.getBookId());
			stmtDeleteBook.executeUpdate();
			System.out.println("Delete book completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 

	}

}
