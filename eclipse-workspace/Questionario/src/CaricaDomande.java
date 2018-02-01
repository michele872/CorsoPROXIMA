import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CaricaDomande {
	public String domanda, risp1, risp2, risp3;
	
	public CaricaDomande(String d, String r1, String r2, String r3) {
		this.domanda = d;
		this.risp1 = r1;
		this.risp2 = r2;
		this.risp3 = r3;
	}
	
	public static ArrayList<CaricaDomande> caricaDomanda() throws ClassNotFoundException, SQLException {
		ArrayList<CaricaDomande> cd = new ArrayList<>();
		String driver = "com.mysql.jdbc.Driver";  		// C'è quel driver nel classPath?? Se non c'è parte l'eccezione. 
		Class.forName(driver);
		
		String url = "jdbc:mysql://localhost:3306/questionario";
		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
		Statement cmd = con.createStatement(); 
		
		String query = "SELECT (domande, risposta1, risposta2, risposta3) FROM utente";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			cd.add(new CaricaDomande("domande", "risposta1", "risposta2", "risposta3"));
		}
		return cd;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		for (CaricaDomande s : CaricaDomande.caricaDomanda()) {
			System.out.println(s.domanda);
		}
	}
}
