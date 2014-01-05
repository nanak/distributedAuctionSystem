package Server;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

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
 
