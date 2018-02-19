package dip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDBManager {
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
	
	
	public void updateDb(String giorno, int ora) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);		
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		//Statement cmd = con.createStatement();
		
		String query = "Update dipendente SET ora="+ora+" WHERE data= '"+giorno+"'";
		PreparedStatement ps = con.prepareStatement(query);

		ps.executeUpdate();
	}
	
	public static ArrayList<User> selectDb() throws ClassNotFoundException, SQLException {
		ArrayList<User> dip = new ArrayList<>();
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);		
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		Statement cmd = con.createStatement();
		
		String query = "SELECT * FROM dipendente";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			dip.add(new User(res.getInt(1), res.getString(2), res.getInt(3)));
		}
		return dip;		
	}
	
	public HashMap<String, Integer> getPrepopolatedValue () throws ClassNotFoundException, SQLException {
		ArrayList<User> dip = selectDb();
		HashMap<String, Integer> valori = new HashMap<>();

		int sizeDip = dip.size();
		for(int i=0; i<sizeDip; i++) {
			valori.put(dip.get(i).getId()+"_"+dip.get(i).getData(), dip.get(i).getOra());
			System.out.println("chiave: " + dip.get(i).getId()+"_"+dip.get(i).getData() + " valore: " + valori.get(dip.get(i).getId()+dip.get(i).getData()));
		}
		System.out.println("Questa è la size dell'ArrayList: " + sizeDip);
		System.out.println("Size dell'HashMap: " + valori.size());
		return valori;
	} 
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDBManager cdb = new UserDBManager();
		//cdb.insertDb("1", 6);
		//System.out.println("Inserimento effettuato");
//		cdb.updateDb("12-02-2018", 8);
//		System.out.println("UPDATE effettuato");
//		for (Dipendente d : cdb.selectDb()) {
//			System.out.println(d.getOra());
//		}
		cdb.getPrepopolatedValue();
	}
}
