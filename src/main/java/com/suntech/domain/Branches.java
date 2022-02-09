package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Branch")
public class Branches extends IdDomain {

	@Column(name = "id")
	private Integer id;

	@Column(name = "type")
	private String type;

	@Column(name = "location")
	private String location;

	public Branches() {
		super();
	}

	public Branches(String type, String location) {
		this.type = type;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
