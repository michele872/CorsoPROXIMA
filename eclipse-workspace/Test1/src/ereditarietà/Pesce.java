package ereditarietà;

public class Pesce extends EssereVivente implements Nuota , NonParlano {
	String razza;
	int numPinne;
	String tipoAcqua;
	
	public void stampaRazza() {
		System.out.println(razza);
	}
	
	public void stampaNumPinne() {
		System.out.println(numPinne);
	}
	
	public void stampaTipoAcqua() {
		System.out.println(tipoAcqua);
	}

	@Override
	public void nuota() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nonParlano() {
		// TODO Auto-generated method stub
		
	}

	
}
