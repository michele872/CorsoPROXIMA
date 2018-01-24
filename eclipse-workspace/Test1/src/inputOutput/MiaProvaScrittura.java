package inputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MiaProvaScrittura {
			
	public static String cambiaNome(String nome) {
		String fileOrigine = nome.substring(27, 33);
		return fileOrigine;
	}
	
	public static String dataCorrente() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		String data = dateFormat.format(new Date());
		return data;		
	}
	
	public static void copiaFile(File f1, File f2, File f3) throws IOException {		
		if(!f2.exists()) {
			f2.mkdir();
			if(!f3.exists()) {
				f3.createNewFile();
			} //else {
//				f2.renameTo();
//			}
		}
		BufferedReader in = new BufferedReader(new FileReader(f1));
		String s, s2 = new String();
		while ((s = in.readLine()) != null) {
			s2 += s + "\n";
		}
		FileOutputStream fos = new FileOutputStream(f3);
		PrintWriter pw = new PrintWriter(fos);
		pw.println(s2);
		pw.close();
		in.close();
		
	}
	
//	public static void creaFile() throws FileNotFoundException {				
//		if (!f.isDirectory()) {
//			f.mkdir();
//			if(!f1.exists()) {
//				try {
//					f1.createNewFile();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		FileOutputStream fos = new FileOutputStream(f1);
//		PrintWriter pw = new PrintWriter(fos);
//		pw.write("testo di prova scrittura su file");
//		pw.close();		
//	}

	public static void main(String[] args) throws IOException  {
		String fileDiOrigine = "";
		String cartellaDiOrigine = "";
		String FileDiDestinazione = ""; // "C:/Users/UTENTE8/Desktop/FileCopiato/prova2.txt";
		String cartellaDiDestinazione = "";
		
		//String nomeNuovo = FileDiDestinazione.concat(cambiaNome(fileDiOrigine)+ " " + dataCorrente() + ".txt");
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Inserisci il percorso del file da copiare:");	
			fileDiOrigine = stdin.readLine();
			System.out.println(fileDiOrigine);
		File f1 = new File(fileDiOrigine);
		
		System.out.println("Inserisci il percorso in cui copiare il file:");
			cartellaDiDestinazione = stdin.readLine();
			System.out.println(cartellaDiDestinazione);
		File f2 = new File(cartellaDiDestinazione);
		
		System.out.println("Inserisci il nome del file");
			FileDiDestinazione = cartellaDiDestinazione + "/" + stdin.readLine();
			System.out.println(FileDiDestinazione);
		File f3 = new File(FileDiDestinazione);
//		try {
//			creaFile();
//		} catch (FileNotFoundException e) {
//			System.out.println("File inesistente!!");
//		}
			copiaFile(f1, f2, f3);
			stdin.close();
		
	}
}