package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Bank;

public interface BankDao extends JpaRepository<Bank, Integer> {

}
