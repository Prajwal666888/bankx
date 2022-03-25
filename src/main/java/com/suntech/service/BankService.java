package com.suntech.service;

import java.util.List;

import com.suntech.domain.Bank;

public interface BankService {

	public Bank createAndSaveBank(Bank bank);

	public Bank createAndSaveBank();

	public List<Bank> fetchAll();

}
