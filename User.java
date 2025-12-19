public class User{
		
	private String name;
	private Loan[] loans = new Loan[5];
	private int loanCount = 0;
	private int id;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getLoanCount() {
		return loanCount;
	}
	public int getId()
	{
		return id;
	}
	public void borrowByAvailableId(Library library, int borrowId) {
		if(loanCount >= 5 ) {
			System.out.println("You have already borrowed 5 books.");
			return;
		}
		Book book = library.getAvailableBookById(borrowId);
		if (book == null) {
			System.out.println("Invalid input. No such available books.");
			return;
		}
	}
}
