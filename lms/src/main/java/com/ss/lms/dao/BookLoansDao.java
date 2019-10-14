package com.ss.lms.dao;


import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ss.lms.db.DBConnection;
import com.ss.lms.entity.BookLoans;

@Component
public class BookLoansDao {

	 private DBConnection db;
	 public BookLoansDao(DBConnection db) {
	        this.db = db;
	    }

	public void overrideDuedate(BookLoans bookloan) {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {
			conn = db.getConnection();

			String sql = "update tbl_book_loans set dueDate=? where bookId=? and branchId=? and cardNo=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setTimestamp(1, new Timestamp(bookloan.getDueDate().getTime()));
			stmt.setInt(2, bookloan.getBook().getBookId());
			stmt.setInt(3, bookloan.getLibraryBranch().getBranchId());
			stmt.setInt(4, bookloan.getBorrower().getCardNo());
			stmt.executeUpdate();
			System.out.println("Over-ride due date completed!");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} 		

	}

}
