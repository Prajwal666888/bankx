package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
