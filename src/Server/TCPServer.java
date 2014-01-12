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
public class TCPServer{
	/**
	 * TCP Connection from Server
	 * @param port Port of TCP
	 */
	public TCPServer(int port){
		int portNumber = port;
		try{
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while(true){
				System.out.println("start");
				Socket p=serverSocket.accept();
				System.out.println("accepted");
				Thread t=new Thread(new ManageConnection(p));  
				t.start();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
//		try (
//				ServerSocket serverSocket = new ServerSocket(portNumber);
//				Socket clientSocket = serverSocket.accept();     
//				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
//				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//			) {
//			String inputLine;
//			while ((inputLine = in.readLine()) != null) {
//				out.println(inputLine);
//			}
//		} catch (IOException e) {
//			System.out.println("Exception caught when trying to listen on port "
//					+ portNumber + " or listening for a connection");
//			System.out.println(e.getMessage());
//		}
	}
}