package com.suntech.service;

import java.util.List;

import com.suntech.domain.Branches;

public interface BranchService {

	
	public Boolean checkBranch(Branches branch);
	
	public List<Branches> fetchAll();

	public Branches createAndSaveBranches();

	public Branches createAndSaveBranch(Branches branches);

}
