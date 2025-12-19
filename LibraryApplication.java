/*
 * 1. Upon application start, ask user to create one User
 * 2. Create one Library object
 * 3. Initialize 5 Book objects and add it to all Library slots
 * 4. Display options:
 * 
 * - [1] Display All Books
 * - [2] Display Available Books
 * - [3] Display All Borrowed Books
 * - [4] Borrow Book
 * - [5] Return Book
 * - [6] Exit
 * 
 * - user selects the number of the option
 * ===============================================
 * 
 *	 [1] Display All Books
 * - Display all Books (ID, Title and Author) regardless if there is a Loan existing for that Book.
 *   
 *   [2] Display Available Books
 * - Display Books that do not have a Loan slot
 * 
 *   [3] Display All Borrowed Books 
 * - Display Books that have a Loan equivalent.
 * - Display the Book title and the User name of borrower
 *   
 *	 [4] Borrow Book
 * - Displays all available books and User selects what book to borrow
 * - Create a Loan object, set Loan id set Book and set User to current user
 * 
 * 	 [5] Return Book
 * - Display all Loans, user selects the Loan and removes that from the slot
 * 
 *   [6] Exit
 * - Stops the program  
 * */
import java.util.Scanner;


interface Startable {
    void start();
}


public class LibraryApplication implements Startable{
	private User currentUser;
	private Library library = new Library();
	private Scanner scanner = new Scanner(System.in);
	
	//MainMenu
	public static void displayMainMenu() {
		System.out.println("+=====================================+");
		System.out.println("| M2-GROUP PROJECT1 |   BOOK LIBRARY  |");
		System.out.println("+=====================================+");
		System.out.println("| 1. DISPLAY ALL BOOKS                |");
		System.out.println("| 2. DISPLAY AVAILABLE BOOKS          |");
		System.out.println("| 3. DISPLAY ALL BORROWED BOOKS       |");
		System.out.println("| 4. BORROW BOOK                      |");
		System.out.println("| 5. RETURN BOOK                      |");
		System.out.println("| 6. EXIT                             |");
		System.out.println("+=====================================+");
		System.out.print("ENTER YOUR CHOICE FROM (1-6) ONLY: ");
	}
	
	public LibraryApplication() {
		
	}
	
	@Override
	public void start() {
		this.library = new Library();
		this.scanner = new Scanner(System.in);

		System.out.print("Enter your ID: ");
		int userId = safeParseInt(scanner.nextLine());
		if (userId < 0 ) {
			userId = 1;
		}
		System.out.print("Enter your Name: ");
		String userName = scanner.nextLine().trim();
		
		if(userName.length() == 0) userName = "User";
		this.currentUser = new User(userId,userName);
		
		//Initialize 5 Book objects(Title of the book,Author and Id)
		library.addBook(new Book("Dog Man","Dav Pilkey",1));
		library.addBook(new Book("Mickey7","Edward Ashton",2));
		library.addBook(new Book("Frankenstein","Mary Shelley",3));
		library.addBook(new Book("The Odyssey","Homer",4));
		library.addBook(new Book("I Know What You Did Last Summer","Lois Duncan",5));
		
		//Initialize userInput to 0
		int choice;
		do {
			//call mainMenu method
			displayMainMenu();

			String raw = scanner.nextLine().trim();
            choice = safeParseInt(raw);

			switch(choice) {
			case 1:
				library.displayAllBooks();
				break;
			case 4:
				borrowBookFlow();
				break;
			case 5:
				break;
			case 6:
				System.out.println("EXITING..........");
				break;
			default:
				 System.out.println("INVALID CHOICE! ENTER A VALUE FROM 1 TO 5.");
			}
		}while(choice != 6 );
		scanner.close();

	}

	private void borrowBookFlow() {
		System.out.println("\nAvailable: ");
		library.displayAllBooks();
		System.out.println("Enter Book Id to borrow: ");
		int borrowId = safeParseInt(scanner.nextLine());
		currentUser.borrowByAvailableId(library, borrowId);
	}
	
	private int safeParseInt(String raw) {
		if(raw == null || raw.length() == 0 )
		return -1;
		int v = 0;
		for(int i = 0; i < raw.length();i++) {
			char c = raw.charAt(i);
			if(c < '0' || c > '9') 
				return -1;
			v = v * 10 + (c - '0');
		}
		return v;
	}
}
