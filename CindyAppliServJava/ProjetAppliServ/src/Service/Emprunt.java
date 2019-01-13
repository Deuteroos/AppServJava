package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Abonne.Abonne;
import Document.Document;
import Document.PasLibreException;

public class Emprunt extends Service{

	
	public Emprunt(Socket socket) {
		super(socket);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("*********Connexion "+this.getClass()+" demarree");
		System.out.println("*********Connexion "+this.getClient().getInetAddress());
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(getClient().getInputStream ( )));
			PrintWriter out = new PrintWriter (getClient().getOutputStream ( ), true);
			Abonne a = null;
			while(a == null) {
				String line = in.readLine();
				//System.out.println(line);
				int numAbo = Integer.parseInt(line);
				try {
					a = getBaseAbo().getAboByNum(numAbo);					
				}
				catch(IllegalArgumentException i){
					out.println("Erreur de connexion, l'identification a echoue !");
				}
			}
			out.println("Connexion reussie !");
			Document d = null;
			while(d == null) {
				String line = in.readLine();
				int numDoc = Integer.parseInt(line);
				try {
					d = getBiblio().getDocByNum(numDoc);	
					synchronized (d) {
						d.emprunter(a);
					}
					out.println("Le document a ete emprunte avec succes !");
				}
				catch(IllegalArgumentException i){
					out.println("Erreur, le document demande n'existe pas !");
				}
				catch(PasLibreException e){
					out.println("Le document demande n'est pas disponible !");
					d=null;
				}
			}			
		}
		catch (IOException e) {
		}
		//Fin du service d'emprunt
		System.out.println("*********Connexion "+this.getClass()+" terminee");
		try {getClient().close();} catch (IOException e2) {}
	}
}
