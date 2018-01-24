package inputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WritingToAFileDemo {

	public static void main(String[] args) throws Exception {
		String fileToWrite = "C:/corsojava/provaScrittura.txt";
		File f = new File(fileToWrite);
		FileOutputStream fos = new FileOutputStream(f);
		PrintWriter pw = new PrintWriter(fos);
		pw.println("ciao");
		pw.close();
	}

}
