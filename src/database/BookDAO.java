package database;

import java.util.List;

import entity.Book;

public interface BookDAO {
	
	public void addBook();
	
	public List<Book> getAllBooks();
	
	public List<Book> getBookByCategory();
	
	public List<Book> getBookByAuthor();
	
	public List<Book> getBookByTitle();
	
	public void updateBook(Book book);
	
	public void updateQuantity(int quantity);
	
	

}
