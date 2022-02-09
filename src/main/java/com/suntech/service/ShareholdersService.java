package com.suntech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Shareholders;


public interface ShareholdersService extends JpaRepository<Shareholders, Integer>{

}
