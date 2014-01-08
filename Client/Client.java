package Client;

/**
 * Der Client des Auction Systems
 * Empfaengt 
 * @author Tobi
 *
 */
public class Client {
 
	private String host;
	 
	private int tcpport;
	 
	private int udpport;
	 
	private DatagramSocket udpsocket;
	 
	private ServerListener serverListener;
	 
	public Client(String host, int tcp, int udp) {
	
	}
	 
	public boolean send() {
		return false;
	}
	 
	public boolean receive(String command) {
		return false;
	}
	 
	public void shutdown() {
	 
	}
	 
}
 
