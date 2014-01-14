package Server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the auctions and everything who needs to needs to be stored
 * 
 * @author Daniel,Tobi
 * 
 */
public class DataManager implements Serializable{

	private static ArrayList<Auction> auctionlist;
	FileOutputStream saveFile;
	FileInputStream loadFile;

	/**
	 * can save and load the auctions from a file
	 * 
	 * @param list
	 *            auctions to be saved and loaded
	 */
	public DataManager(ArrayList<Auction> list) {
		this.auctionlist = list;
		try {
			saveFile = new FileOutputStream("store");
			loadFile = new FileInputStream("store");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Save the auctions in file
	 */
	public  void saveData(ArrayList YourObject, String filePath)
			throws IOException {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(
					new FileOutputStream(filePath));
			outputStream.writeObject(YourObject);
		} catch (FileNotFoundException ex) {
			System.err.println("File not Found");
			// ex.printStackTrace();
		} catch (IOException ex) {
			System.err.println("IOException");
			// ex.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				System.err.println("IOException");
				// ex.printStackTrace();
			}
		}
	}

	/**
	 * Load the auctions back in the array
	 * 
	 * @throws FileNotFoundException
	 */
	public ArrayList loadData(String filePath) throws IOException,
			ClassNotFoundException {
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList l = (ArrayList) in.readObject();
			// System.out.println(((Auction)l.get(0)).getDescription());
			return l;
		} catch (FileNotFoundException ex) {
			System.err.println("File not found");
			// ex.printStackTrace();
		} catch (IOException ex) {
			System.err.println("IOException");
			ex.printStackTrace();
		}
		return auctionlist;
	}
}
