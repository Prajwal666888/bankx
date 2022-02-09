package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Shares;

public interface SharesDao extends JpaRepository<Shares, Integer>{

}
