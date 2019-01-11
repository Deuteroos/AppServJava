package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Abonne.Abonne;
import Document.Document;

public class Retour extends Service{

	public Retour(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("*********Connexion "+this.getClass()+" d�marr�e");
		System.out.println("*********Connexion "+this.getClient().getInetAddress());
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(getClient().getInputStream ( )));
			PrintWriter out = new PrintWriter (getClient().getOutputStream ( ), true);
			Abonne a = null;
			while(a == null) {
				String line = in.readLine();
				int numAbo = Integer.parseInt(line);
				try {
					a = getBaseAbo().getAboByNum(numAbo);					
				}
				catch(IllegalArgumentException i){
					out.print("Erreur de connexion, l'identification a �chou� !");
				}
			}
			out.println("Connexion r�ussie !");
			Document d = null;
			while(d == null) {
				String line = in.readLine();
				int numDoc = Integer.parseInt(line);
				try {
					d = getBiblio().getDocByNum(numDoc);	
					synchronized (d) {
						d.retour();
					}
					out.println("Le document a �t� retourn� avec succ�s !");
				}
				catch(IllegalArgumentException i){
					out.print("Erreur, le document demand� n'existe pas !");
				}
			}
			
		}
		catch (IOException e) {
		}
		//Fin du service d'emprunt
		System.out.println("*********Connexion "+this.getClass()+" termin�e");
		try {getClient().close();} catch (IOException e2) {}
	}

}
