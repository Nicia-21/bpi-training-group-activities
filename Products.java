package com.bpi.training.M3_groupactivity1;

public class Products {
	private String productName;
	private double productPrice;
	
	
	public Products(String productName, int productPrice) {
		if(productName == null || productName.isBlank()) {
			throw new IllegalArgumentException("PRODUCT NAME CANNOT BE EMPTY!");
		}
		if(productPrice < 0) {
			throw new IllegalArgumentException("PRICE CANNOT BE NEGATIVE!");
		}
		this.productName = productName.trim();
		this.productPrice = productPrice;
	}
	//Getters
	public String getProductName() {
		return productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	//Setters
	public void setProductName(String productName) {
		if(productName == null || productName.isBlank()) {
			throw new IllegalArgumentException("PRODUCT NAME CANNOT BE EMPTY!");
		}
		this.productName = productName.trim();
	}
	public void setProductPrice(double productPrice) {
		if(productPrice < 0) {
			throw new IllegalArgumentException("PRICE CANNOT BE NEGATIVE!");
		}
		this.productPrice = productPrice;
	}
}
