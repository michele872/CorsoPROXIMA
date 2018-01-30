package serializzazione;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeStep {
	
	public static String dataCorrente() {
		//LocalDateTime data1 = LocalDateTime.now();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy  HH.mm.ss"); 
		String data = dateFormat.format(new Date());
		//String ritornaData = data1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		return data;		
	}
	
//	public static void main (String[] args) {
//		System.out.println(dataCorrente());
//	}
}
