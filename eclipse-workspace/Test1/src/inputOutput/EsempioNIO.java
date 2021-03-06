package inputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class EsempioNIO {

	public static void main(String[] args) throws Exception {
			String filePathToRead = "C:/corsojava/Prova.java";
			File fileToRead = new File(filePathToRead);
			FileInputStream fis = new FileInputStream(fileToRead);
			FileChannel inChannel = fis.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(inChannel.read(buffer)>0) {
				buffer.flip();
				for (int i = 0; i < buffer.limit(); i++) {
					System.out.println((char)buffer.get());
				}
				buffer.clear();
			}
			inChannel.close();
			fis.close();
		}
	

}
