package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author stephan 
 *
 */
@Entity
@Table(name="shareholder")
public class Shareholders extends IdDomain{
	
	@Column(name="name")
	private String name;
	
	

	
	public Shareholders() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Shareholders(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
