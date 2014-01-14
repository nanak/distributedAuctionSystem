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
	public void saveData() {
		try {
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			// System.out.println(save.);s
			save.writeObject(auctionlist);
			//save.writeInt(auctionlist.size());
			save.flush();
			save.close();
		} catch (IOException e) {
			e.printStackTrace();
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
			//System.out.println(loadFile.available());
			//while(loadFile.available()>0){// only creates the Stream when the File is filled with Data
			ObjectInputStream load = new ObjectInputStream(loadFile);
			Object obj = load.readObject();
			List auctionlistl = (List<Auction>) obj;
			System.out.println(auctionlistl.size());
			load.close();
			//			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();

			System.out.println("File not found");
			auctionlist = new ArrayList<Auction>();
		}
	}


	public static void saveData(ArrayList YourObject, String filePath) throws IOException 
	{ 
		ObjectOutputStream outputStream = null; 
		try 
		{ 
			outputStream = new ObjectOutputStream(new FileOutputStream(filePath)); 
			outputStream.writeObject(YourObject); 
		} 
		catch(FileNotFoundException ex) 
		{ 
			ex.printStackTrace(); 
		} 
		catch(IOException ex) 
		{ 
			ex.printStackTrace(); 
		} 
		finally 
		{ 
			try 
			{ 
				if(outputStream != null) 
				{ 
					outputStream.flush(); 
					outputStream.close(); 
				} 
			} 
			catch(IOException ex) 
			{ 
				ex.printStackTrace(); 
			} 
		} 
	} 

	public static ArrayList loadData(String filePath) throws IOException, ClassNotFoundException 
	{ 
		try 
		{ 
			FileInputStream fileIn = new FileInputStream(filePath); 
			ObjectInputStream in = new ObjectInputStream(fileIn); 
			ArrayList l=(ArrayList) in.readObject();
			//System.out.println(((Auction)l.get(0)).getDescription());
			return l; 
		} 
		catch(FileNotFoundException ex) 
		{ 
			return new ArrayList<Auction>();
			//ex.printStackTrace(); 
		} 
		catch(IOException ex) 
		{ 
			return new ArrayList<Auction>();
			//ex.printStackTrace(); 
		}
	} 
}
