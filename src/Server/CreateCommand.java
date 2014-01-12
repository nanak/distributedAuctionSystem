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
	ArrayList<User> userlist;
	
	public CreateCommand(ArrayList<Auction> auctionlist, ArrayList<User> userlist){
		this.auctionlist=auctionlist;
		this.userlist=userlist;
	}
	/**
	 * executes the command
	 * @param cmd command to execute
	 */
	@Override	
	public boolean execute(String cmd, ManageConnection con) {
		//!create 25200 Super small notebook username IP
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			con.send("Bid not possible. Only 1 argument given");
			return false;
		}
		int param=s.length-2;
		if(s.length<5){
			con.send("Create not possible. 3 or more expected but "+param+" given.");
			return false;
		}
		int duration=0;
		try{
			duration=Integer.parseInt(s[1]);
		 }catch(NumberFormatException e){
			 con.send("Create not possible. The duration "+s[1]+" is not a number");
			 return false;
		}
		int id=auctionlist.size();
		User owner=null;
		String ownername=s[s.length-2];
		for(int i=0; i<userlist.size(); i++){
			if(userlist.get(i).getName().equals(ownername)){
				owner=userlist.get(i);
				break;
			}
		}
		String descr="";
		for (int i=2; i<s.length-2; i++){
			descr=descr+s[i]+" ";
		}		
		Auction a = new Auction(id, duration, owner, null, 0.0, descr);
		//HIER NICHT DATAMANAGER ZUM ERSTELLEN VERWENDET 
		auctionlist.add(a);
		//An auction 'Super small notebook' with id 3 has been created and will end on 04.10.2012 18:00 CET.
		con.send("An auction '"+a.getDescription()+"' with id "+a.getId()+" hase been created and will end on "+a.getEnd()+".");
		return true;
		
	}
 
}
 
