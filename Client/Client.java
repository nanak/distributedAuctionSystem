package Client;

/**
 * The client of Auction System
 * It interacts with the server
 * 
 * @author Tobi
 *
 */
public class Client {
 
	private String host;
	 
	private int tcpport;
	 
	private int udpport;
	 
	private DatagramSocket udpsocket;
	 
	private ServerListener serverListener;
	
	/**
	 * Client constructor
	 * @param host	IP of the server
	 * @param tcp	TCP port of the server
	 * @param udp	UDP port of the server
	 */
	public Client(String host, int tcp, int udp) {
		this.host=host;
		this.tcpport=tcp;
		this.udpport=udp;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean send() {
		return false;
	}
	 
	public boolean receive(String command) {
		return false;
	}
	 
	public void shutdown() {
	 
	}
	 
}
 
