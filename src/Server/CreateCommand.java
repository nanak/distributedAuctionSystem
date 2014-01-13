package Server;

import java.util.ArrayList;
/**
 * The create command implementation, which includes the logic to create an auction.
 * 
 * @author Michaela Lipovits
 * @version 2014-01-13
 *
 */
public class CreateCommand implements Command {
	private ArrayList<Auction> auctionlist;
	ArrayList<User> userlist;
	
	/**
	 * constructor which sets the actionlist and the userlist.
	 * 
	 * @param auctionlist AuctionList consisting of all active auctions
	 * @param userlist UserList consisting of all user that have ever logged in
	 */
	public CreateCommand(ArrayList<Auction> auctionlist, ArrayList<User> userlist){
		this.auctionlist=auctionlist;
		this.userlist=userlist;
	}
	/**
	 * executes the command to create an auction
	 * 
	 * @param cmd usercommand
	 * @param con ManagedConnection to send Messages to the user
	 * @param name usernae
	 * @param ip ip address of user
	 * @return true if successful
	 */
	@Override	
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		//!create 25200 Super small notebook
		//userlist are not allowed to be empty
		if(userlist.isEmpty()==true){
			con.send("You have to login first!\n> ");
			return false;
		}
		//Split the command by space/s. Command has to consist of at least 3 arguments otherwise it's invalid.
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			con.send("Create not possible. Only 1 argument given. Syntax: !create duration description"+"\n"+name+"> ");
			return false;
		}
		if(s.length<3){
			con.send("Create not possible. 3 or more expected but "+s.length+" given.  Syntax: !create duration description"+"\n"+name+"> ");
			return false;
		}
		//duration has to be a number
		int duration=0;
		try{
			duration=Integer.parseInt(s[1]);
		 }catch(NumberFormatException e){
			 con.send("Create not possible. The duration "+s[1]+" is not a number"+"\n"+name+"> ");
			 return false;
		}
		int id=auctionlist.size();
		User owner=null;
		for(int i=0; i<userlist.size(); i++){
			if(userlist.get(i).getName().equals(name)){
				owner=userlist.get(i);
				break;
			}
		}
		//description starts after the duration and can consist of multiple words
		String descr="";
		for (int i=2; i<s.length; i++){
			descr=descr+s[i]+" ";
		}	
		//create the auction and write it into the auctionlist
		Auction a = new Auction(id, duration, owner, null, 0.0, descr);
		auctionlist.add(a);
		con.send("An auction '"+a.getDescription()+"' with id "+a.getId()+" hase been created and will end on "+a.getEnd()+"."+"\n"+name+"> ");
		return true;
		
	}
 
}
 
