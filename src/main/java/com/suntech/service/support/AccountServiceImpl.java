package com.suntech.service.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.AccountDao;
import com.suntech.domain.Account;
import com.suntech.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	protected final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDao accountDao;

	@Override
	@Transactional
	public Account createAndSave(Account account) {
		return accountDao.save(account);
	}

	@Override
	public synchronized Account getLatestAccount() {
		Account account = accountDao.findTopByOrderByAccountNoDesc();
		return account;
	}


}
