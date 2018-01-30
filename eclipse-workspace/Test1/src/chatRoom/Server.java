package chatRoom;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import chatRoom.Connect;
import test.Message;

public class Server {

public static final int SERVER_SOCKET_PORT = 8050;
public static final int SERVER_SOCKET_PORT2 = 8055;
	
	public static void main(String[] args) throws Exception {
		Message m = new Message();
		ServerSocket server = new ServerSocket(SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: "+ address + " #####");
		
//		InputStream is = null;    					 // Li ho già dichiarati in Connect
//		ObjectInputStream ois = null;
		
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
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					server.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
