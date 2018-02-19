package dip;

import java.sql.SQLException;
import java.util.ArrayList;

public class EsempioJSON {

	public static String toJson1() throws ClassNotFoundException, SQLException {
		ArrayList<User> p = null;
		p = UserDBManager.selectDb();
		
		StringBuilder sb = new StringBuilder();
		String s = "";
			sb.append("[ ");
		for (User i : p) 
		{
			sb.append("{ \"id\": ");
			sb.append(i.getId());
			sb.append(", \"data\": ");
			sb.append("\""+ i.getData());
			sb.append("\"");
			sb.append(", \"ora\": ");
			sb.append(i.getOra());
			sb.append(" },");
		}
	//		sb.substring(0, sb.length()-1);  Torna una nuova stringa che va da indice a indice 
			sb.deleteCharAt(sb.length()-1);
			sb.append(" ]");
		s = sb.toString();
		
		return s;
	}
	
	public static ArrayList<User> fromJson (String s) {
		String s1 = s.substring(1, s.length()-1);
		System.out.println(s1);
		String[] primo = s1.split(",");
		for(int i=0; i<primo.length; i++) {
			System.out.println(primo[i]);
		}
		return null;
	}
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//User person = new User(1, "10-02-2018", 8);
		//Gson g = new Gson();
		String s = EsempioJSON.toJson1();
		System.out.println(s);

		fromJson(s);
//		for (User u : p) {
//			System.out.println(g.toJson(u));
//		}
		
		
	}

}
