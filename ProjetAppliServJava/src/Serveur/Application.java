package Serveur;

import java.io.IOException;

public class Application {

	private final static int PORT1 = 2500;
	private final static int PORT2 = 2600;
	private final static int PORT3 = 2700;
	

	public static void main(String[] args) {
		/*try {
			new Thread(new ServeurReservation(PORT1)).start();
			System.out.println("Serveur lance sur le port " + PORT1);
			new Thread(new ServeurEmprunt(PORT2)).start();
			System.out.println("Serveur lance sur le port " + PORT2);
			new Thread(new ServeurRetour(PORT3)).start();
			System.out.println("Serveur lance sur le port " + PORT3);

			
		} catch (IOException e) {
				System.err.println("Pb lors de la création du serveur : " +  e);			
		}*/
	}
}
