package Serveur;

import java.io.IOException;

import Service.Emprunt;

public class ServeurEmprunt extends Serveur{
	
	public ServeurEmprunt() throws IOException {
		super(2600);
		// TODO Auto-generated constructor stub
	}

	public void run() {		 
		try {
			while(true)
			 new Emprunt(getListen_socket().accept()).lancer(); 
		} 
		catch(IOException e) {
			try {this.getListen_socket().close();} catch(IOException e1) {}
			System.err.println("Pb sur le port d'écoute :" + e);
		}
	}	
}
