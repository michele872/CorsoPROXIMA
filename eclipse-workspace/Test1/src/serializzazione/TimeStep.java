package serializzazione;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStep {
	
	public static String dataCorrente() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy  HH.mm.ss"); 
		String data = dateFormat.format(new Date());
		return data;		
	}
	
//	public static void main (String[] args) {
//		System.out.println(dataCorrente());
//	}
}