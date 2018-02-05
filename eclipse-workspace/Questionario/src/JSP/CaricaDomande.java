package JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CaricaDomande {
	public String domande; 
	public String[] risposte;
	public String[] rispCorretta;
	
	public CaricaDomande() {
		
	}
	
	public CaricaDomande(String d) {
		this.domande = d;
	}
	
	public CaricaDomande(String d, String r [], String[] rC) {
		this.domande = d;
		this.risposte = r;
		this.rispCorretta = rC;
	}
	
	public static ArrayList<CaricaDomande> caricaDomanda() throws ClassNotFoundException, SQLException {
		ArrayList<CaricaDomande> cd = new ArrayList<>();
		String driver = "com.mysql.jdbc.Driver";  	 
		Class.forName(driver);
		
		String url = "jdbc:mysql://localhost:3306/questionario";
		Connection con = DriverManager.getConnection(url, "testuser", "testuser");
		Statement cmd = con.createStatement(); 
		
		String query = "SELECT domande, risposte, rispCorrette FROM utente";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			
			cd.add(new CaricaDomande(res.getString("domande"), res.getString("risposte").split(" - "), res.getString("rispCorrette").split("-"))); // passo le domande + un array fatto da risposte
		}
		return cd;
	}
	
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		for (CaricaDomande s : CaricaDomande.caricaDomanda()) {
//			System.out.println(s.domande + "\n" + s.r);
//		}
		
//		String s = "ciaoabclucaabcseiabcunabcgrande";
//		
//		String[] arrayStringhe = s.split("abc");
//		
//		System.out.println(Arrays.toString(arrayStringhe));
//	}
}
