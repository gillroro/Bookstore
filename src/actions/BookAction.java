package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionFactory;
import entity.Book;

public class BookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
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
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String addBook() throws SQLException{
		connection = ConnectionFactory.getConnection();
		addBook = connection.prepareStatement("INSERT INTO book (title, author, price, category, image, quantity) VALUES (?,?,?,?,?,?)");
		addBook.setString(1, getTitle());
		addBook.setString(2, getAuthor());
		addBook.setDouble(3, getPrice());
		addBook.setString(4, getCategory());
		addBook.setString(5, getImage());
		addBook.setInt(6, getQuantity());
		addBook.executeUpdate();
		addBook.close();
		connection.close();
		return SUCCESS;
	}
	
	public List<Book> getAllBooks() throws SQLException{
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
		return books;
	}
	
	public String displayAllBooks() throws SQLException{
		getAllBooks();
		if(books!=null){
			return SUCCESS;
		}
		else{
			return "failure";
		}
	}
	
	public List<Book> getBookByCategory() throws SQLException{
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
		return books;
	}
	
	public String displayBooksByCategory() throws SQLException{
		getBookByCategory();
		if(books != null){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}
	
	public List<Book> getBookByAuthor() throws SQLException{
		connection = ConnectionFactory.getConnection();
		getBooks = connection.prepareStatement("SELECT * FROM book WHERE author LIKE ?");
		getBooks.setString(1, "%"+author+"%");
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
		return books;
	}
	
	public String displayBooksByAuthor() throws SQLException{
		getBookByAuthor();
		if(books != null){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}
	
	public List<Book> getBookByTitle() throws SQLException{
		connection = ConnectionFactory.getConnection();
		getBooks = connection.prepareStatement("SELECT * FROM book WHERE title LIKE ?");
		getBooks.setString(1, "%"+title+"%");
		
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
		return books;
	}
	
	public String displayBooksByTitle() throws SQLException{
		getBookByTitle();
		if(books != null){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}

	
	public String forward(){
		return NONE;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
