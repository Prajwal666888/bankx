package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customerquery")
public class CustomerQuery extends IdDomain {

	@Column(name = "query")
	private String query;

	@Column(name = "resolution")
	private Boolean resolution;

	public CustomerQuery() {
		super();
	}

	public CustomerQuery(String query, Boolean resolution) {
		super();
		this.query = query;
		this.resolution = resolution;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Boolean getResolution() {
		return resolution;
	}

	public void setResolution(Boolean resolution) {
		this.resolution = resolution;
	}

}