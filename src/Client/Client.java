package Client;

/**
 * The client of Auction System
 * It interacts with the server
 * 
 * @author Tobi
 *
 */
public class Client {
	
	private TCPConnection tcp;
	
	private UDPConnection udp;
	 
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
	}
	 
	/**
	 * Shuts down the client and gives free the resources
	 */
	public void shutdown() {
	 
	}
	 
}
 
