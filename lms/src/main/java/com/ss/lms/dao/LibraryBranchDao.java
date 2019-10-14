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
import com.ss.lms.entity.LibraryBranch;
@Component
public class LibraryBranchDao {
	 private DBConnection db;
	 public LibraryBranchDao(DBConnection db) {
	        this.db = db;
	    }


	public List<Integer> findAll() throws SQLException {

		List<Integer> branchList = new ArrayList<>();
		Connection conn = db.getConnection();

		String query = "SELECT * FROM tbl_library_branch";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			branchList.add(rs.getInt("branchId"));
		}
		st.close();

		return branchList;

	}

	public void addLibraryBranch(LibraryBranch libraryBranch) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = db.getConnection();
			String query = " insert into tbl_library_branch (branchId, branchName, branchAddress)" + " values (?,?,?)";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, libraryBranch.getBranchId());
			preparedStmt.setString(2, libraryBranch.getBranchName());
			preparedStmt.setString(3, libraryBranch.getBranchAddress());
			preparedStmt.execute();
			System.out.println("Add library branch completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 
	}

	public void updateLibraryBranch(LibraryBranch libraryBranch) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = db.getConnection();
			String query = "update tbl_library_branch set branchName=?,branchAddress=? where branchId=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			preparedStmt.setString(1, libraryBranch.getBranchName());
			preparedStmt.setString(2, libraryBranch.getBranchAddress());
			preparedStmt.setInt(3, libraryBranch.getBranchId());
			preparedStmt.execute();
			stmt.executeUpdate();
			System.out.println("Update library branch completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 
	}

	public void deleteLibraryBranch(LibraryBranch libraryBranch) {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {
			conn = db.getConnection();
			String sqlDeleteBookLoan = "delete from tbl_book_loans where branchId=?";
			PreparedStatement stmtDeleteBookLoan = conn.prepareStatement(sqlDeleteBookLoan);
			stmtDeleteBookLoan.setInt(1, libraryBranch.getBranchId());
			stmtDeleteBookLoan.executeUpdate();

			String sqlDeleteBookCopy = "delete from tbl_book_copies where branchId=?";
			PreparedStatement stmtDeleteBookCopy = conn.prepareStatement(sqlDeleteBookCopy);
			stmtDeleteBookCopy.setInt(1, libraryBranch.getBranchId());
			stmtDeleteBookCopy.executeUpdate();

			String sql = "delete from tbl_library_branch where branchId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, libraryBranch.getBranchId());
			stmt.executeUpdate();
			System.out.println("Delete library branch completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 
	}

}
