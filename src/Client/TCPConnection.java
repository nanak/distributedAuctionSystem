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
		try{
			s=new Socket(host,port);
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String input;
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
			username="";
			System.out.print("> ");
			while (true) {		
				input = bufferRead.readLine();
				
				
				if(!username.equals("")){
					sendMessage(input+"&&"+username);
					
				}else{
					if(input.startsWith("!login")||input.startsWith("!list")||input.startsWith("!end")){
						sendMessage(input);
					}else if(input.equals("!info")){
						System.out.print("Commands:\n!list\n!!login username\n!create duration description\n!bid auctionId amount\n!logout\n"+username+">");
					}
					else if(input.equals("!end")){
						//read.shut
						s.close();
					}
					else{
						System.out.print("Allowed commands: !login !list\n> ");
					}
				}
				if(input.startsWith("!login")){
					try{
						username=input.split(" ")[1];
					}catch (ArrayIndexOutOfBoundsException e){
						username="";
					}
				}
				if(input.equals("!logout")){
					username="";
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
	public void sendMessage(String nachricht) throws IOException {
		PrintWriter printWriter =new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		printWriter.print(nachricht);
		printWriter.flush();
	}
	/**
	 * Reads the message from the server
	 * @param socket socket to read from
	 * @return String got from server
	 * @throws IOException exception when it cant read
	 */
	private String readMessage(Socket socket) throws IOException {
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
		char[] buffer = new char[200];
		int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
		String nachricht = new String(buffer, 0, anzahlZeichen);
		return nachricht;
	}
}