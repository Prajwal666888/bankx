package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Branches;

public interface BranchDao extends JpaRepository<Branches, Integer>{

}
