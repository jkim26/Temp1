package util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	public static Connection getConnection() throws SQLException {
		
		//This will "register" our driver. Making sure our application and any frameworks we are using are aware of it. 
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://localhost:5432/project1";
		String username = "postgres"; //System.getenv("pguser"); 
		String password = "password"; //System.getenv("pgpassword"); 
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
//	public static void main(String[] args) {
//		
//		/*
//		 * Try with resources block will create a resource then automatically close that resource for you 
//		 * whether the try is successful or not. It essentially creates a finally block for you. 
//		 */
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			System.out.println("Connection Successful");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
		
}
