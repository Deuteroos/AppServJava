package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Document.Document;

public class Retour extends Service{

	public Retour(Socket socket) {
		super(socket);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("*********Connexion "+this.getClass()+" démarrée");
		System.out.println("*********Connexion "+this.getClient().getInetAddress());
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(getClient().getInputStream ( )));
			PrintWriter out = new PrintWriter (getClient().getOutputStream ( ), true);
			
			Document d = null;
			while(d == null) {
				String line = in.readLine();
				int numDoc = Integer.parseInt(line);
				try {
					d = getBiblio().getDocByNum(numDoc);	
					synchronized (d) {
						d.retour();;
					}
					out.println("Le document a été retourné avec succès !");
				}
				catch(IllegalArgumentException i){
					out.println("Erreur, le document demandé n'existe pas !");
				}
			}			
		}
		catch (IOException e) {
		}
		//Fin du service d'emprunt
		System.out.println("*********Connexion "+this.getClass()+" terminée");
		try {getClient().close();} catch (IOException e2) {}
	}

}
