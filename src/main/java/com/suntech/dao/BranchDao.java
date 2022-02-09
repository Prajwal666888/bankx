package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Branch;

public interface BranchDao extends JpaRepository<Branch, Integer>{

}
