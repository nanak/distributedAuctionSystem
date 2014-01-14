package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.AllPermission;

/**
 * The TCP Connection of the Client
 * @author Tobi
 *
 */
public class TCPConnection{

	private String username;
	private Socket s;
	private Thread t;
	/**
	 * TCP Connection from Client
	 * @param host IP of Server
	 * @param port Port of TCP
	 */
	public TCPConnection(String host,int port){
		try {
			s=new Socket(host,port);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
			System.out.println("Cant find server");
		} catch (IOException e1) {
			System.out.println("Port already in use");
		}
		Thread read=new Thread() {
			boolean t=true;
			@Override
			public void run() {
				while(t){
					try{
						System.out.print(readMessage(s));
					}catch (Exception e){
						t=false;
						System.out.println("Connection to server lost!");
					}
				}

			}
			public void shutdown(){
				this.t=false;
			}
		};
		read.start();
	}
	/**
	 * Sending a message to the specified socket as a string
	 * @param socket
	 * @param nachricht
	 * @throws IOException
	 */
	public void sendMessage(String nachricht)  {
		try{
			PrintWriter printWriter =new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			printWriter.print(nachricht);
			printWriter.flush();
		}catch (Exception e){
			System.out.println("Cant send message to server");
		}
	}


	/**
	 * Reads the message from the server
	 * @param socket socket to read from
	 * @return String got from server
	 * @throws IOException exception when it cant read
	 */
	private String readMessage(Socket socket) {
		try{
			BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			char[] buffer = new char[200];
			int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
			String nachricht = new String(buffer, 0, anzahlZeichen);
			return nachricht;
		}catch (Exception e){
			return "";
		}

	}
}
