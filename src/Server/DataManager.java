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

	/**
	 * can save and load the auctions from a file
	 * @param list auctions to be saved and loaded
	 */
	public DataManager(ArrayList<Auction> list) {
		try {
			saveFile = new FileOutputStream("store");
			loadFile = new FileInputStream("store");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.auctionlist=list;
	}

	/**
	 * Save the auctions in file
	 */
	public void saveData() {
		try {
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			//System.out.println(save.);
			save.writeObject(auctionlist);
			save.close();
		} catch ( IOException e ) {
			System.out.println("Could not be saved");
		}

	}

	/**
	 * Load the auctions back in the array
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadData(){
		try {
			ObjectInputStream load=new ObjectInputStream(loadFile);
			Object obj = load.readObject();
			auctionlist=(ArrayList<Auction>)obj;
		} catch (IOException | ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("File not found");
			auctionlist=new ArrayList<Auction>();
		}
	}
}



