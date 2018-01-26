package chatRoom;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import test.Message;

public class Client {

		private static final int PORT = 8057;
		
		public static void main(String[] args) throws Exception {
			messaggio();		
		}
		
		public static void messaggio () throws Exception {
			
			while(true) {	
			Scanner in = new Scanner(System.in);
			Message m = new Message();
			System.out.println("Inserisci USERNAME!!");
			m.setUsername(in.nextLine());
			System.out.println("Inserisci MESSAGGIO!!");
			m.setTextMessage(in.nextLine());
			
			Socket client = new Socket("mercurio", PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);			
			oos.writeObject(m);
			//oos.reset();
//			os.close();
//			oos.close();
			System.out.println("Messaggio inviato");
			
			Message m1 = new Message();
			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			m1 = (Message) ois.readObject();
			System.out.println("**********  ECCO IL TUO MESSAGGIO **********");
			//System.out.println("");
			System.out.println(m1.getUsername() + " - " + m1.getTextMessage());
			//System.out.println("");
			System.out.println("######################################################");
			
			os.close();
			oos.close();
			is.close();
			ois.close();
			client.close();
			}
		}
	

}
