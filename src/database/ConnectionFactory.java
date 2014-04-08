package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static ConnectionFactory instance = new ConnectionFactory();
	private static final String url = "jdbc:mysql://localhost:3306/bookstore";
	private static final String driver= "com.mysql.jdbc.Driver";
	static Connection connection = null;
	
	private ConnectionFactory(){
		try { 
			Class.forName(driver); 
		}
		catch (Exception ignored) {} 
	}

	public Connection createConnection(){
		try { 
			
			connection = DriverManager.getConnection(url, "root", "root");
			
			
		}
		catch (Exception ignored) {} 
		return connection;
	}
	
	public static Connection getConnection(){
		return instance.createConnection();
	}
	

}
