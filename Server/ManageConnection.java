package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ManageConnection implements Runnable{

	private User user;

	private final Socket clientSocket;

	public ManageConnection(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Got a client !");
			BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			char[] buffer = new char[200];
			int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
			String nachricht = new String(buffer, 0, anzahlZeichen);
			System.out.println(nachricht);

			clientSocket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

