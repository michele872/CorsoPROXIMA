package ereditarietà;

public class Cane extends EssereVivente implements SaCamminare, NonParlano{
	String razza;
	int numOcchi;
	String tipoPelo;
	
	public void stampaRazza() {
		System.out.println(razza);
	}
	
	public void stampaTipoPelo() {
		System.out.println(tipoPelo);
	}
	
	public void stampaNumOcchi() {
		System.out.println(numOcchi);
	}

	@Override
	public void cammina() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nonParlano() {
		// TODO Auto-generated method stub
		
	}
}
