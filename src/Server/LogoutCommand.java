package Server;

import java.util.ArrayList;
import java.util.Date;

/**
 * The logout command implementation
 * @author Michaela Lipovits
 *
 */
public class LogoutCommand implements Command{
	public LogoutCommand(){
		
	}
	@Override
	public boolean execute(String cmd, ManageConnection con) {
		String[] s =  cmd.split("\\s+");
		String out="";
		//ka woher ich das user objekt krieg bzw username
		// User u = ...
		// u.setOnline(false);
		// u.setLastSeen(new Date()):
		//out="Successfully logged out as "+u.getName()+"!";	
		
		//WOHER WEISS ICH OB DER USER NOCH NICHT EINGELOGGT IST?
		
		
		return false;
		
	}
 

}
