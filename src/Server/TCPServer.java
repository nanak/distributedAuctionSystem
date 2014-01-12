package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The TCP Connection of the Server
 * @author Tobi
 *
 */
public class TCPServer implements Runnable{
	
	private int port;
	private CommandMapFactory commands;
	/**
	 * TCP Connection from Server
	 * @param port Port of TCP
	 */
	public TCPServer(int port, CommandMapFactory commands){
		this.port=port;
		this.commands=commands;
	}

	@Override
	public void run() {
		int portNumber = port;
		try{
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while(true){
				Socket p=serverSocket.accept();
				Thread t=new Thread(new ManageConnection(p, commands));  
				t.start();
			}
		}catch (Exception e){
			System.out.println("socket could not be created");
		}
		
	}

}