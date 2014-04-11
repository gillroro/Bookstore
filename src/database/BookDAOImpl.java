package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class BookDAOImpl implements BookDAO {
	private Connection connection;
	private PreparedStatement addBook;
	private PreparedStatement getBooks;
	private ResultSet results;
	private String title;
	private String author;
	private String category;
	private double price;
	private String image;
	private int quantity;
	private List<Book> books = new ArrayList<Book>();


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public boolean addBook(Book book) {
		boolean added = false;
		try {
			connection = ConnectionFactory.getConnection();
			addBook = connection.prepareStatement("INSERT INTO book (title, author, price, category, image, quantity) VALUES (?,?,?,?,?,?)");

			addBook.setString(1, book.getTitle());
			addBook.setString(2, book.getAuthor());
			addBook.setDouble(3, book.getPrice());
			addBook.setString(4, book.getCategory());
			addBook.setString(5, book.getImage());
			addBook.setInt(6, book.getQuantity());
			int count = addBook.executeUpdate();
			if(count == 1){
				added=true;
			}
			addBook.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public List<Book> getAllBooks() {
		return null;
	}

	@Override
	public List<Book> getBookByCategory() {	
		return null;
	}

	@Override
	public List<Book> getBookByAuthor() {
		return null;
	}

	@Override
	public List<Book> getBookByTitle() {
		return null;
	}

	@Override
	public void updateBook(Book book) {		
	}

	@Override
	public void updateQuantity(int quantity) {		
	}

}
