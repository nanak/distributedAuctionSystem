package Server;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Model {

	private int tcpport;

	private ExecutorService pool;

	private ArrayList userlist;

	private ArrayList auctionlist;

	private WatchDog watchDog;

	private Auction[] auction;

	private ManageConnection[] manageConnection;

	private User[] user;

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

