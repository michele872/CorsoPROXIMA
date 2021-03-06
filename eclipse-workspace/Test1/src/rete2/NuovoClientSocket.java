package rete2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import test.Message;

public class NuovoClientSocket {

	private static final int PORT = 8053;
	
	public static void main(String[] args) throws Exception {
		messaggio();		
	}
	
	public static void messaggio () throws Exception {
		
		while(true) {	
		Scanner in = new Scanner(System.in);
		Message m = new Message();
		Socket client = new Socket("mercurio", PORT);
		OutputStream os = client.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		System.out.println("Inserisci USERNAME!!");
		m.setUsername(in.nextLine());
		System.out.println("Inserisci MESSAGGIO!!");
		m.setTextMessage(in.nextLine());
		oos.writeObject(m);
		oos.reset();
		os.close();
		oos.close();
		System.out.println("Messaggio inviato");
		
		
		}
	}

}
