package com.suntech.service.support;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
	public Bank createAndSaveBank(Bank bank) {
		bankDao.save(bank);
		return bank;
	}

	@Override
	public Bank createAndSaveBank() {
		Bank bank = new Bank();
		bank.setName("SBI");
		bank.setHead_office("Banglore");
		bank.setType("centralBank");
		if (validateIfExist(bank.getName(), bank.getType(), bank.getHead_office())) {
			return bankDao.save(bank);
		}
		return bankDao.findByNameAndTypeAndHeadOffice(bank.getName(), bank.getType(), bank.getHead_office()).get(0);
	}

	private boolean validateIfExist(String name, String type, String head_office) {
		if (CollectionUtils.isEmpty(bankDao.findByNameAndTypeAndHeadOffice(name, type, head_office))) {
			return true;
		}
		return false;
	}

	@Override
	public List<Bank> fetchAll() {
		return bankDao.findAll();
	}

}
