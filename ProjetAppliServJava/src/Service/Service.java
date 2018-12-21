package Service;

import java.net.Socket;

import Abonne.BaseAbonne;
import Document.Bibliotheque;

public abstract class Service implements Runnable {
	
	private static Bibliotheque biblio;
	private final Socket client;
	private static BaseAbonne baseAbo;
	
	public Service(Socket socket) {
		this.client = socket;
		this.biblio = Bibliotheque.getInstance();
		this.baseAbo = BaseAbonne.getInstance();
	}
	
	public Socket getClient() {
		return client;
	}

	public static Bibliotheque getBiblio() {
		return biblio;
	}
	
	public static BaseAbonne getBaseAbo() {
		return baseAbo;
	}
	
	protected void finalize() throws Throwable {
		 client.close(); 
	}

	public void lancer() {
		new Thread(this).start();
	}
}
