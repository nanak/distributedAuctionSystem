package Server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//still needs changes.

/**
 * Manages the auctions and everything who needs to needs to be stored
 * @author Daniel,Tobi
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
	public boolean bidAuction(int id, double bet) {
	for(int i = 0; i<auctionlist.size();i++){
			if(auctionlist.get(i).getId()==id && auctionlist.get(i).getHighestbid()==bet ){
				Auction a = new Auction(id, auctionlist.get(i).getDuration(), auctionlist.get(i).getOwner(), auctionlist.get(i).getHighestbidder(), bet, auctionlist.get(i).getDescription());
				auctionlist.remove(i);
				auctionlist.add(i, a);
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

}

