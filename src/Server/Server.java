package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
/**
 * Server class
 * @author nanak
 *
 */
public class Server{
 
	private int tcpport;
	 
	private ExecutorService pool;
	 
	private WatchDog watchDog;
	 
	private DataManager data;
	 
	private ArrayList<Auction> auction;
	 
	private ArrayList<ManageConnection> manageConnection;
	 
	private ArrayList<User> user;
	 
	/**
	 * Constructor of the auction system server
	 * @param tcp TCP Port
	 */
	public Server(int tcp) {
		try {
			sendNotification(new User("Tobi",true,null,null,InetAddress.getLocalHost().toString()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendNotification(User u){
		if(u.getOnline()){
			for(int x=0;x<u.getNotifications().size();x++){
				
				u.getNotifications().get(x).toString();
			}
		}
		try{
			InetAddress ia;
			ia = InetAddress.getByName("localhost");
			String s = "Du hast bei der Auktion gewonnen. LOL";
			byte[] data = s.getBytes();
			//Zum senden und empfangen wird DatagramPacket verwendet
			DatagramPacket packet = new DatagramPacket( data, data.length, ia, 1234 );
			@SuppressWarnings("resource")
			//dieses packet wird ueber das DatagramSocket versendet
			DatagramSocket toSocket = new DatagramSocket();
			toSocket.send( packet ); //tatsaechliches senden
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Interprets the commands it gets
	 * @param command Command to interpret
	 * @return true if command is valid, false if command is invalid
	 */
	public boolean receive(String command) {
		return false;
	}
	/**
	 * Stops the listening and shuts down the server safely
	 */
	public void shutdown() {
	 
	}
	/**
	 * Accepts incoming connections
	 */
	public void accept() {
	 
	}
	/**
	 * Prints the current 
	 */
	public void printAction(String command) {
		System.out.println(command);
	}
	/**
	 * Exits the server program
	 */
	public void end() {
	 
	}
	 
}
 
