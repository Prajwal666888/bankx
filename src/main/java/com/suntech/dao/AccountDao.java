package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Account;


public interface AccountDao extends JpaRepository<Account, Integer>{

	Account findTopByOrderByAccountNoDesc();
	
}
