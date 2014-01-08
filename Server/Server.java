package Server;

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
	 
	private ArrayList userlist;
	 
	private WatchDog watchDog;
	 
	private DataManager data;
	 
	private Auction[] auction;
	 
	private Server server;
	 
	private ManageConnection[] manageConnection;
	 
	private User[] user;
	 
	/**
	 * Constructor of the auction system server
	 * @param tcp TCP Port
	 */
	public void Server(int tcp) {
	 
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
	 
	}
	/**
	 * Exits the server program
	 */
	public void end() {
	 
	}
	 
}
 
