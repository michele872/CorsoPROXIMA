package chatRoomAvanzata;

public class ClientWrite {
		
	// CLASSE PER LA SCRITTURA DEI MESSAGGI IN CHAT
	
		public static void main(String[] args) throws Exception {
			multiThreadClient();		
		}
		
		public static void multiThreadClient() {
			new ThreadClientWrite().start();    // Mi avvia il thread del client
		}
		
//		public static void messaggio () throws Exception {
//			
//			while(true) {	
//			Scanner in = new Scanner(System.in);
//			Message m = new Message();
//
//			System.out.print("Utente: ");
//			m.setUsername(in.nextLine());
//			System.out.print("Messaggio: ");
//			m.setTextMessage(in.nextLine());
			
//			Socket client = new Socket("localhost", PORT);
//			OutputStream os = client.getOutputStream();
//			ObjectOutputStream oos = new ObjectOutputStream(os);			
//			oos.writeObject(m);
//			//System.out.println("Messaggio inviato");
			
//			Message m1 = new Message();
//			InputStream is = client.getInputStream();
//			ObjectInputStream ois = new ObjectInputStream(is);
//			m1 = (Message) ois.readObject();
//			System.out.println("*********************************************");
//			System.out.println("Utente "+m1.getUsername() + " - "+ "Messaggio: " + m1.getTextMessage());
//			System.out.println("*********************************************");
//			
//			os.close();
//			oos.close();
//			is.close();
//			ois.close();
//			client.close();
//			}
//		}
	

}