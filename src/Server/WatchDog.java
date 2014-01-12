package Server;

import java.util.ArrayList;
import java.util.Date;

/**
 * WatchDog to clean resources and set user online also watch if auction ends
 * 
 * @author Tobi, Nanak
 * 
 */
public class WatchDog {
	private ArrayList<Auction> auction;
	private ArrayList<User> user;
	private Date currentDate;

	WatchDog(ArrayList<Auction> auction, ArrayList<User> user) {
		this.auction = auction;
		this.user = user;
	}

	/**
	 * Logs out a user, if he's been inactive for five minutes.
	 */
	public void checkUserActivity() {
		for (int i = 0; i < user.size(); i++) {
			currentDate = new Date();
			long diff = currentDate.getTime()
					- user.get(i).getLastSeen().getTime();
			long diffMinutes = diff / (60 * 1000);
			if (diffMinutes > 5) {
				user.get(i).setOnline(false);
			}
		}
	}

	/**
	 * Checks if an Auction has reached its end date.
	 * 
	 * @return true if auction has ended, false if auction has not ended
	 */
	public boolean checkAuctionStatus() {
		for (int i = 0; i < auction.size(); i++) {
			currentDate = new Date();
			if (auction.get(i).getDate().getTime() >= currentDate.getTime()) {
				return true;
			}
		}
		return false;
	}

}
