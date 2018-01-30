package chatRoomAvanzata;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import test.Message;

public class ThreadServerRead {
	public static final int SERVER_SOCKET_PORT = 8053;
		
		public static void main(String[] args) throws Exception {
			Message m = new Message();
			
			ServerSocket server = new ServerSocket(SERVER_SOCKET_PORT);
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("##### SERVER HOSTNAME/IP: "+ address + " #####");
			
			while(true) {
				try {
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("#####################################################################");
					System.out.println("####### SERVER HOSTNAME/IP: " + address + " READY #######");
					System.out.println("Server socket started. Listening to port: " + SERVER_SOCKET_PORT);
					
					while(true) {
						Socket client = server.accept();
						Connect nuovaConnessione = new Connect(client);
						}
}
