package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import session.WebSession;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionFactory;
import entity.Book;
import entity.Customer;

public class CustomerLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Connection connection;
	private PreparedStatement checkDuplicate;
	private PreparedStatement addCustomer;
	private ResultSet results;
	private String email;
	private String password;
	private String name;
	private String address;
	private Customer customer = new Customer();
	private PreparedStatement getBooks;
	private String title;
	private String author;
	private String category;
	private double price;
	private String image;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String execute() throws SQLException{
		displayAllBooks();
		connection = ConnectionFactory.getConnection();
		checkDuplicate = connection.prepareStatement("SELECT email FROM customer WHERE email=? and password=?");
		checkDuplicate.setString(1, getEmail());
		checkDuplicate.setString(2, getPassword());
		results = checkDuplicate.executeQuery();
		if(results.next()){
			connection.close();
			checkDuplicate.close();
			WebSession.put("CurrentUser", customer);
			return SUCCESS;
		}
		else{
			connection.close();
			checkDuplicate.close();
			return "failure";
		}	
	}
	
	public String registerCustomer() throws SQLException{
		connection = ConnectionFactory.getConnection();
		addCustomer = connection.prepareStatement("INSERT INTO customer (name, address, email, password) VALUES (?,?,?,?)");
		addCustomer.setString(1, getName());
		addCustomer.setString(2, getAddress());
		addCustomer.setString(3, getEmail());
		addCustomer.setString(4, getPassword());
		addCustomer.executeUpdate();
		WebSession.put("CurrentUser", customer);
		addCustomer.close();
		connection.close();
		return SUCCESS;
	}

	public String logout(){
		WebSession.remove("CurrentUser");
		WebSession.clear();
		return SUCCESS;
	}
	
	public String forward(){
		return NONE;
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


}
