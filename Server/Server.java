package Server;

import java.util.ArrayList;

public class Server extends User {
 
	private int tcpport;
	 
	private ExecutorService pool;
	 
	private ArrayList userlist;
	 
	private WatchDog watchDog;
	 
	private DataManager data;
	 
	private Auction[] auction;
	 
	private Server server;
	 
	private ManageConnection[] manageConnection;
	 
	private User[] user;
	 
	private WatchDog watchDog;
	 
	public void Server(int tcp) {
	 
	}
	 
	public boolean receive(String command) {
		return false;
	}
	 
	public void shutdown() {
	 
	}
	 
	public void accept() {
	 
	}
	 
	public void printAction() {
	 
	}
	 
	public void end() {
	 
	}
	 
}
 
