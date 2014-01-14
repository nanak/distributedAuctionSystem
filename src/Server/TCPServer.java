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
	private boolean hasToRun = true;
	Socket p;
	ServerSocket serverSocket;
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
			serverSocket = new ServerSocket(portNumber);
//			serverSocket.setSoTimeout(1000);
			while(hasToRun){
				p=serverSocket.accept();
				Thread t=new Thread(new ManageConnection(p, commands));  
				t.start();
			}
			serverSocket.close();
			System.out.println("Server shut down successfully");
		}catch (Exception e){
			System.out.println("socket closed");
		}
	}
	
	/**
     * @param hasToRun the hasToRun to set
     */
    public void setHasToRun(boolean hasToRun) {
    	try {
			serverSocket.close();
	    	p.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.hasToRun = hasToRun;
    }

	public void isHasToRun() {
		System.out.println(hasToRun);
		
	}

}