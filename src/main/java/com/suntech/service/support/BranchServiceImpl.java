package com.suntech.service.support;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.suntech.domain.Branches;
import com.suntech.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Override
	@Transactional
	public Branches createAndSaveBranch(Branches branches) {
		return branches;
	}

}
