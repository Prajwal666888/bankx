package com.suntech.service.support;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.InsuranceDao;
import com.suntech.domain.Insurance;
import com.suntech.service.InsuranceService;

@Service
@Transactional
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceDao insuranceDao;

	@Override
	
	public Insurance createAndSaveInsurance(Insurance insurance) {
		insuranceDao.save(insurance);
		return insurance;
	}
	
	@Override
	
    public Insurance find(Integer id)
    {
    	return insuranceDao.findById(id).get();
    }
    
	@Override
	public List<Insurance> findAll() {
		// TODO Auto-generated method stub
		return (List<Insurance>) insuranceDao.findAll();
	}

}
