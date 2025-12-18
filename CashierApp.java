package com.bpi.training.M3_groupactivity1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CashierApp {
	public static void mainMenu() {
		System.out.println("+=====================================+");
		System.out.println("| GROUPACTIVITY#1 | QUEUE OPERATIONS  |");
		System.out.println("+=====================================+");
		System.out.println("| 1. ADD A PRODUCT                    |");
		System.out.println("| 2. PROCESS NEXT PRODUCT             |");
		System.out.println("| 3. CHECK NUMBER OF PRODUCTS         |");
		System.out.println("| 4. VIEW TOTAL BILL SO FAR           |");
		System.out.println("| 5. EXIT                             |");
		System.out.println("+=====================================+");
		System.out.print("ENTER YOUR CHOICE FROM (1-5) ONLY: ");
	}
	public static void main(String[] args) throws InterruptedException{
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//Create a Cashier Queue Object
		ProductQueue productQueue = new ProductQueue();
		
		
		productQueue.addProduct(new Products("Dell",15000),false);
		productQueue.addProduct(new Products("HP",10000),false);
		productQueue.addProduct(new Products("Macbook",38000),false);
		productQueue.addProduct(new Products("Samsung",20000),false);
		productQueue.addProduct(new Products("Lenovo",23000),false);
		
		//Initialize userInput to 0
		int userInp = 0;
		double addProductPrice = 0;
		//Loop continues until user enters 5
		do {
			//call mainMenu method
			mainMenu();
			
			try {
				userInp = input.nextInt(); 
				input.nextLine().trim();              
			}catch (InputMismatchException  e) {
				 System.out.println("INVALID CHOICE! ENTER A VALUE FROM 1 TO 5.");
				 input.nextLine().trim();
				 continue;
			}
			
			switch(userInp) {
			case 1:
				System.out.print("ENTER PRODUCT NAME TO ADD: ");
				String addProductName = input.nextLine().trim();
				System.out.print("ENTER PRODUCT PRICE TO ADD: ");
				addProductPrice = input.nextInt();
				input.nextLine().trim();
				productQueue.addProduct(new Products(addProductName,addProductPrice),true);
				break;
			case 2:
				productQueue.processNexProduct();
				break;
			case 3:
				productQueue.showProducts();
				break;
			case 4:
				productQueue.getTotalBill();
				break;
			case 5:
				productQueue.getFinalTotalBill();
				break;
			default:
				 System.out.println("INVALID CHOICE! ENTER A VALUE FROM 1 TO 5.");
			}
			
		}while(userInp != 5 );
		input.close();
		
	}
	
}
