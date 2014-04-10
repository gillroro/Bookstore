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
import entity.Administrator;
import entity.Customer;

public class AdminLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement checkDuplicate;
	private ResultSet results;
	private String email;
	private String password;
	private String name;
	private PreparedStatement addAdmin;
	private PreparedStatement getCustomers;
	private Administrator admin = new Administrator();
	private List<Customer> customers = new ArrayList<Customer>();
	
	
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
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String execute() throws SQLException{
		getAllCustomers();
		connection = ConnectionFactory.getConnection();
		checkDuplicate = connection.prepareStatement("SELECT email FROM administrators WHERE email=? and password=?");
		checkDuplicate.setString(1, getEmail());
		checkDuplicate.setString(2, getPassword());
		results = checkDuplicate.executeQuery();
		if(results.next()){
			connection.close();
			checkDuplicate.close();
			WebSession.put("CurrentUser", admin);
			return SUCCESS;
		}
		else{
			connection.close();
			checkDuplicate.close();
			return "failure";
		}	
	}
	
	public String addAdmin() throws SQLException{
		connection = ConnectionFactory.getConnection();
		addAdmin = connection.prepareStatement("INSERT INTO administrators (name, email, password) VALUES(?,?,?)");
		addAdmin.setString(1, getName());
		addAdmin.setString(2, getEmail());
		addAdmin.setString(3, getPassword());
		addAdmin.executeUpdate();
		connection.close();
		addAdmin.close();
		WebSession.put("New Admin", admin);
		return SUCCESS;
		
	}
	
	
	
	public String logout(){
		WebSession.remove("CurrentUser");
		WebSession.clear();
		return SUCCESS;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public List<Customer> getAllCustomers() throws SQLException{
		connection = ConnectionFactory.getConnection();
		getCustomers= connection.prepareStatement("SELECT * FROM customer");
		results = getCustomers.executeQuery();
		while(results.next()){
			Customer customer = new Customer();
			customer.setName(results.getString("name"));
			customer.setAddress(results.getString("address"));
			customer.setEmail(results.getString("email"));
			customer.setPassword(results.getString("password"));
			customers.add(customer);
		}
		connection.close();
		getCustomers.close();
		results.close();
		return customers;
	}
	
	

}
