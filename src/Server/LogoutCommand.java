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
	public boolean execute(String cmd, ManageConnection con) {
		String[] s=null;
		User logout;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			//No message to user because 3 arguments are ensured by the server
			return false;
		}
		if(s.length==3){
			String loggername=s[1];
			if(!userlist.isEmpty()){
				for(int i=0; i<userlist.size(); i++){
					if(userlist.get(i).getName().equals(loggername)){
						logout=userlist.get(i);
						break;
					}
				}
			}
		}
		
		int param=s.length-2;
		con.send("Wrong number of arguments. 1 argument expected but "+param+" given.");
		// User u = ...
		// u.setOnline(false);
		//out="Successfully logged out as "+u.getName()+"!";	
		
		//WOHER WEISS ICH OB DER USER NOCH NICHT EINGELOGGT IST?
		
		
		return false;
		
	}
 

}
