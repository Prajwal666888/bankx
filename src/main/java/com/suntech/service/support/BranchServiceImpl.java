package com.suntech.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.BranchDao;
import com.suntech.domain.Branches;
import com.suntech.service.BranchService;

import io.micrometer.core.instrument.config.validate.Validated.Valid;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;
	
	private String branchLocation;

	@Override
	public Branches createAndSaveBranch(Branches branches) {
		if(validateBranch(branches)) {
		branchDao.save(branches);
		}
		
		return branches;
	}
	
	public Boolean validateBranch(Branches branches) {
		Boolean flag=false;
		List<Branches> branchList = branchDao.findAll();
			
			for(Branches b:branchList) {
				if(b.getLocation().equalsIgnoreCase(branches.getLocation())) {
					flag=true;
					break;	
				}
			}
			if(flag) {
				return true;
			}else  {
				System.out.println("Branch doesn't exist");
				return false;
			}
	}

}
