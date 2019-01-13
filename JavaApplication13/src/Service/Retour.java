package Service;

import Abonne.Abonne;
import Abonne.BaseAbonne;
import Abonne.PasEmprunteExceptuin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Document.Document;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Retour extends Service{

	public Retour(Socket socket) {
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
			
			Document d = null;
			while(d == null) {
				String line = in.readLine();
                                System.out.println(line);
				int numDoc = Integer.parseInt(line);
				try {
					d = getBiblio().getDocByNum(numDoc);
                                        out.println("Le document a-t-il ete degrade? (o/n)");
                                        while((!line.equals("o"))&&(!line.equals("n"))){
                                            line=in.readLine();
                                            System.out.println(line);
                                            if(line.equals("o")){
                                                BaseAbonne base=getBaseAbo();
                                                try {
                                                    Abonne a=base.getPossesseur(d);
                                                    synchronized(a){
                                                        a.interdire();
                                                    }
                                                } catch (PasEmprunteExceptuin ex) {
                                                    System.err.println("Document n°"+d.numero()+" a été retourné sans avoir été emprunté");
                                                }
                                            }
                                        }
					synchronized (d) {
                                            
						d.retour();
                                                
					}
					out.println("Le document a ete retourne avec succes !");
				}
				catch(IllegalArgumentException i){
					out.println("Erreur, le document demandes n'existe pas !");
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
