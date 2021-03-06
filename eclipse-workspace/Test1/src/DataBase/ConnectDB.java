package DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectDB {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// load jdbc connector
		String driver = "com.mysql.jdbc.Driver";  		// C'� quel driver nel classPath?? Se non c'� parte l'eccezione. 
		Class.forName(driver);
		
		//stringa di connessione
		String url = "jdbc:mysql://localhost:3306/testDB";
		//connessione con username e password
		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
		Statement cmd = con.createStatement(); 
		
		
		//METODO SELECT
//		String query = "SELECT * FROM testDBtable";
//		ResultSet res = cmd.executeQuery(query);
//		
//		while(res.next()) {
//			System.out.println(res.getString("nome"));
//			System.out.println(res.getString("cognome"));
//		}
		
		//METODO INSERT
//		String query2 = "INSERT INTO testDBtable (nome, cognome) VALUES ('fabrizio' , 'luca')";
//		int rowsUpdate = cmd.executeUpdate(query2);
//			System.out.println("rowsUpdate: " + rowsUpdate);
//		
		//METODO UPDATE
//		String query3 = "UPDATE testDBtable SET nome = 'Marco' WHERE nome = 'Michele' ";
//		int r = cmd.executeUpdate(query3);
//			System.out.println("r: " + r);
		
		//METODO DELETEs
//		String delite = "DELETE FROM testDBtable WHERE nome = 'Fabrizio' ";
//		int del = cmd.executeUpdate(delite);
//			System.out.println("r: " + del);
			
		String query5 = "SELECT nome FROM testDBtable WHERE cognome = ?";
		PreparedStatement pStatement = con.prepareStatement(query5);
			String s = "test";
			pStatement.setString(1, s);
		ResultSet res = pStatement.executeQuery();
		while(res.next()) {
			System.out.println(res.getString("nome"));
		}
		
		//res2.close();
		cmd.close();
		con.close();
	
		
		
		
		
	}

}
