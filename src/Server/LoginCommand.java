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
	public boolean execute(String cmd, ManageConnection con, String name, String ip) {
		//!login <username>
		String[] s=null;
		try{
			s=cmd.split("\\s+");
		}catch (ArrayIndexOutOfBoundsException e){
			con.send("Login not possible. Wrong number of arguments. Syntax: !login username");
			return false;
		}
		if(s.length!=2){
			con.send("Login not possible. Wrong number of arguments. "+s.length+" given but 2 expected. Syntax: !login username");
			return false;
		}
		boolean exists=false;
		User login=null;
		String loggername=s[1];
		if(!userlist.isEmpty()){
			for(int i=0; i<userlist.size(); i++){
				if(userlist.get(i).getName().equals(loggername)){
					System.out.println("logged in");
					login=userlist.get(i);
					exists=true;
					break;
				}
			}
		}
		if(exists==true){
			if(login.getOnline()==false){
				login.setOnline(true);
				con.send("Successfully logged in as "+loggername+"!");
				return true;
			}
			else{
				con.send(""+loggername+" is already logged in!");
				return false;
			}
		}
		else{
			login = new User(loggername, true, new Date(), ip);
			userlist.add(login);
			con.send("Successfully logged in as "+loggername+"!");
			return true;
		}
	}
}
 
