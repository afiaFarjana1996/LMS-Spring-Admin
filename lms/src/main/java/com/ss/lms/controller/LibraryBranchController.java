package com.ss.lms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.service.BorrowerService;
import com.ss.lms.service.LibraryBranchService;

@RestController
public class LibraryBranchController {

	@Autowired
	LibraryBranchService libraryBranchService;
	
	@RequestMapping(value = "/lms/add_libraryBranch/branchId/{branchId}/branchName/{branchName}")
	public String addLibraryBranch(@PathVariable int branchId,@PathVariable String branchName) throws SQLException {
		return libraryBranchService.addLibraryBranch(branchId, branchName);
	}
	
	@RequestMapping(value = "/lms/update_libraryBranch/branchId/{branchId}/branchName/{branchName}")
	public String updateLibraryBranch(@PathVariable int branchId,@PathVariable String branchName) throws SQLException {
		return libraryBranchService.updateLibraryBranch(branchId, branchName);
	}
	
	@RequestMapping(value = "/lms/delete_libraryBranch/branchId/{branchId}")
	public String deleteLibraryBranch(@PathVariable int branchId) throws SQLException {
		return libraryBranchService.deleteLibraryBranch(branchId);
	}			
	
}
