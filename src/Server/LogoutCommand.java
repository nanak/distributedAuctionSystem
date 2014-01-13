package Server;

import java.util.ArrayList;

/**
 * The logout command implementation, which includes the logic to logout as a logged-in user.
 * @author Michaela Lipovits
 * @version 2014-01-13
 *
 */
public class LogoutCommand implements Command{
	ArrayList<User> userlist;
	
	/**
	 * constructor which sets the actionlist and the userlist.
	 * 
	 * @param auctionlist AuctionList consisting of all active auctions
	 * @param userlist UserList consisting of all user that have ever logged in
	 */
	public LogoutCommand(ArrayList<User> userlist){
		this.userlist=userlist;	
	}
	/**
	 * executes the logout command to logout as a logged-in user.
	 * 
	 * @param cmd usercommand
	 * @param con ManagedConnection to send Messages to the user
	 * @param name usernae
	 * @param ip ip address of user
	 * @return true if successful
	 */
	@Override
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		//!logout		
		User logout = null;
		String username="";
		//userlist are not allowed to be empty
		if(!userlist.isEmpty()){
			//Split the command by space/s. Command has to consist of exactly 2 arguments otherwise it's invalid.
			String[] s=null;
			try{
				s=cmd.split("\\s+");
				username=s[1];
			}catch (ArrayIndexOutOfBoundsException e){
				username=name;
			}
			//search for the user using the username of the luser who did/tried to login last
			for(int i=0; i<userlist.size(); i++){
				if(userlist.get(i).getName().equals(username)){
					logout=userlist.get(i);
					break;
				}
			}
			if(logout==null){
				//if there is no such user in the userlist
				con.send("You have to login first!"+"\n> ");
				return false;
			}
			
		}
		else{
			//if userlist is empty somehow
			con.send("You have to log in first!"+"\n> ");
			return false;
		}
		//if the user is in the userlist and is online, he gets logged out 
		if(logout.getOnline()==true){
			logout.setOnline(false);
			con.send("Successfully logged out as "+logout.getName()+"!"+"\n> ");	
			return true;
		}
		else{
			//logout fails if the user found in the list is set as offline
			con.send("You have to log in first!"+"\n> ");
			return false;
		}
		
	}
}
