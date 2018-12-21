package Service;

import Document.Bibliotheque;

public abstract class Service implements Runnable {
	private static Bibliotheque biblio;

	
	public void lancer() {
		new Thread(this).start();
	}

	public static Bibliotheque getBiblio() {
		return biblio;
	}
}
