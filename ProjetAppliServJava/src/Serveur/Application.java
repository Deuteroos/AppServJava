package Serveur;

import java.io.IOException;

import Abonne.Abonne;
import Abonne.BaseAbonne;
import Document.Bibliotheque;
import Document.Document;
import Document.Livre;

public class Application {

	private final static int PORT1 = 2500;
	private final static int PORT2 = 2600;
	private final static int PORT3 = 2700;
	

	public static void main(String[] args) {
		Bibliotheque b = Bibliotheque.getInstance();
		Document Doc = new Livre(1, "salut");
		Document Do = new Livre(2, "cava");
		Abonne A = new Abonne(1);
		BaseAbonne c = BaseAbonne.getInstance();
		b.ajoutDoc(Doc);
		b.ajoutDoc(Do);
		c.ajoutAbo(A);
		
		try {
			new Thread(new ServeurReservation()).start();
			System.out.println("Serveur lance sur le port " + PORT1);
			new Thread(new ServeurEmprunt()).start();
			System.out.println("Serveur lance sur le port " + PORT2);
			new Thread(new ServeurRetour()).start();
			System.out.println("Serveur lance sur le port " + PORT3);

			
		} catch (IOException e) {
				System.err.println("Pb lors de la création du serveur : " +  e);			
		}
	}
}
