package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

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
		for (int i = 0; i < auction.size(); i++) {
						currentDate = new Date();
						if (auction.get(i).getDate().getTime()+auction.get(i).getDuration()*1000 <= currentDate.getTime()) {
							User owner=auction.get(i).getOwner();
							User winner=auction.get(i).getHighestbidder();
							String winnernoti;
							String ownernoti;
							if(winner==null){
								ownernoti="The auction '"+auction.get(i).getDescription()+"' ended without bids! :(\n"+owner.getName()+"> ";
								owner.sendNotification(ownernoti);
							}else{
								winnernoti="The auction '"+auction.get(i).getDescription()+"' has ended. You won with "+
										auction.get(i).getHighestbid()+"!\n"+winner.getName()+"> ";
								ownernoti="The auction '"+auction.get(i).getDescription()+"' has ended. "+winner.getName()+
										" won with "+auction.get(i).getHighestbid()+".\n"+owner.getName()+"> ";
								owner.sendNotification(ownernoti);
								winner.sendNotification(winnernoti);
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
