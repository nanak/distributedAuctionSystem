package Server;

import java.util.Date;
import java.util.ArrayList;

import Server.ManageConnection;
/**
 * The login command implementation, which includes the logic to login as a user.
 * @author Michaela Lipovits
 * @version 2014-01-13
 *
 */
public class LoginCommand implements Command {
	ArrayList<User> userlist;
	
	/**
	 * constructor which sets the actionlist and the userlist.
	 * 
	 * @param auctionlist AuctionList consisting of all active auctions
	 * @param userlist UserList consisting of all user that have ever logged in
	 */
	public LoginCommand(ArrayList<User> userlist){
		this.userlist=userlist;
	}
	/**
	 * executes the command to login as a user with a username.
	 * 
	 * @param cmd usercommand
	 * @param con ManagedConnection to send Messages to the user
	 * @param name usernae
	 * @param ip ip address of user
	 * @return true if successful
	 */
	@Override
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		//!login <username>
		//login only allowed for non-logged in users
		if(!name.equals("")){
		
			con.send("You are already loggen in as "+name+". Please log out before logging in with another user.\n"+name+"> ");
			return false;
		}
		//Split the command by space/s. Command has to consist of exactly 2 arguments otherwise it's invalid.
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			con.send("Login not possible. Wrong number of arguments. Syntax: !login username"+"\n> ");
			return false;
		}
		if(s.length!=2){
			con.send("Login not possible. Wrong number of arguments. "+s.length+" given but 2 expected. Syntax: !login username"+"\n> ");
			return false;
		}
		//check if a user with this username is already in the userlist
		boolean exists=false;
		User login=null;
		String loggername=s[1];
		if(!userlist.isEmpty()){
			for(int i=0; i<userlist.size(); i++){
				if(userlist.get(i).getName().equals(loggername)){
					login=userlist.get(i);
					exists=true;
					break;
				}
			}
		}
		if(exists==true){
			//if the user is already in the list and is not online yet, the login succeeds
			if(login.getOnline()==false){
				login.setOnline(true);
				login.getNotifications();
				con.send("Successfully logged in as "+loggername+"!"+"\n"+loggername+"> ");
				return true;
			}
			else{
				//login fails if the user is online already
				con.send(loggername+" is already logged in!"+"\n> ");
				return false;
			}
		}
		else{
			//if the  user is not in the list yet, create the user with the status online=true and save him in the userlist
			login = new User(loggername, true, new Date(), ip,1234);
			userlist.add(login);
			con.send("Successfully logged in as "+loggername+"!"+"\n"+loggername+"> ");
			return true;
		}
	}
}
 
