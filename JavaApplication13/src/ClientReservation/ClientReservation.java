package ClientReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientReservation {
	private Socket socket;
	private int numAbo;
	private int numDoc;
	private final static int PORT = 2500;
	
	public ClientReservation() throws UnknownHostException, IOException {
		this.socket = new Socket(InetAddress.getLocalHost(), PORT);
	}
	
	public void setNumAbo(int numAbo) {
		this.numAbo = numAbo;		
	}
	
	public void reserver() {
		try {
			System.out.println("*********Bienvenue sur notre service de reservation");
			BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter out = new PrintWriter (socket.getOutputStream ( ), true);
			String line = "";
			while(!line.equals("Connexion reussie !")) {
				demandeNumAbo();
				System.out.println(numAbo);
				out.println(numAbo);
				line = in.readLine();
				reponseServeur(line);
			}
			line = "";
			while(!line.equals("Le document a ete reserve avec succes !")) {
				demandeNumDoc();
				out.println(numDoc);
				line = in.readLine();
				reponseServeur(line);
			}
		}
		catch (IOException e) {
		}
		//Fin du service d'emprunt
		System.out.println("*********Connexion "+this.getClass()+" terminee");
		try {socket.close();} catch (IOException e2) {}
	}

	private void demandeNumDoc() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Veuillez entrer le numero du document");
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
		numDoc = Integer.parseInt(clavier.readLine());
	}

	private void demandeNumAbo() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Veuillez entrer votre numero d'abonne");
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
		numAbo = Integer.parseInt(clavier.readLine());
	}
	
	private void reponseServeur(String s) {
		System.out.println(s);
	}
}
