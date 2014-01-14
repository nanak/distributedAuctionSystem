package Server;

import java.util.ArrayList;

/**
 * The list command implementation, which includes the logic to list all active auctions
 * @author Michaela Lipovits
 * @version 2014-01-13
 *
 */
public class ListCommand implements Command {
	private ArrayList<Auction> auctionlist;
	
	/**
	 * constructor which sets the actionlist and the userlist.
	 * 
	 * @param auctionlist AuctionList consisting of all active auctions
	 * @param userlist UserList consisting of all user that have ever logged in
	 */
	public ListCommand(ArrayList<Auction> auctionlist){
		this.auctionlist=auctionlist;
	}
	/**
	 * executes the command to list all active auctions
	 * 
	 * @param cmd usercommand
	 * @param con ManagedConnection to send Messages to the user
	 * @param name usernae
	 * @param ip ip address of user
	 * @return true if successful
	 */
	@Override
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		String out="";
		Auction a;
		//if there are auctions, iterate through all auctions and save the data for the useroutput
		if(!auctionlist.isEmpty()){
			for(int i=0; i<auctionlist.size(); i++){
				a=auctionlist.get(i);
				String highestBidder="";
				//If no one has bid yet, the field where highestBidder should be listed shall say "None"
				if(a.getHighestbidder()==null){
					highestBidder="None"; 
				}
				else{ 
					highestBidder=a.getHighestbidder().getName(); 
				}
				out=out+i+". '"+a.getDescription()+"' "+a.getOwner().getName()+" "+a.getEnd()+" "+a.getHighestbid()+" "+highestBidder+"\n";
			}
			if(name.equals(""))
				con.send(out+"\n> ");
			else
				con.send(out+"\n"+name+"> ");
			return true;
		}
		else{
			//inform the user if there are no active auctions
			if(name.equals(""))
				con.send("No auctions available."+"\n> ");
			else
				con.send("No auctions available.\n"+name+"> ");			
			return false;
		}
	}
}
 
