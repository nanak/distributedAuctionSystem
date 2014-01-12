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
<<<<<<< HEAD
	public boolean execute(String cmd) {
		//!bid <auction-id> <amount> username ip
=======
	public boolean execute(String cmd, ManageConnection con) {
		//!bid <auction-id> <amount>
>>>>>>> 2a691ec1d07f7517310b909df8dd82a52111ebe2
		if(auctionlist.isEmpty()==true) return false;
		String[] s=null;
		String out="";
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
		if(s.length<5) return false;
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
		String biddername=s[s.length-2];
		User bidder=null;
		for(int i=0; i<userlist.size(); i++){
			if(userlist.get(i).getName().equals(biddername)){
				bidder=userlist.get(i);
				break;
			}
		}
		Auction a=null;
		try{
			a=auctionlist.get(aid);
		}catch (IndexOutOfBoundsException e){
			out="Bid not possible. No auction found with id "+a.getId();
			return false;
		}	
		if(a.getHighestbid()<amount){
			a.setHighestbid(amount);
			a.setHighestbidder(bidder);
			out="You successfully bid with "+amount+" on '"+a.getDescription()+"'.";
			return true;
		}
		else{
			out="You unsuccessfully bid with "+amount+" on '"+a.getDescription()+"'. Current highest bid is "+a.getHighestbid()+".";
			return false;
		}
	}
 
}
 
