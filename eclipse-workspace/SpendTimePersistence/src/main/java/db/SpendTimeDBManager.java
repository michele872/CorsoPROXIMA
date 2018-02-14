package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import bean.SpendTime;

public class SpendTimeDBManager {
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
				s.printStackTrace();
			}
		// Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		}
	
	public ArrayList<SpendTime> selectDb() throws ClassNotFoundException, SQLException {
		ArrayList<SpendTime> dip = new ArrayList<SpendTime>();
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);		
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		Statement cmd = con.createStatement();
		
		String query = "SELECT * FROM dipendente";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			System.out.println(res.getString(2));
			dip.add(new SpendTime(res.getInt(1), res.getString(2), res.getInt(3)));
		}
		System.out.println(dip.size());
		return dip;		
	}
	
	public HashMap<String, Integer> getPrepopolatedValue () throws ClassNotFoundException, SQLException {
		ArrayList<SpendTime> dip = selectDb();
		HashMap<String, Integer> valori = new HashMap<String, Integer>();

		int sizeDip = dip.size();
		for(int i=0; i<sizeDip; i++) {
			valori.put(dip.get(i).getId()+"_"+dip.get(i).getData(), dip.get(i).getOra());
			System.out.println("chiave: " + dip.get(i).getId()+"_"+dip.get(i).getData() + " valore: " + valori.get(dip.get(i).getId()+dip.get(i).getData()));
		}
		System.out.println("Questa è la size dell'ArrayList: " + sizeDip);
		System.out.println("Size dell'HashMap: " + valori.size());
		return valori;
	} 
	
	
	
	public static int insertDip(SpendTime st) throws Exception {

		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
	
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		int rows = 0;
		String query = "INSERT INTO dipendente (id, data, ora) VALUES (?,?,?)";
		PreparedStatement pStatement = con.prepareStatement(query);

		pStatement.setInt(1, st.getId());
		pStatement.setString(2, st.getData());
		pStatement.setInt(3, st.getOra());
		

		try {
			rows = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pStatement.close();

		return rows;
	}
	
	public static int deleteAll() {
		int rows = 0;

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
		
			String url = "jdbc:mysql://localhost:3306/dipendenti";
			Connection con = DriverManager.getConnection(url,"testuser","testuser");
			String query = "delete from dipendente;";
			Statement cmd = con.createStatement();

			rows = cmd.executeUpdate(query);
			cmd.close();
			System.out.println("Deleted rows: " + rows);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return rows;
	}
	
	public static void main(String[] args) throws Exception {
		
		SpendTimeDBManager.insertDip(new SpendTime(1, "15-02-2018", 8));
	}
}
