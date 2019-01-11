package Serveur;

import java.io.IOException;

import Service.Retour;

public class ServeurRetour extends Serveur {

	public ServeurRetour() throws IOException {
		super(2700);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			 new Retour(getListen_socket().accept()).lancer(); 
		} 
		catch(IOException e) {
			try {this.getListen_socket().close();} catch(IOException e1) {}
			System.err.println("Pb sur le port d'écoute :" + e);
		}
	}

}
