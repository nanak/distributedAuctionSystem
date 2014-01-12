package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The TCP Connection of the Client
 * @author Tobi
 *
 */
public class TCPConnection{

	private String username;
	/**
	 * TCP Connection from Client
	 * @param host IP of Server
	 * @param port Port of TCP
	 */
	public TCPConnection(String host,int port){
		try{
			final Socket s=new Socket(host,port);
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String input;
			Runnable read=new Runnable() {

				@Override
				public void run() {
					while(true){
						try{
							System.out.println(readMessage(s));
						}catch (Exception e){
							e.printStackTrace();
						}
					}

				}
			};
			Thread t=new Thread(read);
			t.start();
			username="";
			while (true) {
				input = bufferRead.readLine();
				if(input.startsWith("!login")){
					username=input.split("!login")[1];
				}
				if(!username.equals("")){
					sendMessage(s, input+" "+username);
				}else{
					sendMessage(s, input);
				}	
			}

		}catch (ConnectException e){
			System.out.println("Server not reachable!");
		}catch (IOException e){
			System.out.println("error");
		}
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

	private String readMessage(Socket socket) throws IOException {
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
		char[] buffer = new char[200];
		int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
		String nachricht = new String(buffer, 0, anzahlZeichen);
		return nachricht;
	}
}