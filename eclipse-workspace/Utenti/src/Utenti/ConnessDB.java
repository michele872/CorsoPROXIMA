package Utenti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnessDB {
	
	String email, password;
	
//	public ArrayList<String> getEmail() throws ClassNotFoundException, SQLException {
//		ArrayList<String> mail = new ArrayList<>();
//		String driver = "com.mysql.jdbc.Driver";  		// C'è quel driver nel classPath?? Se non c'è parte l'eccezione. 
//		Class.forName(driver);
//		
//		String url = "jdbc:mysql://localhost:3306/testusers";
//		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
//		Statement cmd = con.createStatement(); 
//		
//		String query = "SELECT email FROM users";
//		ResultSet res = cmd.executeQuery(query);
//		
//		
//		while(res.next()) {
//			mail.add(res.getString("email"));			
//		}	
//		return mail;	
//	}
//	
//	public ArrayList<String> getPassword() throws ClassNotFoundException, SQLException {
//		ArrayList<String> password = new ArrayList<>();
//		String driver = "com.mysql.jdbc.Driver";  		// C'è quel driver nel classPath?? Se non c'è parte l'eccezione. 
//		Class.forName(driver);
//		
//		String url = "jdbc:mysql://localhost:3306/testusers";
//		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
//		Statement cmd = con.createStatement(); 
//		
//		String query = "SELECT password FROM users";
//		ResultSet res = cmd.executeQuery(query);
//		
//		
//		while(res.next()) {
//			password.add(res.getString("email"));			
//		}	
//		return password;	
//	}
	
	public ArrayList<EmailPassword> emailPassword() throws ClassNotFoundException, SQLException {
		ArrayList<EmailPassword> emPs = new ArrayList<>();
		String driver = "com.mysql.jdbc.Driver";  		// C'è quel driver nel classPath?? Se non c'è parte l'eccezione. 
		Class.forName(driver);
		
		String url = "jdbc:mysql://localhost:3306/testusers";
		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
		Statement cmd = con.createStatement(); 
		
		String query = "SELECT email,password FROM users";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			emPs.add(new EmailPassword(res.getString("email"), res.getString("password")));
		}
		return emPs;
	}
	
	public void insert(String email, String password) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";  		// C'è quel driver nel classPath?? Se non c'è parte l'eccezione. 
		Class.forName(driver);
		
		String url = "jdbc:mysql://localhost:3306/testusers";
		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
		
		String query5 = "INSERT INTO users (email, password) VALUES (?,?)";
		PreparedStatement pStatement = con.prepareStatement(query5);
		pStatement.setString(1, email);
		pStatement.setString(2, password);;
		try {
		pStatement.executeUpdate();
		} catch (SQLException s) {
			s.getMessage();
		}
	}


}
