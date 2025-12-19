

interface Displayable {
    void displayAllBooks();
    void displayAvailableBooks();
    void displayBorrowedBooks();
}

public class Library implements Displayable {
   // can contain up to 5 books	
	Book[] books = new Book[5];
	Loan[] loans = new Loan[5];
	
	int bookCount = 0;
	int loanCount = 0;

	
	public int getBookCount() {
		return bookCount;
	}
	public int getLoanCount() {
		return loanCount;
	}
	
	public boolean addBook(Book b) {
		if(bookCount >= 5) {
			System.out.print("Library is full (max of 5 books only).");
			return false;
		}
		
		for(int i=0; i < bookCount; i++) {
			if(books[i].getId() == b.getId()) {
				System.out.println("A book with that ID already exists.");
				return false;
			}
		}
		books[bookCount] = b;
		bookCount++;
		return true;
	}
	
	@Override
	public void displayAllBooks() {
		System.out.println("+=====================================+");
		System.out.println("|              ALL BOOKS              |");
		System.out.println("+=====================================+");
		if(bookCount == 0) {
			System.out.println("No available books.");
			return;
		}
		for(int i = 0; i < bookCount; i++) {
			Book b = books[i];
			System.out.println("ID: " + b.getId() + "\n Title: " + b.getTitle() + "\n Author: " + 
								b.getAuthor().toUpperCase());
		}
		System.out.println("+=====================================+");
		System.out.println("|                END                  |");
		System.out.println("+=====================================+");
	}
	@Override
	public void displayAvailableBooks() {
		
		
	}
	@Override
	public void displayBorrowedBooks() {
		// TODO Auto-generated method stub
		
	}
	public Book getAvailableBookById(int borrowId) {
		int count = 0;
		for (int i = 0; i < bookCount; i++) {
			if(!books[i].isBorrowed()) {
				if(count == borrowId) 
					return books[i];
					count = count + 1;
			}
		}
		return null;
	}
}
