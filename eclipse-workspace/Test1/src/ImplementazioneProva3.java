
public class ImplementazioneProva3 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Prova3 p1 = new Prova3();
		Prova3 p2 = new Prova3();
		
		p1.numero = 10;
		
		System.out.println("Il valore numerico per l'istanza 1 �: " + p1.numero); 
		
		p2.numero++;
		
		System.out.println("Il valore numerico per l'istanza 2 �: " + p2.numero);
	}

}
