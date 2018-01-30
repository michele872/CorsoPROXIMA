package chatRoomAvanzata;

import test.MessagesRequest;

public class ClientRead {

	public static void main(String[] args) throws InterruptedException {
		MessagesRequest ms = new MessagesRequest();
		
		while(true) {
			Thread.sleep(2000);
			new ThreadClientRead(ms).start();
		}
	}

}
