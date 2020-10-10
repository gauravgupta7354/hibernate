package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "demo")
public class sale {

	private String saleId;
	private int quantity;
	private float rate;
	private float amount;
	private int food_id;

	@Id
	@Column(name = "sale_id", unique = true, nullable = false, length = 11)
	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String string) {
		this.saleId = string;
	}

	@Column(name = "quantity", length = 11)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "rate", length = 1000000000)
	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Column(name = "amout", length = 10000000)
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column(name = "food_id", length = 11)
	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

}
