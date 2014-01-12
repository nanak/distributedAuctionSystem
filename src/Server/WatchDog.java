package Server;

import java.util.ArrayList;
import java.util.Date;

/**
 * WatchDog to clean resources and set user online
 * also watch if auction ends
 * @author Tobi, Nanak
 *
 */
public class WatchDog {
	private ArrayList<Auction> auctions;
	private ArrayList<User> user;
	private Date currentDate;
	
	WatchDog(ArrayList<Auction> auctions, ArrayList<User> user) {
		this.auctions = auctions;
		this.user = user;
	}
	
	public void checkUserActivity(){
		for(int i = 0; i < user.size(); i++){
			currentDate = new Date();
			long diff = currentDate.getTime() - user.get(i).getLastSeen().getTime();
			long diffMinutes = diff / (60 * 1000);
			if(diffMinutes > 5){
				user.get(i).setOnline(false);
			}
		}
	}
	 
}
