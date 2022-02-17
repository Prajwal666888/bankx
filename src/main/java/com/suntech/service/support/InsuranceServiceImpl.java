package com.suntech.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.InsuranceDao;
import com.suntech.domain.Insurance;
import com.suntech.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceDao insuranceDao;

	@Override
	public Insurance createAndSaveInsurance(Insurance insurance) {
		insuranceDao.save(insurance);
		return insurance;
	}

}
