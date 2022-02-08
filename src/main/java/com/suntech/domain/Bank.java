package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank extends IdDomain {
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="Head_Office")
	private String head_office;

	public Bank(String name, String type, String head_office) {
		super();
		this.name = name;
		this.type = type;
		this.head_office = head_office;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHead_office() {
		return head_office;
	}

	public void setHead_office(String head_office) {
		this.head_office = head_office;
	}
	
	
}
