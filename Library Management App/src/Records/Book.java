package Records;

public class Book {
	
	private String ID;
	private String Title;
	private String Author;
	private String Publisher;
	private int Edition;
	private String Genre;
	private int Quantity;
	
	public Book() {}
	
	public Book(String ID, String Title, String Author,
			String Publisher, int Edition, String Genre, int Quantity) {
		this.ID = ID;
		this.Title = Title;
		this.Author = Author;
		this.Publisher = Publisher;
		this.Edition = Edition;
		this.Genre = Genre;
		this.Quantity = Quantity;
	}
	
	public Book(Book copy) {
		ID = copy.getID();
		Title = copy.getTitle();
		Author = copy.getAuthor();
		Publisher = copy.getPublisher();
		Edition = copy.getEdition();
		Genre = copy.getGenre();
		Quantity = copy.getQuantity();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public int getEdition() {
		return Edition;
	}

	public void setEdition(int edition) {
		Edition = edition;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String toString() {
		return "Book [ID=" + ID + ", Title=" + Title + ", Author=" + Author + ", Publisher=" + Publisher + ", Edition="
				+ Edition + ", Genre=" + Genre + ", Quantity=" + Quantity + "]";
	}
}
