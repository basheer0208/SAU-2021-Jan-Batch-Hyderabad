package com.accolite.demo.model;


import javax.validation.constraints.NotNull;


public class Order {
	@NotNull(message = "Must have Id")
	private int id;
	
	@NotNull(message = "Name can't be empty")
	private String name;
	@NotNull(message = "Email Id can't be empty")
	private String emailId;
	@NotNull(message = "Phone can't be empty")
	private String phone;
	
	private String product;

	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	//
	
	
	
}
