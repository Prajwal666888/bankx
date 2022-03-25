package com.suntech.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.suntech.dao.AccountTypeDao;
import com.suntech.dao.BankDao;
import com.suntech.dao.BranchDao;
import com.suntech.domain.AccountType;
import com.suntech.domain.Bank;
import com.suntech.domain.Branches;

public class ValidationUtils {

	@Autowired
	private static BankDao bankDao;
	
	@Autowired
	private static AccountTypeDao accountTypeDao;
	
	@Autowired
	private static BranchDao branchDao;

	public static Boolean checkBank(Bank bank) {
		List<Bank> allBanks = bankDao.findAll();
		for(Bank b:allBanks) {
			if(bank.equals(b)) {
				return true;
			}
		}
		return false;
	}
	
	public static Boolean checkAccountTypeDao(AccountType accountType) {
		
		List<AccountType> allAccountTypes = accountTypeDao.findAll();
		for(AccountType at :allAccountTypes) {
			if(at.equals(accountType)) 
				return true;
		}
		return false;
	}
	
	public static Boolean checkBranch(Branches branch) {
		List<Branches> allBranches = branchDao.findAll();
		for(Branches b:allBranches) {
			if(b.equals(branch))
				return true;
		}
		return false;
	}
	
	

}
