package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Emprunt extends Service{

	private final Socket client;
	
	public Emprunt(Socket socket) {
		this.client = socket;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("*********Connexion "+this.numero+" démarrée");
		System.out.println("*********Connexion "+this.client.getInetAddress());
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream ( )));
			PrintWriter out = new PrintWriter (client.getOutputStream ( ), true);
			String line = in.readLine();
			//System.out.println("Connexion "+this.numero+" <-- "+line);
			
			
			//System.out.println("Connexion "+this.numero+" --> "+invLine);
		}
		catch (IOException e) {
		}
		//Fin du service d'inversion
		//System.out.println("*********Connexion "+this.numero+" terminée");
		try {client.close();} catch (IOException e2) {}
	}
	
	

}
