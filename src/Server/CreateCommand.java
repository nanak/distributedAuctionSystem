package Server;

import java.text.NumberFormat;
import java.util.ArrayList;

import Server.DataManager;
/**
 * The create command implementation
 * @author Michaela Lipovits
 *
 */
public class CreateCommand implements Command {
	private ArrayList<Auction> auctionlist;
	
	public CreateCommand(ArrayList<Auction> auctionlist){
		this.auctionlist=auctionlist;
	}
	/**
	 * executes the command
	 * @param cmd command to execute
	 */
	@Override
	public boolean execute(String cmd) {
		//!create 25200 Super small notebook
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
		if(s.length<3) return false;
		int duration=0;
		try{
			duration=Integer.parseInt(s[1]);
		 }catch(NumberFormatException e){
			 return false;
		}
		int id=auctionlist.size();
		User owner=null; //KA WOHER ICH DEN KRIEG!!!!!!
		String descr="";
		for (int i=2; i<s.length; i++){
			descr=descr+s[i]+" ";
		}		
		Auction a = new Auction(id, duration, owner, null, 0.0, descr);
		//HIER NICHT DATAMANAGER ZUM ERSTELLEN VERWENDET 
		auctionlist.add(a);
		
		//An auction 'Super small notebook' with id 3 has been created and will end on 04.10.2012 18:00 CET.
		String out="An auction '"+a.getDescription()+"' with id "+a.getId()+" hase been created and will end on "+a.getEnd()+".";
		return true;
		
	}
 
}
 
