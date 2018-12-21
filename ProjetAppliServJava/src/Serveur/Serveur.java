package Serveur;

import java.io.IOException;
import java.net.ServerSocket;

public abstract class Serveur implements Runnable{
	protected ServerSocket listen_socket;

	
	public Serveur(int port) throws IOException {
		listen_socket = new ServerSocket(port);
	}
	
	
	protected void finalize() throws Throwable {
		try {this.listen_socket.close();} catch (IOException e1) {}
	}
}
