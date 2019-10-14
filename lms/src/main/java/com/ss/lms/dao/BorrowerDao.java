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
import com.ss.lms.entity.Borrower;
@Component
public class BorrowerDao {
	 private DBConnection db;
	 public BorrowerDao(DBConnection db) {
	        this.db = db;
	    }

	public List<Integer> findAll() throws SQLException {

		List<Integer> borrowerList = new ArrayList<>();
		Connection conn = db.getConnection();

		String query = "SELECT * FROM tbl_borrower";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			borrowerList.add(rs.getInt("cardNo"));
		}
		st.close();

		return borrowerList;

	}

	public void addBorrower(Borrower borrower) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = db.getConnection();
			String query = " insert into tbl_borrower (cardNo, name, address, phone)" + " values (?,?,?,?)";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, borrower.getCardNo());
			preparedStmt.setString(2, borrower.getName());
			preparedStmt.setString(3, borrower.getAddress());
			preparedStmt.setString(4, borrower.getPhone());
			preparedStmt.execute();
			System.out.println("Add borrower completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 

	}

	public void updateBorrower(Borrower borrower) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = db.getConnection();

			String sql = "update tbl_borrower set name=?,address=?,phone=? where cardNo=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, borrower.getName());
			stmt.setString(2, borrower.getAddress());
			stmt.setString(3, borrower.getPhone());
			stmt.setInt(4, borrower.getCardNo());
			stmt.executeUpdate();
			System.out.println("Update borrower completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 
	}

	public void deleteBorrower(Borrower borrower) {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {
			conn = db.getConnection();

			String sqlDeleteBook = "delete from tbl_book_loans where cardNo=?";
			PreparedStatement stmtDeleteBook = conn.prepareStatement(sqlDeleteBook);
			stmtDeleteBook.setInt(1, borrower.getCardNo());
			stmtDeleteBook.executeUpdate();

			String sql = "delete from tbl_borrower where cardNo=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, borrower.getCardNo());
			stmt.executeUpdate();

			System.out.println("Delete borrower completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 

	}

	

}
