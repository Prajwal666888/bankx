package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Loans;

public interface LoanDao extends JpaRepository<Loans,Integer>{

}
