package chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import test.Message;

public class ThreadClientWrite extends Thread {
	public final static int PORT = 8053;
	String username, message;
	
	public ThreadClientWrite(String u, String m) {
		this.username = u;
		this.message = m;
	}
	
	public void run() {
			
			Message m = new Message();

			m.setUsername(username);
			m.setTextMessage(message);
			
			Socket client;
			
			try {
			client = new Socket("mercurio", PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);			
			oos.writeObject(m);
		
			
			os.close();
			oos.close();
			client.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
}
