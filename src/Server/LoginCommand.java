package Server;

import java.util.ArrayList;

/**
 * The login command implementation
 * @author Michaela Lipovits
 *
 */
public class LoginCommand implements Command {
	ArrayList<User> user;
	public LoginCommand(ArrayList<User> user){
		this.user=user;
	}
	/**
	 * executes the command
	 * @param cmd command to execute
	 */
	@Override
	public boolean execute(String cmd) {
		System.out.println("logincommand");
		String[] s =  cmd.split("\\s+");
		String username=s[1];
		boolean exists=false;
		User login=null;
		String out="";
		boolean ret;
		for(int i=0; i<user.size(); i++){
			if(user.get(i).getName().equals(username)){
				exists=true;
				login=user.get(i);
				break;
			}
		}
		if(exists==true){
			if(login.getOnline()==false){
				login.setOnline(true);
				out="Successfully logged in as "+username+"!";
				ret=true;
			}
			else{
				out=""+username+" is already logged in!";
				ret= false;
			}
		}
		else{
			//wie krieg ich notoficationlist, in welchem format ist last seen zu speichern und woher krieg ich hier die ip?
			//login = new User(username, true, notifications, lastSeen, ip)
			out="Successfully logged in as "+username+"!";
			ret=true;
		}
		return ret;
	}
 
}
 
