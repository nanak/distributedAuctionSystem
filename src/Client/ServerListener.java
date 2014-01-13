package Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				System.out.println(packet.getData());
				// Empfänger auslesen (brauchma nicht, td mal drin lassen weils nett is)
//				InetAddress address = packet.getAddress();
//				int         port    = packet.getPort();
//				int         len     = packet.getLength();
//				byte[]      data    = packet.getData();
//				System.out.printf( "Anfrage von %s vom Port %d mit der Länge %d:%n%s%n",
//						address, port, len, new String( data, 0, len ) );
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

