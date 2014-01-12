package Server;

import java.util.ArrayList;

/**
 * The bid command implementation
 * @author Michaela Lipovits
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
		if(auctionlist.isEmpty()==true) return false;
		String[] s=null;
		String out="";
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
		if(s.length<3) return false;
		int aid=0;
		double amount=0.0;
		try{
			aid=Integer.parseInt(s[1]);
		 }catch(NumberFormatException e){
			 out="Bid not possible. The id "+s[1]+" is not a number";
			 return false;
		}
		try{
			amount=Double.parseDouble(s[2]);
		 }catch(NumberFormatException e){
			 out="Bid not possible. The amount "+s[2]+" is not a number";
			 return false;
		}
		User bidder=null; //KA WOHER ICH DEN KRIEG
		Auction a=null;
		try{
			a=auctionlist.get(aid);
		}catch (IndexOutOfBoundsException e){
			out="Bid not possible. No auction found with id "+a.getId();
			return false;
		}	
		if(a.getHighestbid()<amount){
			a.setHighestbid(amount);
			a.setHighestbidder(bidder); // KA WIE ICH DEN DEN BEFEHL EINGEBENDEN USER KENNEN SOLL
			out="You successfully bid with "+amount+" on '"+a.getDescription()+"'.";
			return true;
		}
		else{
			out="You unsuccessfully bid with "+amount+" on '"+a.getDescription()+"'. Current highest bid is "+a.getHighestbid()+".";
			return false;
		}
	}
 
}
 
