package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import commons.PropertiesManager;

import utility.CurrentDate;


public class SpendTimeDBManager {
	
	final static Logger logger = Logger.getLogger(SpendTimeDBManager.class);
	
	int giorno, ora;
	public static boolean check = false;
	protected static String dbUsername;
	protected static String dbPassword;
	//protected static String dbDialect;
	protected static String connectorMainClass;
	protected static String dbUrl;
	
	protected static Connection con;

	static {
		dbUsername = PropertiesManager.getPropertyAsString("database.username");
		dbPassword = PropertiesManager.getPropertyAsString("database.password");
		//dbDialect = PropertiesManager.getPropertyAsString("database.dialect");
		dbUrl = PropertiesManager.getPropertyAsString("database.connection.url");
		connectorMainClass = PropertiesManager.getPropertyAsString("database.connector.mainclass");
		
		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: " + dbUrl + " - connectorMainClass: " + connectorMainClass);
	}

	public static void openConnection() throws Exception {
		Class.forName(connectorMainClass);
		con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		logger.info("Connection opened successfully...");
	}

	public static void closeConnection() throws Exception {
		try {
			con.close();
			logger.info("Connection closed successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
	
	public static void insertDb(int id, String giorno, int ora) throws Exception {
		openConnection();
		String query = "INSERT INTO spendtime (id, data, ora) VALUES (?,?,?)";
		PreparedStatement ps  = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, giorno);
		ps.setInt(3, ora);
		
		try {
			ps.executeUpdate();
			} catch (SQLException s) {
				logger.error(s.getMessage());
			}
		// Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		closeConnection();
		}
	
	public static int selectByOra(String giorno) throws Exception {
		int ora = 0;
		openConnection();
		Statement cmd = con.createStatement();
		
		String query = "SELECT ora FROM spendtime WHERE data = "+" '"+giorno+"'";
		ResultSet res = cmd.executeQuery(query);
		while(res.next()) {
			ora = res.getInt(1);
			logger.debug(ora);
		}
		return ora;
	}
	
	public static void updateDb(String giorno, int ora) throws Exception {
		openConnection();

		String query = "Update spendtime SET ora="+ora+" WHERE data= '"+giorno+"'";
		PreparedStatement ps = con.prepareStatement(query);

		ps.executeUpdate();

		closeConnection();
	}
	
	public static ArrayList<SpendTime> selectDb() throws Exception {
		ArrayList<SpendTime> dip = new ArrayList<SpendTime>();
		openConnection();
		Statement cmd = con.createStatement();
		
		String query = "SELECT * FROM spendtime";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			logger.debug(res.getString(2));
			dip.add(new SpendTime(res.getInt(1), res.getString(2), res.getInt(3)));
		}
		logger.debug(dip.size());
		return dip;		
	}
	
	
	public static HashMap<String, Integer> getPrepopolatedValue () throws Exception {
		ArrayList<SpendTime> dip = selectDb();
		HashMap<String, Integer> valori = new HashMap<String, Integer>();

		int sizeDip = dip.size();
		int giorno = Integer.parseInt(CurrentDate.giornoCorrente());
		if( sizeDip < giorno ) {
			for(int i=sizeDip; i< giorno; i++ ) {
				if(!dip.isEmpty())
					insertDb(dip.get(0).getId(), (i+1)+"-"+CurrentDate.dataCorrente(), 0);
			}
		}
		dip = selectDb();
		sizeDip = dip.size();
		
		for(int i=0; i<sizeDip; i++) {
			valori.put(dip.get(i).getId()+"_"+dip.get(i).getData(), dip.get(i).getOra());
			logger.debug("chiave: " + dip.get(i).getId()+"_"+dip.get(i).getData() + " valore: " + valori.get(dip.get(i).getId()+dip.get(i).getData()));
		}
		logger.debug("Questa è la size dell'ArrayList: " + sizeDip);
		logger.debug("Size dell'HashMap: " + valori.size());
		return valori;
	} 
	
	
	public static int deleteAll() {
		int rows = 0;

		try {
			openConnection();
			String query = "delete from spendtime;";
			Statement cmd = con.createStatement();

			rows = cmd.executeUpdate(query);
			cmd.close();
			logger.error("Deleted rows: " + rows);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return rows;
	}
	
//	public static void main(String[] args) throws Exception {
//		SpendTimeDBManager sp = new SpendTimeDBManager();
//		sp.insertDb(1, "16-02-2018", 4);
//		logger.debug(SpendTimeDBManager.selectByOra("14-02-2018"));
//	}
}
