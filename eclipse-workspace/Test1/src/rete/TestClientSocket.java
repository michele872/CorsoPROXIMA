package rete;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClientSocket {
	public static void main (String[] args) throws UnknownHostException, IOException {
			Socket requestSocket = new Socket("192.168.178.31", TestServerSocket.SERVER_SOCKET_PORT);
			System.out.println("CONNECTION...OK...");
			
			
	}
}
