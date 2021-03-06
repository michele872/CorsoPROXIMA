package rete;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerSocket {

	public final static int SERVER_SOCKET_PORT = 8051;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ServerSocket serverSock = new ServerSocket(SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: "+ address + " #####");
		InputStream is = null;
		ObjectInputStream ois = null;
		while(true) {
			try {
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("######################################################################");
				System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY ######");
				System.out.println("Server socket started. Listening to port: " + SERVER_SOCKET_PORT);
				Socket client = serverSock.accept();
				InetAddress currentClientInetAddress = client.getInetAddress();
				System.out.println("Connection established with: "+ currentClientInetAddress);
				is = client.getInputStream();
				ois = new ObjectInputStream(is);
				String currentMexToDisplay = (String) ois.readObject();
				System.out.println(currentMexToDisplay);
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					ois.close();
				} catch ( Exception e) {
					e.printStackTrace();
				}
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
