package Server;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class CommandMapFactory {
	private ConcurrentHashMap<String, Command> map;
	public CommandMapFactory(ArrayList<Auction> auctions, ArrayList<User> users){
		map = new ConcurrentHashMap<String, Command>();	
		map.put("!bid", new BidCommand(auctions,users));
		map.put("!logout", new LogoutCommand(users));
		map.put("!create", new CreateCommand(auctions,users));
		map.put("!list", new ListCommand(auctions));
		map.put("!login", new LoginCommand(users));	
	}
	public void runCommand(String cmd , ManageConnection con, String name, String ip){
		System.out.println(cmd);
		Command c = (Command) map.get(cmd.split(" ")[0]);
		try{
			c.execute(cmd, con,  name,  ip);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(cmd+ " Command not found"); //RETURN TO CLIENT!!
			// TODO fix crash when writing !logou
		}

	}
}
