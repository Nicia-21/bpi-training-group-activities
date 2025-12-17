package com.bpi.training.M3_groupactivity1;
import java.util.LinkedList;
import java.util.Queue;

public class CashierQueue {
	private Queue<Products> productQueue;
	private double totalBill;
	
	public CashierQueue() {
		productQueue = new LinkedList<>();
		totalBill = 0.0;
	}

	//Method to add a new product at the end of the queue
	public void addProduct(Products products,boolean showMessage) {
		productQueue.add(products);
		if(showMessage) {
			System.out.println("PRODUCT ADDED TO CHECKOUT LINE: " + products.getProductName()
	            + " (₱" + String.format("%.2f", products.getProductPrice()) + ")"
	        );
		}
	}
	//Show products waiting in queue
	public void showProducts() {
		if(productQueue.isEmpty()) {
			System.out.println("QUEUE IS EMPTY!");
		}
		for(Products product: productQueue) {
			System.out.println("-" + product.getProductName());
		}
		System.out.println("PRODUCTS LEFT IN QUEUE: " + productQueue.size());
	}
	//Process next product
	public void processNexProduct() throws InterruptedException{
		Products nextProduct = productQueue.poll();
		if(nextProduct == null) {
			System.out.println("NO PRODUCTS IN THE QUEUE. NOTHING TO PROCESS.");
			return;
		}
		totalBill += nextProduct.getProductPrice();
		System.out.println("PROCESSED: " + nextProduct.getProductName());
        System.out.println("TOTAL BILL SO FAR: ₱" + String.format("%.2f", totalBill));
	}
	public double getTotalBill() {
		System.out.print("TOTAL BILL SO FAR: " + totalBill + " \n ");
		return totalBill;
	}
}
