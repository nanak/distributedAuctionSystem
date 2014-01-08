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
	 
	private DatagramSocket udpsocket;
	 
	private ServerListener serverListener;
	
	/**
	 * Client constructor
	 * @param host	IP of the server
	 * @param tcp	TCP port of the server
	 * @param udp	UDP port of the server
	 */
	public Client(String host, int tcp, int udp) {
		this.tcp=new TCPConnection(host, tcp);
		this.udp=new UDPConnection(host, udp);
	}
	
	/**
	 * Sends a command to the auction server
	 * @param command command to be sent on the server
	 * @return is command sent successfully
	 */
	public boolean send(String command) {
		return false;
	}
	
	
	/**
	 * Handles the received command
	 * @param command received command to handle
	 * @return boolean is command processed
	 */
	public boolean receive(String command) {
		return false;
	}
	 
	/**
	 * Shuts down the client and gives free the ressources
	 */
	public void shutdown() {
	 
	}
	 
}
 
