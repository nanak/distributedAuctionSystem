package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;

/**
 * WatchDog to clean resources and set user online also watch if auction ends
 * 
 * @author Tobi, Nanak
 * 
 */
public class WatchDog implements Runnable {
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
		String end;
		for (int i = 0; i < auction.size(); i++) {
			currentDate = new Date();
			if (auction.get(i).getDate().getTime()+auction.get(i).getDuration()*1000 <= currentDate.getTime()) {
				if(auction.get(i).getHighestbidder()==null){
					auction.get(i).getOwner().sendNotification("!auction-ended without bids for "+auction.get(i).getDescription());
				}else{
					auction.get(i).getOwner().sendNotification("The auction '"+auction.get(i).getDescription()+"' has ended. "+auction.get(i).getHighestbidder().getName()+" won with "+auction.get(i).getHighestbid()+".");
					auction.get(i).getHighestbidder().sendNotification("The auction '"+auction.get(i).getDescription()+"' has ended. You won with "+auction.get(i).getHighestbid()+"!");
				}
				auction.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void run() {
		while(true){
			checkUserActivity();
			checkAuctionStatus();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
