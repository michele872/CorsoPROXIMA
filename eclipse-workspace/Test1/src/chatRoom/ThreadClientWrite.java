package chatRoom;

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
		System.out.println("*********************************************");
		
		while(true) {	
			
			Message m = new Message();

			System.out.print("Utente: ");
			m.setUsername(in.nextLine());
			if(m.getUsername().equals("exit"))
				break;
			System.out.print("Messaggio: ");
			m.setTextMessage(in.nextLine());
			System.out.println("*********************************************");
			
			
			try {
			Socket client = new Socket("mercurio", PORT);   //Appena scritti i dati apro la connessione e invio 
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
		System.out.println("Client chiuso!!!");
	}
}
