package dipendenti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnessDB {
	
	int giorno, ora;
	public boolean check = false;;
	
	public void insertDb(int id, String giorno, int ora) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
	Class.forName(driver);
	
	String url = "jdbc:mysql://localhost:3306/dipendenti";
	Connection con = DriverManager.getConnection(url,"testuser","testuser");
	String query = "INSERT INTO dipendente (id, data, ora) VALUES (?,?,?)";
	PreparedStatement ps  = con.prepareStatement(query);
	ps.setInt(1, id);
	ps.setString(2, giorno);
	ps.setInt(3, ora);
	
	try {
		ps.executeUpdate();
		} catch (SQLException s) {
			s.getMessage();
		}
	
	// Se l'inserimento va a buon fine CHECK diventa true
	check = true;
	}

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ConnessDB cdb = new ConnessDB();
//		cdb.insertDb(1, "1", 6);
//		System.out.println("Inserimento effettuato");
//	}
	
}
