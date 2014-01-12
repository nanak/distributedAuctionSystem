package Server;

import java.util.Date;
import java.util.ArrayList;

import Server.ManageConnection;
/**
 * The login command implementation
 * @author Michaela Lipovits
 *
 */
public class LoginCommand implements Command {
	ArrayList<User> userlist;
	public LoginCommand(ArrayList<User> userlist){
		this.userlist=userlist;
	}
	/**
	 * executes the command
	 * @param cmd command to execute
	 */
	@Override
	public boolean execute(String cmd, ManageConnection con) {
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			con.send("Login not possible. Only 1 argument given");
			return false;
		}		
		String username=s[1];
		boolean exists=false;
		String ip=s[s.length-1];
		User login=null;
		String loggername=s[1];
		if(!userlist.isEmpty()){
			for(int i=0; i<userlist.size(); i++){
				if(userlist.get(i).getName().equals(loggername)){
					login=userlist.get(i);
					break;
				}
			}
		}
		if(exists==true){
			if(login.getOnline()==false){
				login.setOnline(true);
				con.send("Successfully logged in as "+username+"!");
				return true;
			}
			else{
				con.send(""+username+" is already logged in!");
				return false;
			}
		}
		else{
			login = new User(username, true, new Date(), ip);
			con.send("Successfully logged in as "+username+"!");
			return true;
		}

	}
 
}
 
