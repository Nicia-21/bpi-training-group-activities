package com.bpi.training.M3_groupactivity1;

public class Products {
	private String productName;
	private double productPrice;
	
	
	public Products(String productName, double productPrice) {
		if(productName == null || productName.isBlank()) {
			System.out.println("PRODUCT NAME CANNOT BE EMPTY!");
			return;
		}
		if(productPrice < 0 ) {
			System.out.println("PRICE CANNOT BE NEGATIVE!");
			return;
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
			System.out.println("PRODUCT NAME CANNOT BE EMPTY!");
		}
		this.productName = productName.trim();
	}
	public void setProductPrice(double productPrice) {
		
		if(productPrice < 0) {
			System.out.println("PRICE CANNOT BE NEGATIVE!\n");
		}
		this.productPrice = productPrice;
	}
}
