package chatRoom;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import serializzazione.SerializeTest;
import test.Message;

	public class Connect extends Thread{
		Socket client;
		ObjectInputStream is;
		PrintWriter ois;
		
		public Connect(Socket client) {
			this.client = client;
			this.start();
		}
		
		public void run() {
			try {
				InputStream is = client.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is); 
				InetAddress indirizzoCorrenteClient = client.getInetAddress();
				System.out.println("Connection established with: "+ indirizzoCorrenteClient);
				Message messaggioCorrente = (Message) ois.readObject();
				System.out.println("username: " + messaggioCorrente.getUsername()+ "\n"+
				"messaggio "+messaggioCorrente.getTextMessage());
				
				OutputStream os = client.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(messaggioCorrente);
				
				//SerializeTest.creaFile(messaggioCorrente);
				SerializeTest.serialize(messaggioCorrente);
				//System.out.println("Messaggio serializzato");
				SerializeTest.deserialize(messaggioCorrente);
				//System.out.println("Messaggio deserializzato");
			
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	

}
