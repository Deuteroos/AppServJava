package Serveur;

import java.io.IOException;
import java.net.ServerSocket;

public abstract class Serveur implements Runnable{
	
	private ServerSocket listen_socket;
	
	public Serveur(int port) throws IOException {
		listen_socket = new ServerSocket(port);
	}
	
	public ServerSocket getListen_socket() {
		return listen_socket;
	}

	protected void finalize() throws Throwable {
		try {this.listen_socket.close();} catch (IOException e1) {}
	}
}
