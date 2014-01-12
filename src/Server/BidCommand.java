package Server;

import java.util.ArrayList;

/**
 * The bid command implementation
 * @author Tobi
 *
 */
public class BidCommand implements Command {
	private ArrayList<Auction> auctionlist;
	
	public BidCommand(ArrayList<Auction> auctionlist){
		this.auctionlist=auctionlist;
	}
	/**
	 * executes the command
	 * @param cmd command to execute
	 */
	@Override
	public boolean execute(String cmd) {
		//!bid <auction-id> <amount>
		String[] s =  cmd.split("\\s+");
		String out="";
		boolean ret;
		int aid =Integer.parseInt(s[1]);
		double amount=Double.parseDouble(s[1]);
		User bidder=null; //KA WOHER ICH DEN KRIEG
		Auction a=auctionlist.get(aid);
		if(a.getHighestbid()<amount){
			a.setHighestbid(amount);
			a.setHighestbidder(bidder); // KA WIE ICH DEN DEN BEFEHL EINGEBENDEN USER KENNEN SOLL
			out="You successfully bid with "+amount+" on '"+a.getDescription()+"'.";
			ret=true;
		}
		else{
			out="You unsuccessfully bid with "+amount+" on '"+a.getDescription()+"'. Current highest bid is "+a.getHighestbid()+".";
			ret=false;
		}
		return ret;
	}
 
}
 
