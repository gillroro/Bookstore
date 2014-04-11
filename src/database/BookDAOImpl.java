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
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public List<Book> getAllBooks() {
		try{
		connection = ConnectionFactory.getConnection();
		getBooks= connection.prepareStatement("SELECT * FROM book");
		results = getBooks.executeQuery();
		while(results.next()){
			Book book = new Book();
			book.setTitle(results.getString("title"));
			book.setAuthor(results.getString("author"));
			book.setCategory(results.getString("category"));
			book.setPrice(results.getDouble("price"));
			book.setImage(results.getString("image"));
			book.setQuantity(results.getInt("quantity"));
			books.add(book);
		}
		connection.close();
		getBooks.close();
		results.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> getBookByCategory() {	
		try{
		connection = ConnectionFactory.getConnection();
		getBooks = connection.prepareStatement("SELECT * FROM book WHERE category LIKE ?");
		getBooks.setString(1, "%"+category+"%");
		results = getBooks.executeQuery();
		while(results.next()){
			Book book = new Book();
			book.setTitle(results.getString("title"));
			book.setAuthor(results.getString("author"));
			book.setPrice(results.getDouble("price"));
			book.setImage(results.getString("image"));
			book.setCategory(results.getString("category"));
			book.setQuantity(results.getInt("quantity"));
			books.add(book);
		}
		connection.close();
		results.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return books;
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
