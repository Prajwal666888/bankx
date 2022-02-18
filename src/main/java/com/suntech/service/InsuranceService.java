package com.suntech.service;

import java.util.List;

import com.suntech.domain.Insurance;

public interface InsuranceService {
	
	public Insurance createAndSaveInsurance(Insurance insurance);
     

	public List<Insurance> findAll();

	public Insurance find(Integer id);

}
