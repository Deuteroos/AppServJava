package ClientRetour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRetour {
	private Socket socket;
	private int numDoc;
	private final static int PORT = 2700;
        private String degrad;
	
	public ClientRetour() throws UnknownHostException, IOException {
		this.socket = new Socket(InetAddress.getLocalHost(), PORT);
	}
	
	public void retourner() {
		try {
			System.out.println("*********Bienvenue sur notre service de retour");
			BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter out = new PrintWriter (socket.getOutputStream ( ), true);
			String line = "";
			while(!line.equals("Le document a-t-il ete degrade? (o/n)")) {
                            demandeNumDoc();
                            out.println(numDoc);
                            line = in.readLine();
                            reponseServeur(line);
			}
                        while(!line.equals("Le document a ete retourne avec succes !")) {
                            demandeDegrad();
                            out.println(degrad);
                            line=in.readLine();
                            reponseServeur(line);
                        }
		}
		catch (IOException e) {
		}
		//Fin du service d'emprunt
		System.out.println("*********Connexion "+this.getClass()+" terminee");
		try {socket.close();} catch (IOException e2) {}
	}

	private void demandeNumDoc() throws  IOException {
		// TODO Auto-generated method stub
		System.out.println("Veuillez entrer le numero du document");
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
                try{
                    numDoc = Integer.parseInt(clavier.readLine());
                }
                catch (NumberFormatException ex){
                    System.out.println("Erreur, la valeur entrée n'est pas un numero.");
                    numDoc = Integer.parseInt(clavier.readLine());
                }
	}
        
        private void demandeDegrad() throws IOException{
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
            degrad=clavier.readLine();
        }
	
	private void reponseServeur(String s) {
		System.out.println(s);
	}
}
