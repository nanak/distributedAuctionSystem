package Server;

import java.util.ArrayList;

/**
 * The bid command implementation
 * @author Michaela Lipovits
 *
 */
public class BidCommand implements Command {
	private ArrayList<Auction> auctionlist;
	ArrayList<User> userlist;
	
	public BidCommand(ArrayList<Auction> auctionlist, ArrayList<User> userlist){
		this.auctionlist=auctionlist;
		this.userlist=userlist;
	}
	/**
	 * executes the command
	 * @param cmd command to execute
	 */
	@Override
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		//!bid <auction-id> <amount>
		if(auctionlist.isEmpty()==true){
			con.send("No auctions to bid on");
			return false;
		}
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			con.send("Bid not possible. Only 1 argument given");
			return false;
		}
		if(s.length<3){
			con.send("Create not possible. 3 or more expected but "+s.length+" given.");
			return false;
		}
		int aid=0;
		double amount=0.0;
		try{
			aid=Integer.parseInt(s[1]);
		 }catch(NumberFormatException e){
			 con.send("Bid not possible. The id "+s[1]+" is not a number");
			 return false;
		}
		try{
			amount=Double.parseDouble(s[2]);
		 }catch(NumberFormatException e){
			 con.send("Bid not possible. The amount "+s[2]+" is not a number");
			 return false;
		}
		User bidder=null;
		for(int i=0; i<userlist.size(); i++){
			if(userlist.get(i).getName().equals(name)){
				bidder=userlist.get(i);
				break;
			}
		}
		Auction a=null;
		try{
			a=auctionlist.get(aid);
		}catch (IndexOutOfBoundsException e){
			con.send("Bid not possible. No auction found with id "+a.getId());
			return false;
		}	
		if(a.getHighestbid()<amount){
			a.setHighestbid(amount);
			a.setHighestbidder(bidder);
			con.send("You successfully bid with "+amount+" on '"+a.getDescription()+"'.");
			return true;
		}
		else{
			con.send("You unsuccessfully bid with "+amount+" on '"+a.getDescription()+"'. Current highest bid is "+a.getHighestbid()+".");
			return false;
		}
	}
 
}
 
