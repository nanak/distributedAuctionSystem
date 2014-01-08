package datagramPrototype;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Klasse Client, die eine benachrichtigung vom Server empfängt
 * @author mlipovits
 * @version 2013-12-09
 */
public class Client {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		//datagramSocket mit port 4711 öffnen
		DatagramSocket socket = new DatagramSocket( 4711 );
		while ( true ){
			// Auf Anfrage warten (DatagramPacket)
			DatagramPacket packet = new DatagramPacket( new byte[1024], 1024 );
			socket.receive( packet ); //tatsaechliches empfangen

			// Empfänger auslesen (brauchma nicht, td mal drin lassen weils nett is)

			InetAddress address = packet.getAddress();
			int         port    = packet.getPort();
			int         len     = packet.getLength();
			byte[]      data    = packet.getData();

			System.out.printf( "Anfrage von %s vom Port %d mit der Länge %d:%n%s%n",
				                         address, port, len, new String( data, 0, len ) );
		}
	}
}