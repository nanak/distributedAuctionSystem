package Server;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.util.ArrayList;
//still needs changes.
import java.util.Date;

/**
 * Manages the auctions and everything who needs to needs to be stored
 * 
 * @author Daniel,Tobi
 * 
 */
public class DataManager {

	private ArrayList<Auction> auctionlist;
	FileOutputStream saveFile;
	FileInputStream loadFile;

	/**
	 * can save and load the auctions from a file
	 * 
	 * @param list
	 *            auctions to be saved and loaded
	 */
	public DataManager(ArrayList<Auction> list) {
		try {
			saveFile = new FileOutputStream("store");
			loadFile = new FileInputStream("store");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.auctionlist = list;
	}

	/**
	 * Save the auctions in file
	 */
	public void saveData() {
		try {
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			// System.out.println(save.);s
			save.writeObject(auctionlist);
			//save.writeInt(auctionlist.size());
			save.flush();
			save.close();
		} catch (IOException e) {
			System.out.println("Could not be saved");
		}

	}

	/**
	 * Load the auctions back in the array
	 * 
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadData(){
		try {
			while(loadFile.available()>0){// only creates the Stream when the File is filled with Data
			ObjectInputStream load = new ObjectInputStream(loadFile);
			Object obj = load.readObject();
			auctionlist = (ArrayList<Auction>) obj;
			load.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();

			System.out.println("File not found");
			auctionlist = new ArrayList<Auction>();
		}
	}
}
