package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "demo")
public class food {

	private String saleId;
	private String name;
	private int companyId;

	@Id
	@Column(name = "sale_id", unique = true, nullable = false, length = 11)
	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleid) {
		this.saleId = saleid;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "companyId", length = 11)
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
