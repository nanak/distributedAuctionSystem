package Server;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private int tcpport;

	private ExecutorService pool;

	private ArrayList userlist;

	private ArrayList auctionlist;

	private WatchDog watchDog;

	private Auction[] auction;

	private ManageConnection[] manageConnection;

	private User[] user;

	public static void main (String [] args){
		new Server(1234);
	}


	public Server(int tcp) {
		this.tcpport=tcp;
		pool = Executors.newFixedThreadPool(10);
		startServer(tcp);
	}

	public boolean receive(String command) {
		return false;
	}

	public void startServer(final int port) {
		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				try {
					ServerSocket serverSocket = new ServerSocket(port);
					System.out.println("Waiting for clients to connect...");
							while (true) {
								Socket clientSocket = serverSocket.accept();
								pool.submit(new ManageConnection(clientSocket));
							}
				} catch (IOException e) {
					System.err.println("Unable to process client request");
					e.printStackTrace();
				}
			}
		};
		Thread serverThread = new Thread(serverTask);
		serverThread.start();
	}

	public void saveData() {

	}

	public void loadData() {

	}

	public void shutdown() {

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

