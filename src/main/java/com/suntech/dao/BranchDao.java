package com.suntech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Bank;
import com.suntech.domain.Branches;

public interface BranchDao extends JpaRepository<Branches, Integer>{
	
	public List<Branches> findByTypeAndLocationAndBank(String type,String location,Bank bank );


}
