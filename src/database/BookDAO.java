package database;

import java.util.List;

import entity.Book;

public interface BookDAO {
	
	public boolean addBook(Book book);
	
	public List<Book> getAllBooks();
	
	public List<Book> getBookByCategory();
	
	public List<Book> getBookByAuthor();
	
	public List<Book> getBookByTitle();
	
	public void updateBook(Book book);
	
	public void updateQuantity(int quantity);
	
	

}
