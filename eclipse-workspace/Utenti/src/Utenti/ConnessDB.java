package Utenti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnessDB {
	
	public static void connetti() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";  		// C'è quel driver nel classPath?? Se non c'è parte l'eccezione. 
		Class.forName(driver);
		
		String url = "jdbc:mysql://localhost:3306/testusers";
		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
		Statement cmd = con.createStatement(); 
		
		String query = "SELECT email,password FROM users";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			System.out.println(res.getString("email"));
			System.out.println(res.getString("password"));
		}
	}

	public static void main(String[] args)  {
		
		

	}

}
