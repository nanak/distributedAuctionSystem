package datagramPrototype;

import java.net.*;

/**
 * Klasse Sever, der eine Benachrichtigung an den Client schicket
 * 
 * @author mlipovits
 * @version 2013-12-09
 */
public class Server {
	public static void main(String[] args) throws Exception {
		InetAddress ia;
		ia = InetAddress.getByName("localhost");
		int port = 4711;
		String s = "Server schickt benachrichtigung an Client";
		byte[] data = s.getBytes();
		//Zum senden und empfangen wird DatagramPacket verwendet
		DatagramPacket packet = new DatagramPacket( data, data.length, ia, port );
		@SuppressWarnings("resource")
		//dieses packet wird ueber das DatagramSocket versendet
		DatagramSocket toSocket = new DatagramSocket();
		toSocket.send( packet ); //tatsaechliches senden
	  }
	}