package rete2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import test.Message;

public class NuovoServerSocket {
	
	public static final int SERVER_SOCKET_PORT = 8050;
	
	public static void main(String[] args) throws Exception {
		Message m = new Message();
		ServerSocket server = new ServerSocket(SERVER_SOCKET_PORT);
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
				
				while(true) {
					Socket client = server.accept();
					Connect nuovaConnessione = new Connect(client);
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					is.close();
				} catch (Exception e) {
					e.getMessage();
				} try {
					ois.close();
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
	}

}
