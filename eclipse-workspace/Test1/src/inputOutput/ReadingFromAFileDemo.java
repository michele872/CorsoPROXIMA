package inputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFromAFileDemo {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/prova.txt"));
				String s, s2 = new String();
				while ((s = in.readLine()) != null) {
					s2 += s + "\n";
				}
				in.close();
				System.out.println(s2);
	}
}
