package befehlsAuswertung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

public class CommandMapFactory {
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, Command> map = new ConcurrentHashMap<String, Command>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map.put("!bid", new Bid());
		map.put("!logout", new Logout());
		map.put("!create", new Create());
		map.put("!list", new List());
		map.put("!login", new Login());	
		
		try {
			while(!br.ready()){
				continue;
			}
			String s = br.readLine();
			Command c = (Command) map.get(sa[0]);
			if(c != null)
				c.execute(sa);
			else
			{
				System.out.println("Command not found!");
				System.exit(-1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
