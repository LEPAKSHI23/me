package com.capgemini.mps.dto;

public class Mobile {
	
	private int mobileId;
	private String name;
	private Double price;
	private Integer quantity;
	
	public Mobile(){
		
	}
	
	public Mobile(int mobileId, String name, Double price, Integer quantity) {
		super();
		this.mobileId = mobileId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
