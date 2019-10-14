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
import com.ss.lms.entity.Publisher;
@Component
public class PublisherDao {

	 private DBConnection db;
	 public PublisherDao(DBConnection db) {
	        this.db = db;
	    }

	public List<Integer> findAll() throws SQLException {
		List<Integer> publisherList = new ArrayList<>();
		Connection conn = db.getConnection();
		String query = "SELECT * FROM tbl_publisher";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			publisherList.add(rs.getInt("publisherId"));
		}
		st.close();
		return publisherList;

	}

	public void addPublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = db.getConnection();
			String query = " insert into tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone)"
					+ " values (?,?,?,?)";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, publisher.getPublisherId());
			preparedStmt.setString(2, publisher.getPublisherName());
			preparedStmt.setString(3, publisher.getPublisherAddress());
			preparedStmt.setString(4, publisher.getPublisherPhone());
			preparedStmt.execute();
			System.out.println("Add publisher completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 

	}

	public void updatePublisher(Publisher publisher) {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {
			conn = db.getConnection();
			String sql = "update tbl_publisher set publisherName=?, publisherAddress=?, publisherPhone=?"
					+ " where publisherId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, publisher.getPublisherName());
			stmt.setString(2, publisher.getPublisherAddress());
			stmt.setString(3, publisher.getPublisherPhone());
			stmt.setInt(4, publisher.getPublisherId());
			stmt.executeUpdate();
			System.out.println("Update publisher completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 

	}

	public void deletePublisher(Publisher publisher) {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {
			conn = db.getConnection();
			String sqlDeleteBook = "delete from tbl_book where pubId=?";
			PreparedStatement stmtDeleteBook = conn.prepareStatement(sqlDeleteBook);
			stmtDeleteBook.setInt(1, publisher.getPublisherId());
			stmtDeleteBook.executeUpdate();

			String sql = "delete from tbl_publisher where publisherId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, publisher.getPublisherId());
			stmt.executeUpdate();
			System.out.println("Delete publisher completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 
	}

	

}
