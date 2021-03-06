package serializzazione;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import test.Message;

public class SerializeTest {
	
	public static String creaFile(Message mex) throws Exception {
		String path = "C:\\Users\\UTENTE8\\Desktop\\Serialize\\"  +TimeStep.dataCorrente()+" "+ ".txt";
		File f = new File(path);
		//while(true) {
				if (!f.exists()) 
					f.createNewFile();
		//}
		return f.getAbsolutePath();
	}
	
	public static void serialize(Message mex) throws Exception {
			//creaFile(mex);
			FileOutputStream fos = null;
			fos = new FileOutputStream(creaFile(mex));
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(fos);
			oos.writeObject(mex);
			oos.close();
		
	}
	
	public static void deserialize(Message mex) throws Exception {
		//Message mex = null;
		
		FileInputStream fis = null;
		fis = new FileInputStream(creaFile(mex));
		ObjectInputStream ois;
		ois = new ObjectInputStream(fis);
		mex = (Message) ois.readObject();
		//System.out.println(mex.getUsername() + mex.getTextMessage());
		ois.close();		
	}
	
}
