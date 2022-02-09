package com.suntech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Shares;

public interface SharesService extends JpaRepository<Shares, Integer>{

}
