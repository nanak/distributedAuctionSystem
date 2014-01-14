package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * The client of Auction System
 * It interacts with the server
 * 
 * @author Tobi
 *
 */
public class Client {

	private TCPConnection tcp;
	private ServerListener serverListener;
	private boolean stop=true;
	/**
	 * Client constructor
	 * @param host	IP of the server
	 * @param tcp	TCP port of the server
	 * @param udp	UDP port of the server
	 */
	public Client(String host, int tcp, int udp) {
		this.serverListener=new ServerListener(udp);
		Thread t=new Thread(serverListener);
		t.start();
		this.tcp=new TCPConnection(host, tcp);
		listenConsole();
	}
	public void listenConsole(){
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		String username="";
		Scanner in = new Scanner(System.in);
	 //   System.out.println(in.nextLine());
		System.out.print("> ");
		while (stop) {		
			try {
				input = bufferRead.readLine();
				} catch (IOException e1) {
				System.out.println("cant read command line");
			}
			try {
				if(!username.equals("")){
					if(input.equals("!info")){
						System.out.print("Commands:\n!list\n!!login username\n!create duration description\n!bid auctionId amount\n!logout\n"+username+">");
					}
					else if(input.equals("!end")){
						this.tcp.sendMessage("!logout");
						stop=false;
						shutdown();
					}	
					else{
						this.tcp.sendMessage(input+"&&"+username);
					}
				}
			} catch (IOException e) {
				System.out.println("cant send message");
			}
			if(input.startsWith("!login")){
				try{
					username=input.split(" ")[1];
				}catch (ArrayIndexOutOfBoundsException e){
					username="";
				}
			}
			else if(input.equals("!info")){
				System.out.print("Commands:\n!list\n!!login username\n!create duration description\n!bid auctionId amount\n!logout\n"+username+">");
			}
			if(input.equals("!logout")){
				username="";
			}
			if(input.equals("!end")){
				stop=false;
				shutdown();
			}
		}
	}

	/**
	 * Shuts down the client and gives free the resources
	 */
	public void shutdown() {
		serverListener.stop();
	}

}

