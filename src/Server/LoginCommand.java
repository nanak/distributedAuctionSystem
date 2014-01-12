package Server;

import java.util.ArrayList;
import Server.ManageConnection;
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
	public boolean execute(String cmd, ManageConnection con) {
		String[] s =  cmd.split("\\s+");
		String username=s[1];
		System.out.println(username);
		boolean exists=false;
		User login=null;
		String out="";
		for(int i=0; i<user.size()-2; i++){
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
				return true;
			}
			else{
				out=""+username+" is already logged in!";
				return false;
			}
		}
		else{
			//in welchem format ist last seen zu speichern und woher krieg ich hier die ip?
			//login = new User(username, true, new Date(), ip)
			out="Successfully logged in as "+username+"!";
			return true;
		}

	}
 
}
 
