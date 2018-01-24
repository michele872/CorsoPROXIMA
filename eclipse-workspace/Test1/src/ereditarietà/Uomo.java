package ereditarietà;

public class Uomo extends EssereVivente implements SaCamminare, Nuota {
	String sesso;
	int altezza;
	
	public void stampaSesso() {
		System.out.println(sesso);
	}
	
	public void stampaAltezza() {
		System.out.println(altezza);
	}

	@Override
	public void cammina() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void nuota() {
		// TODO Auto-generated method stub
		
	}
}
