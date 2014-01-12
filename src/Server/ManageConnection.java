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
	private BufferedReader in;
	private CommandMapFactory commands;

	/**
	 * manages a connection from a client
	 * @param socket client socket
	 */
	public  ManageConnection(Socket socket, CommandMapFactory commands) {
		this.socket=socket;
		this.commands=commands;
	}

	@Override
	public void run() {
		while(true){
			receive();
		}
	}

	/**
	 * Sends a command to the auction server
	 * @param command command to be sent on the server
	 * @return is command sent successfully
	 */
	public boolean send(String command) {
		return false;
	}


	/**
	 * Handles the received command
	 */
	public void receive() {
		try{ 
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			char[] buffer = new char[200];
			int length = in.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
			String message = new String(buffer, 0, length);
			System.out.println(message); //received command as string!
			commands.runCommand(message);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

