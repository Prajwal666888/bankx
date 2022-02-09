package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.Insurance;

public interface InsuranceDao extends JpaRepository<Insurance, Integer> {

}
