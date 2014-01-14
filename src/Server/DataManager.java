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
	
	/**
	 * Saves all auctions in the file
	 * @param YourObject
	 * @param filePath
	 * @throws IOException
	 */
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
			//ex.printStackTrace(); 
		} 
		catch(IOException ex) 
		{ 
			//ex.printStackTrace(); 
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
				//ex.printStackTrace(); 
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
			//ex.printStackTrace(); 
			return new ArrayList<Auction>();
			//ex.printStackTrace(); 
		} 
		catch(IOException ex) 
		{ 
			//ex.printStackTrace(); 
			return new ArrayList<Auction>();
			//ex.printStackTrace(); 
		}
	} 
}
