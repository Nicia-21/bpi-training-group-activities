


interface Borrowable {
    void markBorrowed();
    void markReturned();
    boolean isBorrowed();
}

public class Book implements Borrowable{
	
	// adding this "id" to give you an idea on what options you can do
	private String title;
	private String author;
	private Integer id;
	private boolean borrowed;
	
	public Book(String title,String author,int id) {
		this.title = title;
		this.author = author;
		this.id = id;
		this.borrowed = false;
	}

	//Getters
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getId() {
		return id;
	}
	//Setters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void markBorrowed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markReturned() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBorrowed() {
		// TODO Auto-generated method stub
		return false;
	}
}
 
 