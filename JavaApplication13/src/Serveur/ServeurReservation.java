package Serveur;

import java.io.IOException;
import Service.Reservation;

public class ServeurReservation extends Serveur{

	public ServeurReservation() throws IOException {
		super(2500);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		try {
			while(true)
			 new Reservation(getListen_socket().accept()).lancer(); 
		} 
		catch(IOException e) {
			try {this.getListen_socket().close();} catch(IOException e1) {}
			System.err.println("Pb sur le port d'écoute :" + e);
		}
	}

}