package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
		Runnable receiver=new Runnable() {
			@Override
			public void run() {
				while(true){
					receive();
				}
			}
		};
		Thread t=new Thread(receiver);
		t.start();	
	}

	/**
	 * Sends a command to the auction server
	 * @param cmd command to be sent on the server
	 */
	public void send(String cmd) {
		try{ 
			PrintWriter printWriter =new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			printWriter.print(cmd);
			printWriter.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
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
			//System.out.println(message); //received command as string!
			System.out.println(socket.getInetAddress());
			commands.runCommand(message+" "+socket.getInetAddress(),this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

