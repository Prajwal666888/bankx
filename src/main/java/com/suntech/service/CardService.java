package com.suntech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Card;

public interface CardService extends JpaRepository<Card, Integer>{

}
