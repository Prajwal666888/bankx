package com.suntech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Bank;

public interface BankDao extends JpaRepository<Bank, Integer> {
	
	/**
	 * @param name
	 * @param type
	 * @param head_office
	 * @return
	 */
	public List<Bank> findByNameAndTypeAndHeadOffice(String name,String type,String head_office );
	
	public Bank findTopByOrderByNameDesc( );

}
