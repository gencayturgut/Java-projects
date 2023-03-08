package Records;

public class Library {
	
	private Book[] books;
	
	public Library() {
		this.books = new Book[0];
	}

	public Book[] getBooks() {
		Book[] temp=new Book[books.length];
		System.arraycopy(books, 0, temp, 0, books.length);
		return temp;
	}
	
	public void setBooks(Book[] books) {
		this.books = books;
	}
	
	public void add(Book items) {
		
		Book[] books2 = new Book[books.length + 1];
		
		for(int i=0; i<books.length; i++) {
			books2[i] = books[i];
		}
		
		books2[books2.length - 1] = items;
		books = books2;
		
	}

}
