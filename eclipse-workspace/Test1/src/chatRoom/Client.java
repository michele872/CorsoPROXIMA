package chatRoom;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import test.Message;

public class Client {

		private static final int PORT = 8050;
		
		public static void main(String[] args) throws Exception {
			messaggio();		
		}
		
		public static void messaggio () throws Exception {
			
			while(true) {	
			Scanner in = new Scanner(System.in);
			Message m = new Message();

			System.out.print("Utente: ");
			m.setUsername(in.nextLine());
			System.out.print("Messaggio: ");
			m.setTextMessage(in.nextLine());
			
			Socket client = new Socket("localhost", PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);			
			oos.writeObject(m);
			//System.out.println("Messaggio inviato");
			
			Message m1 = new Message();
			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			m1 = (Message) ois.readObject();
			System.out.println("*********************************************");
			System.out.println("Utente "+m1.getUsername() + " - "+ "Messaggio: " + m1.getTextMessage());
			System.out.println("*********************************************");
			
			os.close();
			oos.close();
			is.close();
			ois.close();
			client.close();
			}
		}
	

}