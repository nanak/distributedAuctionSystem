package Server;

import java.io.IOException;
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

//	private Runnable tcp;
	private TCPServer tcp;

	private CommandMapFactory commands;
	

	private Thread serverthread;
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
//		Thread serverthread=new Thread(tcp);
		serverthread = new Thread(tcp);
		serverthread.start();
		watchDog=new WatchDog(auction, user);
		new Thread(watchDog).start();
		Runnable check=new Runnable() {
			@Override
			public void run() {
				try {
					System.out.print("Press any key to exit");
					System.in.read();
					System.out.println("Server is saving data and shutting down");
					data.saveData();
//					TCPServer tcpS = (TCPServer)tcp;
//					tcpS.setHasToRun(false);
					tcp.setHasToRun(false);
//					tcp.isHasToRun();
					watchDog.setHasToRun(false);
					
					shutdown();
//					System.gc();
					//System.exit(1);
				} catch (IOException e) {
				}

			}
			
		};
		Thread t=new Thread(check);
		t.start();
		
//		serverthread.stop();
	}

	/**
	 * Stops the listening and shuts down the server safely
	 */
	public void shutdown() {
//		serverthread.stop();
	}
}

