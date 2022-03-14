package com.suntech.service.support;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.AccountTypeDao;
import com.suntech.domain.AccountType;
import com.suntech.domain.Branches;
import com.suntech.service.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

	@Autowired 
	private AccountTypeDao accountTypeDao;

	@Override
	@Transactional
	public AccountType createAndSave(AccountType accountType) {
		accountTypeDao.save(accountType);
		return accountType;
	}

	@Override
	public Branches createAndSave(Branches branch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountType> fetchAll() {
		return accountTypeDao.findAll();
	}

	@Override
	public AccountType createAndSaveAccountType() {
		AccountType accountype=new AccountType();
		accountype.setType("current");
		accountype.setInterestRate(2.5);
		accountype.setDepositAmount(5636.00);
		accountype.setWithdrawlLimit(23244.00);
		accountype.setTransactionLimit(122520.00);
	if(!validateIfExist(accountype.getType(),accountype.getInterestRate(),accountype.getDepositAmount(),accountype.getWithdrawlLimit(),accountype.getTransactionLimit())){
		accountTypeDao.save(accountype);
			
		}
		return accountype;
	}
	
	private boolean validateIfExist(String type,Double transactionLimit,Double withdrawlLimit, Double depositAmount,Double interestRate) {
	if(!CollectionUtils.isEmpty(accountTypeDao.findByTypeAndTransactionLimitAndDepositAmountAndWithdrawlLimitAndInterestRate(type, transactionLimit, depositAmount, withdrawlLimit, interestRate))) {
    System.out.println("Reached  validateIfExist");
    return true;
	}
	System.out.println("validate");
	return false;
	}
}
