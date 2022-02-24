package com.suntech.service.support;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.BankDao;
import com.suntech.domain.Bank;
import com.suntech.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;

	@Override
	@Transactional
	public Bank createAndSaveBank(Bank bank) {
		bankDao.save(bank);
		return bank;
	}

}
