package chatRoomAvanzata;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import test.Message;
import test.MessagesRequest;

public class ThreadClientRead extends Thread {
	MessagesRequest m;
	
	public ThreadClientRead(MessagesRequest m) {
		this.m = m;
	}
	
	public void run() {

		Socket client;
		try {	
							
				client = new Socket("mercurio", 8055);
				OutputStream os = client.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);			
				oos.writeObject(m);
			
				InputStream is = client.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				
				Message [] message = null; 
				
				try {
				message = (Message[]) ois.readObject();
				} catch (Exception e) {
					e.printStackTrace();
		
				}
				
				for (Message m : message) {
					System.out.println(m.getUsername()+ " " + m.getTextMessage());
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

