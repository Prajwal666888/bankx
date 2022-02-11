package com.suntech.service.support;

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
		branchDao.save(branches);
		return branches;
	}

}
