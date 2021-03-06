package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import test.Message;
import test.MessagesRequest;

public class ThreadClientRead extends Thread {
	public final static int PORT = 8055;
	MessagesRequest m;
	
	public ThreadClientRead(MessagesRequest m) {
		this.m = m;
	}
	
	public void run() {

		Socket client;
		try {	
							
				client = new Socket("mercurio", PORT);						// Apro il Socket // Faccio la richiesta al SERVER
				OutputStream os = client.getOutputStream();					// Avvio lo Stream --> Avvio la scrittura   
				ObjectOutputStream oos = new ObjectOutputStream(os);			
				oos.writeObject(m);
			
				InputStream is = client.getInputStream();					// Apro lo Stream di lettura client --> Server 
				ObjectInputStream ois = new ObjectInputStream(is);			// Vado a prendermi tutti i messaggi, che caricheṛ poi nell'array
				
				Message [] message = null; 
				
				try {
				message = (Message[]) ois.readObject();
				} catch (Exception e) {
					e.printStackTrace();
		
				}
				
				for (Message m : message) {
					System.out.format("UserName: %-15s Messaggio: %-20s data: %-10s \n", m.getUsername(), m.getTextMessage(), m.getLastTimeActive());
				}
				
				if (message != null && message.length != 0 ) {
					m.setLastMessageSendTime(message[message.length-1].getLastTimeActive());
				}
				
				os.close();
				oos.close();
				
				is.close();
				ois.close();
				
				client.close();
				
				}catch(IOException e) {
					e.printStackTrace();
				}

				}
	}

