package Document;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Abonne.Abonne;

class TestDoc {
	
	Document Doc = new Livre(1, "Le matin"); 
	Abonne a = new Abonne(1);
	Abonne b = new Abonne(2);
	
	@Before
	public void init_test() {
	
	}
	
	@Test
	void testReservationOK() throws PasLibreException {		
		Doc.reserver(a);		
	}
	
	@Test
	void testReservationKO() throws Exception {		
		Doc.reserver(a);
		try {
			Doc.reserver(b);
			throw new Exception();
		} catch (PasLibreException e) {
			return;
		}
	}
	
	
	@Test
	void testEmpreintLibre() throws PasLibreException {		
		Doc.emprunter(a);		
	}
	
	@Test
	void testEmpreintReserverDif() throws Exception {
		Doc.reserver(b);
		try {
			Doc.emprunter(a);
			throw new Exception();
		} catch (PasLibreException e) {
			return;
		}
	}
	
	@Test
	void testEmpreintReserverOK() throws PasLibreException {	
		Doc.reserver(a);
		Doc.emprunter(a);		
	}
	
	@Test
	void testEmpreintIndisp() throws Exception {	
		Doc.emprunter(b);	
		try {
			Doc.emprunter(a);
			throw new Exception();
		} catch (PasLibreException e) {
			return;
		}
	}
	
	@Test
	void testRetour() throws Exception {	
		Doc.emprunter(b);
		Doc.retour();
		Doc.emprunter(a);
	}	
}