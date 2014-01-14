package Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
 * Receives the commands from the server
 * @author Tobi
 *
 */
public class ServerListener implements Runnable{
	DatagramSocket socket;
	/**
	 * The Listener for the UDP Connection
	 * @param socket the datagram socket to check
	 */
	public ServerListener(int port) {
		try {
			this.socket=new DatagramSocket(port);	
		} catch (SocketException e) {
			System.out.println("UDP Server already running!");
			System.exit(1);
		}

	}

	/**
	 * method which checks 
	 */
	public void waitForConnection() {
		try{
			while ( true ){
				// Auf Anfrage warten (DatagramPacket)
				DatagramPacket packet = new DatagramPacket( new byte[1024], 1024 );
				socket.receive( packet ); //tatsaechliches empfangen
				System.out.println(new String(packet.getData()));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		waitForConnection();
	}
}

