package rete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			address = InetAddress.getByName("starwave.com");
			System.out.println(address);
			InetAddress sw[] = InetAddress.getAllByName("UTENTE9");
			for(int i=0; i<sw.length; i++) {
				System.out.println(sw[i]);
			}
			
			TestInetAddress ip = new TestInetAddress();
			//ip.executeConnection2();
			
			try {
				ip.executeConnectionWithStreamReading();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	
	private static void executeConnection2 () throws Exception {

		URL page = new URL("https://www.google.it");
		URLConnection xxxConn = page.openConnection();
		xxxConn.connect();
		System.out.println("Connessione riuscita....");
	
	}
	
	public static void executeConnectionWithStreamReading() throws Exception {
		URL appoURL = new URL("https://www.google.com/");
		URLConnection yc = appoURL.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		
		in.close();
	}

}
