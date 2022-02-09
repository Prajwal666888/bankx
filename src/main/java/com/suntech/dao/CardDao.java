package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Card;

public interface CardDao extends JpaRepository<Card, Integer>{

}
