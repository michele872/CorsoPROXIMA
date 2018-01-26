package serializzazione;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import test.Message;

public class SerializeTest {

	public void serializeTest() throws Exception {
		Message mex = new Message();
		
		FileOutputStream fos = null;
		fos = new FileOutputStream("C:/koapòksdjgklsd.txt");
		ObjectOutputStream oos;
		oos = new ObjectOutputStream(fos);
		oos.writeObject(mex);
		oos.close();
	}
	
	public void deserializeTest() throws Exception {
		Message mex = null;
		
		FileInputStream fis = null;
		fis = new FileInputStream("C:/djlsdg.txt");
		ObjectInputStream ois;
		ois = new ObjectInputStream(fis);
		mex = (Message) ois.readObject();
		ois.close();		
	}

}
