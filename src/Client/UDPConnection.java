package Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * The UDP Connection of the Client
 * @author Michi,Tobi
 *
 */
public class UDPConnection{

	DatagramSocket socket;
	/**
	 * UDP Connection from Client
	 * @param host IP of Server
	 * @param port Port of UDP
	 */
	public UDPConnection(String host,int port){
		// NO NEED
		
	}
	public DatagramSocket getSocket(){
		return this.socket;
	}
}