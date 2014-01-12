package Server;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class CommandMapFactory {
	private ConcurrentHashMap<String, Command> map;
	public CommandMapFactory(ArrayList<Auction> auctions, ArrayList<User> users){
		map = new ConcurrentHashMap<String, Command>();	
		map.put("!bid", new BidCommand(auctions));
		map.put("!logout", new LogoutCommand());
		map.put("!create", new CreateCommand(auctions));
		map.put("!list", new ListCommand(auctions));
		map.put("!login", new LoginCommand(users));	
	}
	public void runCommand(String cmd){
		System.out.println(cmd+"RUN");
		System.out.println(map.get(cmd.split(" ")[0]));
		Command c = (Command) map.get(cmd.split(" ")[0]);
		c.execute(cmd);
	}
}
