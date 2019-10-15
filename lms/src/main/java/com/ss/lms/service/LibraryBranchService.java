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
	
	public boolean addLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> branchList = libraryBranchDao.findAll();	
		if(!branchList.contains(libraryBranch.getBranchId())) {
			LibraryBranch newBranch = new LibraryBranch();
			newBranch.setBranchId(libraryBranch.getBranchId());
			newBranch.setBranchName(libraryBranch.getBranchName());
			libraryBranchDao.addLibraryBranch(newBranch);
			return true;
		} 	
			return false;
	}

	public boolean updateLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		// TODO Auto-generated method stub
		
		List<Integer> branchList = libraryBranchDao.findAll();	
		if(branchList.contains(libraryBranch.getBranchId())) {
			LibraryBranch newBranch = new LibraryBranch();
			newBranch.setBranchId(libraryBranch.getBranchId());
			newBranch.setBranchName(libraryBranch.getBranchName());
			libraryBranchDao.updateLibraryBranch(newBranch);
			return true;
		} 	
			return false;
	}

	public boolean deleteLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		// TODO Auto-generated method stub
		
		List<Integer> branchList = libraryBranchDao.findAll();	
		if(branchList.contains(libraryBranch.getBranchId())) {
			LibraryBranch deleteBranch = new LibraryBranch();
			deleteBranch.setBranchId(libraryBranch.getBranchId());
			libraryBranchDao.deleteLibraryBranch(deleteBranch);
			return true;
		} 	
			return false;
	}

}
