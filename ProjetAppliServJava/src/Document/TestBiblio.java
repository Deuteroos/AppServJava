package Document;

import org.junit.jupiter.api.Test;

class TestBiblio {

	Bibliotheque B = Bibliotheque.getInstance();
	Document D = new Livre(2, "Le soir");
	
	@Test
	void testGetDoc() {
		B.ajoutDoc(D);
		B.getDocByNum(2);
	}
	
}
