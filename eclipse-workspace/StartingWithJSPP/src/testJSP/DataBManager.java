package testJSP;

public class DataBManager {
	public static boolean checkOnDB (String email, String password) {
		return false;
	}
	
	public static Topic[] getTopics() {
		Topic[] topics = new Topic[5];
		String[] answer = {"cane","gatto","topo"};
		String[] replies = {"cane"};
		for (int i=0; i<5; i++) {
			topics[i] = new Topic ("che animale preferisci?", answer, replies);
		}
		return topics;
	}
}
