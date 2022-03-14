package com.suntech.service.support;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.BankDao;
import com.suntech.dao.BranchDao;
import com.suntech.domain.Bank;
import com.suntech.domain.Branches;
import com.suntech.service.BankService;
import com.suntech.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private BankService bankService;

	@Autowired
	private BankDao bankDao;

	public Branches createAndSaveBranch(Branches branches) {
//		if(validateBranch(branches)) {
		branchDao.save(branches);
//		System.out.println(" Branch data saved successfully!");
//		} else {
//			System.out.println("Branch data is not saved!");
//		}

		return branches;
	}

	@Override
	public Boolean checkBranch(Branches branch) {
		List<Branches> allBranches = branchDao.findAll();
		for (Branches b : allBranches) {
			if (b.equals(branch))
				return true;
		}
		return false;
	}

	// check for existing branches
//	public Boolean validateBranch(Branches branches) {
//		List<Branches> branchList = branchDao.findAll();
//			
//			for(Branches b:branchList) {
//				if(b.getLocation().equalsIgnoreCase(branches.getLocation())) {
//					return Boolean.TRUE;
//				}
//			}
//			return Boolean.FALSE;
//	}
	public Branches createAndSaveBranches() {
		Branches branch = new Branches(); //initalizing Branches object to branch variable 
		branch.setLocation("Hubli");
		branch.setType("State");
		branch.setBank(bankService.createAndSaveBank());
		
		if (!validateIfExist(branch.getBank(), branch.getLocation(), branch.getType())) {
			branchDao.save(branch);
		}
		return branch;
	}

	private boolean validateIfExist(Bank bank, String location, String type) {
		if (!CollectionUtils.isEmpty(branchDao.findByTypeAndLocationAndBank(type, location , bank))) {
			System.out.println("reached validateIfExist ");
			return true;
		}
		System.out.println("reached validateIfExist ");
		return false;
	}

	@Override
	public List<Branches> fetchAll() {
		// TODO Auto-generated method stub
		return branchDao.findAll();
	}

}
