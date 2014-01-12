package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Manages a connection from a user
 * @author Tobi
 *
 */
public class ManageConnection implements Runnable {

	private User user;
	private Socket socket;

	/**
	 * manages a connection from a client
	 * @param socket client socket
	 */
	public  ManageConnection(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		BufferedReader in;
		try{ 
			while(true){
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				char[] buffer = new char[200];
				int length = in.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
				String message = new String(buffer, 0, length);
				System.out.println(message); //received command as string!
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}

