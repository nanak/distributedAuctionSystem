package datagramPrototype;

import java.net.*;

public class Server {
	public static void main(String[] args) throws Exception {
		InetAddress ia;
		ia = InetAddress.getByName("localhost");
		int port = 4711;
		String s = "Server schickt benachrichtigung an Client";
		byte[] data = s.getBytes();
		//Zum senden und empfangen weird DatagramPacket verwendet
		DatagramPacket packet = new DatagramPacket( data, data.length, ia, port );
		@SuppressWarnings("resource")
		DatagramSocket toSocket = new DatagramSocket();
		toSocket.send( packet );
	  }
	}