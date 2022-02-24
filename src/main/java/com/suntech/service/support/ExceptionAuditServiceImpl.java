package com.suntech.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.ExceptionAuditDao;
import com.suntech.domain.ExceptionAudit;
import com.suntech.service.ExceptionAuditService;

/**
 * @author sujayh
 *
 */
@Service("myExceptionAuditService")
public class ExceptionAuditServiceImpl implements ExceptionAuditService {
	
	@Autowired
	private ExceptionAuditDao exceptionAuditDao;

	@Override
	public ExceptionAudit createAndSaveBank(ExceptionAudit exceptionAudit) {
		exceptionAuditDao.save(exceptionAudit);
		return exceptionAudit;
	}

}
