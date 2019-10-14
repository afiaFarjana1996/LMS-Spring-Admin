package com.ss.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.lms.dao.LibraryBranchDao;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.LibraryBranch;

@Component
public class LibraryBranchService {

	@Autowired
	LibraryBranchDao libraryBranchDao;
	
	public String addLibraryBranch(int branchId, String branchName) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> branchList = libraryBranchDao.findAll();	
		if(!branchList.contains(branchId)) {
			LibraryBranch libraryBranch = new LibraryBranch();
			libraryBranch.setBranchId(branchId);
			libraryBranch.setBranchName(branchName);
			libraryBranchDao.addLibraryBranch(libraryBranch);
			return "<h3>Add library branch successfully.</h3>";
		} 	
			return "<h3>Unable to add library branch.Branch id is already exist.</h3>";	
	}

	public String updateLibraryBranch(int branchId, String branchName) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> branchList = libraryBranchDao.findAll();	
		if(branchList.contains(branchId)) {
			LibraryBranch libraryBranch = new LibraryBranch();
			libraryBranch.setBranchId(branchId);
			libraryBranch.setBranchName(branchName);
			libraryBranchDao.updateLibraryBranch(libraryBranch);
			return "<h3>Update library branch successfully.</h3>";
		} 	
			return "<h3>Unable to update library branch.Branch id doesn't exist.</h3>";	
	}

	public String deleteLibraryBranch(int branchId) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> branchList = libraryBranchDao.findAll();	
		if(branchList.contains(branchId)) {
			LibraryBranch libraryBranch = new LibraryBranch();
			libraryBranch.setBranchId(branchId);
			libraryBranchDao.deleteLibraryBranch(libraryBranch);
			return "<h3>Delete library branch successfully.</h3>";
		} 	
			return "<h3>Unable to delete library branch.Branch id doesn't exist.</h3>";	
	}

}
