package Server;

import java.util.ArrayList;

/**
 * The bid command implementation. Includes the logic to bid on an auction.
 * @author Michaela Lipovits
 * @version 2014-01-13
 *
 */
public class BidCommand implements Command {
	private ArrayList<Auction> auctionlist;
	ArrayList<User> userlist;
	
	/**
	 * constructor which sets the actionlist and the userlist.
	 * 
	 * @param auctionlist AuctionList consisting of all active auctions
	 * @param userlist UserList consisting of all user that have ever logged in
	 */
	public BidCommand(ArrayList<Auction> auctionlist, ArrayList<User> userlist){
		this.auctionlist=auctionlist;
		this.userlist=userlist;
	}
	/**
	 * executes the command to bid on an auction
	 * 
	 * @param cmd usercommand
	 * @param con ManagedConnection to send Messages to the user
	 * @param name usernae
	 * @param ip ip address of user
	 * @return true if successful
	 */
	@Override
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		//!bid <auction-id> <amount>
		//Lists are not allowed to be empty
		if(auctionlist.isEmpty()==true){
			con.send("No auctions to bid on"+"\n"+name+"> ");
			return false;
		}
		if(userlist.isEmpty()==true){
			con.send("You have to login first!\n> ");
			return false;
		}
		//Split the command by space/s. Command has to consist of exactly 3 arguments otherwise it's invalid.
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			con.send("Bid not possible. Only 1 argument given. Syntax: !bid id amount"+"\n"+name+"> ");
			return false;
		}
		if(s.length!=3){
			con.send("Bid not possible. 3 arguments expected but "+s.length+" given. Syntax: !bid id amount"+"\n"+name+"> ");
			return false;
		}
		//id and amount have to be numbers
		int aid=0;
		double amount=0.0;
		try{
			aid=Integer.parseInt(s[1]);
		 }catch(NumberFormatException e){
			 con.send("Bid not possible. The id "+s[1]+" is not a number"+"\n"+name+"> ");
			 return false;
		}
		try{
			amount=Double.parseDouble(s[2]);
		 }catch(NumberFormatException e){
			 con.send("Bid not possible. The amount "+s[2]+" is not a number"+"\n"+name+"> ");
			 return false;
		}
		//find the bidder in the userlist by the username given as parameter
		User bidder=null;
		for(int i=0; i<userlist.size(); i++){
			if(userlist.get(i).getName().equals(name)){
				bidder=userlist.get(i);
				break;
			}
		}
		if(bidder==null){
			con.send("You have to log in first!\n> ");
			return false;
		}
		//try to find the auction with the id from the command
		Auction a=null;
		try{
			a=auctionlist.get(aid);
		}catch (IndexOutOfBoundsException e){
			con.send("Bid not possible. No auction found with id "+aid+"\n"+name+"> ");
			return false;
		}
		//owner should not be able to bid on his own auction
		if(bidder.getName().equals(a.getOwner().getName())){
			con.send("You cannot bid on your own auction!"+"\n"+name+"> ");
			return false;
		}
		//check if this new bid is higher then the highestBid saved in the auction object
		if(a.getHighestbid()<amount){
			//You have been overbid on 'Super small notebook'
			//Notify old highestBidder if there is one
			if(a.getHighestbidder()!=null){
				a.getHighestbidder().sendNotification("You have been overbid on '"+a.getDescription()+"'.\n"+a.getHighestbidder().getName()+"> ");
			}
			a.setHighestbid(amount);
			a.setHighestbidder(bidder);
			con.send("You successfully bid with "+amount+" on '"+a.getDescription()+"'."+"\n"+name+"> ");
			return true;
		}
		else{
			con.send("You unsuccessfully bid with "+amount+" on '"+a.getDescription()+"'. Current highest bid is "+a.getHighestbid()+"."+"\n"+name+"> ");
			return false;
		}
	}
 
}
 
