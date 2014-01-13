package Server;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
/**
 * Server class
 * @author nanak
 *
 */
public class Server{
	 
	private ExecutorService pool;
	 
	private WatchDog watchDog;
	 
	private DataManager data;
	 
	private ArrayList<Auction> auction;
	 
	private ArrayList<User> user;
	 
	private Runnable tcp;
	
	private CommandMapFactory commands;
	/**
	 * Constructor of the auction system server
	 * @param tcp TCP Port
	 */
	public Server(int tcpport) {
		
		
		data=new DataManager(auction);
		auction=new ArrayList<Auction>();
		data.loadData();
		user=new ArrayList<User>();
		commands=new CommandMapFactory(auction, user);
		this.tcp=new TCPServer(tcpport, commands);
		Thread serverthread=new Thread(tcp);
		serverthread.start();
		watchDog=new WatchDog(auction, user);
		new Thread(watchDog).start();
		Runnable check=new Runnable() {
			@Override
			public void run() {
				Scanner console = new Scanner(System.in);
				System.out.print("Press any key to exit");
				String guess = console.next();
				data.saveData();
				System.out.println("Server is saving data and shutting down");
				System.exit(1);
			}
		};
		Thread t=new Thread(check);
		t.start();
	}
	
	/**
	 * Stops the listening and shuts down the server safely
	 */
	public void shutdown() {
	 
	}
}
 
