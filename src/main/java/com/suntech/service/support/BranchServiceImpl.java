package com.suntech.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.BranchDao;
import com.suntech.domain.Branches;
import com.suntech.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;
	
	@Override
	public Branches createAndSaveBranch(Branches branches) {
//		if(validateBranch(branches)) {
		branchDao.save(branches);
//		System.out.println(" Branch data saved successfully!");
//		} else {
//			System.out.println("Branch data is not saved!");
//		}
		
		return branches;
	}
	
	//check for existing branches
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
	}

