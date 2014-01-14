package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;

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

	/**
	 * Client constructor
	 * @param host	IP of the server
	 * @param tcp	TCP port of the server
	 * @param udp	UDP port of the server
	 */
	public Client(String host, int tcp, int udp) {
		this.serverListener=new ServerListener(udp);
		new Thread(serverListener).start();
		this.tcp=new TCPConnection(host, tcp);
		listenConsole(udp);
	}

	public void listenConsole(int udp){
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String username="";
		String input;
		System.out.print("> ");
		try {
			while (true) {		
				input = bufferRead.readLine();
				if(!username.equals("")){
					this.tcp.sendMessage(input+"&&"+username);

				}else{
					if(input.startsWith("!login")||input.startsWith("!list")){
						if(input.startsWith("!login")){
							this.tcp.sendMessage(input+"port:"+udp);
						}else{
							this.tcp.sendMessage(input);
						}

					}else if(input.equals("!info")){
						System.out.print("Commands:\n!list\n!!login username\n!create duration description\n!bid auctionId amount\n!logout\n"+username+">");
					}
					else if(input.equals("!end")){
						//read.shut
						//this.tcp.close();
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Shuts down the client and gives free the resources
	 */
	public void shutdown() {

	}

}

