package Server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//still needs changes.

/**
 * Manages the auctions and everything who needs to needs to be stored
 * @author Tobi
 *
 */
public class DataManager {

	private ArrayList<Auction> auctionlist;
	FileOutputStream saveFile;
	FileInputStream loadFile;


	public DataManager(ArrayList<Auction> list) {
		try {
			saveFile = new FileOutputStream("store");
			loadFile = new FileInputStream("store");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.auctionlist=list;
		String text = 	""; 
	}
	/**
	 * Save the auctions in file
	 */
	public void saveData() {
		try {
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(auctionlist);
			save.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}

	}

	/**
	 * Load the auctions back in the array
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadData() throws FileNotFoundException {
		try {
			ObjectInputStream load=new ObjectInputStream(loadFile);
			Object obj = load.readObject();
			auctionlist=(ArrayList<Auction>)obj;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * add an auction to the array
	 * @param auction auction to add
	 * @return true auction was added
	 */
	public boolean addAuction(Auction auction) {
		auctionlist.add(auctionlist.size(), auction);
		return false;
	}
	/**
	 * bid to an auction
	 * @param id auction to bid on
	 * @param bet	amount to bed on the auction
	 * @return	true if bid was correct -> highest bidder
	 */
	public boolean bidAuction(String id, double bet) {
		return false;
	}

}

