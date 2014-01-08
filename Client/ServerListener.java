package Client;

import java.net.DatagramSocket;
/**
 * Receives the commands from the server
 * @author Tobi
 *
 */
public class ServerListener {
	DatagramSocket socket;
	/**
	 * The Listener for the UDP Connection
	 * @param socket the datagram socket to check
	 */
	public ServerListener(DatagramSocket socket) {
		 this.socket=socket;
	}
 
	/**
	 * method which checks 
	 */
	public void waitForConnection() {
	 
	}
	 
	
	 
}
 
