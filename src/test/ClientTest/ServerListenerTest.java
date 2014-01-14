package test.ClientTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.*;

import Client.TCPConnection;
import Server.Auction;
import Server.BidCommand;
import Server.CommandMapFactory;
import Server.ManageConnection;
import Server.User;
import static org.junit.Assert.*;

/**
 * The class <code>BidCommandTest</code> contains tests for the class <code>{@link BidCommand}</code>.
 *
 * @author Tobias Lins
 * @version 1.0 
 */
public class ServerListenerTest {
	/**
	 * Run the BidCommand(ArrayList<Auction>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testBidCommand_1()
		throws Exception {
		ArrayList<Auction> auctionlist = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		BidCommand result = new BidCommand(auctionlist, u);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Trying to send something to generated UDP socket
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_cmd1word() throws Exception {
		Client.ServerListener listener=new Client.ServerListener(1234);
		Thread t=new Thread(listener);
		t.start();
		try{
			DatagramSocket toSocket = new DatagramSocket();
			InetAddress ia;
			ia = InetAddress.getByName("127.0.0.1");
			String s = "test string";
			byte[] data = s.getBytes();
			//Zum senden und empfangen wird DatagramPacket verwendet
			DatagramPacket packet = new DatagramPacket( data, data.length, ia, 1234 );
			//@SuppressWarnings("resource")
			//dieses packet wird ueber das DatagramSocket versendet
			toSocket.send( packet ); //tatsaechliches senden
			assertTrue(true);
		}catch (Exception e){
			assertFalse(true);
			//e.printStackTrace();
			
		}
		//assertFalse(result);
	}	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ServerListenerTest.class);
	}
}