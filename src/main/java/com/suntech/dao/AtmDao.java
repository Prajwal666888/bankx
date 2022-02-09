package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Atm;

public interface AtmDao extends JpaRepository<Atm, Integer> {

}
