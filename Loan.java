

public class Loan {

	private int loanId;
	private User user;
	private Book book;
	
	public Loan(int loanId,User user, Book book) {
		this.loanId = loanId;
		this.user = user;
		this.book = book;
	}

	//Getters
	public int getLoanId() {
		return loanId;
	}
	public User getUser() {
		return user;
	}
	public Book getBook() {
		return book;
	}
	
	
}
