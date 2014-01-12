package Server;

import java.util.ArrayList;

/**
 * The list command implementation
 * @author Michaela Lipovits
 *
 */
public class ListCommand implements Command {
	private ArrayList<Auction> auctionlist;
	public ListCommand(ArrayList<Auction> auctionlist){
		this.auctionlist=auctionlist;
	}
	/**
	 * executes the command
	 * @param cmd command to execute
	 */
	@Override
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		String out="";
		Auction a;
		if(!auctionlist.isEmpty()){
			for(int i=0; i<auctionlist.size(); i++){
				a=auctionlist.get(i);
				String highestBidder="";
				if(a.getHighestbidder()==null){
					highestBidder="None"; 
				}
				else{ 
					highestBidder=a.getHighestbidder().getName(); 
				}
				out=out+i+". '"+a.getDescription()+"' "+a.getOwner().getName()+" "+a.getEnd()+" "+a.getHighestbid()+" "+highestBidder+"\n";
			}
			con.send(out);
			return true;
		}
		else{
			con.send("No auctions available.");
			return false;
		}
	}
}
 
