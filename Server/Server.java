package Server;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class Server extends User {
 
	private int tcpport;
	 
	private ExecutorService pool;
	 
	private ArrayList userlist;
	 
	private ArrayList auctionlist;
	 
	private WatchDog watchDog;
	 
	private Auction[] auction;
	 
	private Server server;
	 
	private ManageConnection[] manageConnection;
	 
	private User[] user;
	 
	public void Server(int tcp) {
	 
	}
	 
	public boolean receive(String command) {
		return false;
	}
	 
	public void saveData() {
	 
	}
	 
	public void loadData() {
	 
	}
	 
	public void shutdown() {
	 
	}
	 
	public void accept() {
	 
	}
	 
	public void printAction() {
	 
	}
	 
	public void bid(String data) {
	 
	}
	 
	public void create(String data) {
	 
	}
	 
	public void login(String data) {
	 
	}
	 
	public void logout(String data) {
	 
	}
	 
	public void end() {
	 
	}
	 
}
 
