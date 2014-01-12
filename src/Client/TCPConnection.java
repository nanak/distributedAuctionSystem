package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The TCP Connection of the Client
 * @author Tobi
 *
 */
public class TCPConnection{
	/**
	 * TCP Connection from Client
	 * @param host IP of Server
	 * @param port Port of TCP
	 */
	public TCPConnection(String host,int port){
		try{
			Socket s=new Socket(host,port);
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String input;
			while (true) {
				input = bufferRead.readLine();
				sendMessage(s, input);
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}

//		try (
//				Socket echoSocket = new Socket(host, port);
//				PrintWriter out =new PrintWriter(echoSocket.getOutputStream(), true);
//				BufferedReader in =new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
//				BufferedReader stdIn =new BufferedReader(new InputStreamReader(System.in))
//				) {
//			String userInput;
//			while ((userInput = stdIn.readLine()) != null) {
//				out.println(userInput);
//				System.out.println("echo: " + in.readLine());
//			}
//		} catch (UnknownHostException e) {
//			System.err.println("Don't know about host " + host);
//			System.exit(1);
//		} catch (IOException e) {
//			System.err.println("Couldn't get I/O for the connection to " + host);
//			System.exit(1);
//		} 
	}
	/**
	 * Sending a message to the specified socket as a string
	 * @param socket
	 * @param nachricht
	 * @throws IOException
	 */
	public void sendMessage(Socket socket, String nachricht) throws IOException {
		PrintWriter printWriter =new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		printWriter.print(nachricht);
		printWriter.flush();
	}
}