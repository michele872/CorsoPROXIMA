import java.util.Scanner;

public class Prova2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci i due numeri da sommare!!!");

		//Prova2 p = new Prova2();
		int a = in.nextInt();
		int b = in.nextInt();
		Calcolo c = new Calcolo();		
		System.out.println(c.somma(a, b));
		in.close();
	}

}
