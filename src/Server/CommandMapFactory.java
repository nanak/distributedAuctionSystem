package Server;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Command map factory
 * Command pattern to add new commands
 * @author Tobi,Nanak
 *
 */
public class CommandMapFactory {
	private ConcurrentHashMap<String, Command> map;
	private  ArrayList<User> users;
	/**
	 * Constructor
	 * @param auctions auction list
	 * @param users user list
	 */
	public CommandMapFactory(ArrayList<Auction> auctions, ArrayList<User> users){
		this.users=users;
		map = new ConcurrentHashMap<String, Command>();	
		map.put("!bid", new BidCommand(auctions,users));
		map.put("!logout", new LogoutCommand(users));
		map.put("!create", new CreateCommand(auctions,users));
		map.put("!list", new ListCommand(auctions));
		map.put("!login", new LoginCommand(users));	
	}
	/**
	 * Runs a command on the server
	 * @param cmd the command as a string
	 * @param con the connection
	 * @param name the name of user
	 * @param ip the ip of user
	 */
	public void runCommand(String cmd , ManageConnection con, String name, String ip){
		//System.out.println(cmd);
		Command c = (Command) map.get(cmd.split(" ")[0]);
		try{
			for(int x=0;x<users.size();x++){
				if(users.get(x).getName().equals(name)){
					users.get(x).setLastSeen();
				}
			}
			c.execute(cmd, con,  name,  ip);
			
		}catch (Exception e){
			if(name.equals(""))
				con.send(cmd+" Command not found\n> ");
			else
				con.send(cmd+"Command not found\n"+name+"> ");		
		}

	}
}
