package Server;

import java.util.ArrayList;
import java.util.Date;

/**
 * The logout command implementation
 * @author Michaela Lipovits
 *
 */
public class LogoutCommand implements Command{
	ArrayList<User> userlist;
	public LogoutCommand(ArrayList<User> userlist){
		this.userlist=userlist;	
	}
	@Override
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		//!logout		
		User logout = null;
		if(!userlist.isEmpty()){
			for(int i=0; i<userlist.size(); i++){
				if(userlist.get(i).getName().equals(name)){
					logout=userlist.get(i);
					break;
				}
			}
		}
		else{
			con.send("You have to log in first!");
			return false;
		}
		logout.setOnline(false);
		con.send("Successfully logged out as "+logout.getName()+"!");	
		return true;
		
	}
 

}
