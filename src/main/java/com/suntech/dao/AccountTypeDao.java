package com.suntech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.AccountType;

public interface AccountTypeDao extends JpaRepository<AccountType, Integer>{
	
	public List<AccountType> findByTypeAndTransactionLimitAndDepositAmountAndWithdrawlLimitAndInterestRate(String type,Double transactionLimit,Double depositAmount,Double withdrawlLimit,Double interestRate);

}