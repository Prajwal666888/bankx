package com.suntech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntech.domain.ExceptionAudit;

/**
 * @author sujayh
 *
 */
public interface ExceptionAuditDao extends JpaRepository<ExceptionAudit, Integer> {

}
