package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingServer {

	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public Connection accept() {
		
		Socket socket = null;
		Connection connection = null;

		// TODO
		// accept TCP connection on welcome socket and create messaging connection
		
		try {
			socket = welcomeSocket.accept();
			connection = new Connection(socket);
		}catch(IOException ex) {
			ex.printStackTrace();
		}

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
