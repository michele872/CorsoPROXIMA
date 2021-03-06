package chatRoomAvanzata;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import test.Message;

public class ThreadClientWrite extends Thread {
	public final static int PORT = 8053;
	
	public void run() {
		Scanner in = new Scanner(System.in);
		
		while(true) {	
			
			Message m = new Message();

			System.out.print("Utente: ");
			m.setUsername(in.nextLine());
			System.out.print("Messaggio: ");
			m.setTextMessage(in.nextLine());
			System.out.println("*********************************************");
			
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
			if(m.getUsername().equals("exit"))
				break;
			}
	}
}
