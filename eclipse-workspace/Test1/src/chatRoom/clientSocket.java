package chatRoom;

import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import test.Message;

import rete.TestServerSocket;

public class clientSocket {

	public static final int SERVER_SOCKET_PORT = 8053;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//while (true) {
			Scanner in = new Scanner(System.in);			
			Message m = new Message();
			
//			System.out.println("Inserisci USERNAME");
//			m.setUsername(n);
			
			System.out.println("Inserisci messagio");
			String n = in.nextLine();
			m.setTextMessage(n);
	//		String message = m.getTextMessage();
			
			Socket client = new Socket("mercurio", SERVER_SOCKET_PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			//oos.writeObject("Ciao!!!"); // usato per il collegamento alla porta 8051 senza la classe message
			oos.writeObject(m);
			os.close();
			oos.close();
			System.out.println("Messaggio inviato");
		//}
	}

}