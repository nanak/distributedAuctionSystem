package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//still needs changes.
public class DataManager {
 
	private ArrayList auctionlist;
	 
	public void DataManager() {
		String text = 	""; 
		 //try{
			    //BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			   // String s = bufferRead.readLine();
			   // text = ""+s;
		 
			//}
			//catch(IOException e)
			//{
			//	e.printStackTrace();
			//}
		 
	}
	 
	public void saveData() {
	       try {
		          File file = new File("example.txt");
		          BufferedWriter output = new BufferedWriter(new FileWriter(file));
		          output.write(auctionlist.toString());
		          output.close();
		        } catch ( IOException e ) {
		           e.printStackTrace();
		        }
	 
	}
	 
	public void loadData() throws FileNotFoundException {
		   File file = new File("example.txt"); 
	       char[] chars = new char[(int) file.length()];
	       
	      
	   
	   
	
	 String text = 	""; 
	 String b2= "";
	 FileReader a = new FileReader(file);
	 
	 
	}
	 
	public boolean addAuction(Auction auction) {
		auctionlist.add(auctionlist.size(), auction);
		return false;
	}
	 
	public boolean bidAuction(String id, double bet) {
		return false;
	}
	 
}
 
