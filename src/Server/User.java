package Server;

import java.util.ArrayList;
import java.util.Date;

/**
 * User Model
 * @author Tobi
 *
 */
public class User {
 
	private String name;
	 
	private boolean online;
	 
	private ArrayList<Notification> notifications;
	 
	private Date lastSeen;
	
	private String ip;
	/**
	 * User Model Constructor
	 * @param name username
	 * @param online true if online
	 * @param notifications notifications to send
	 * @param lastSeen last action
	 */
	public User(String name, boolean online, Date lastSeen, String ip){
		this.name=name;
		this.online=online;
		this.notifications=new ArrayList<Notification>();
		this.lastSeen=lastSeen;
		this.ip=ip;
	}
	
	public ArrayList<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(ArrayList<Notification> notifications) {
		this.notifications = notifications;
	}

	public Date getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	 
	public void setOnline(boolean on) {
		this.online=on;
	}
	 
	public boolean getOnline() {
		return this.online;
	}
	 
	public Date setLastSeen() {
		return this.lastSeen;
	}
	
	public String getIP(){
		return this.ip;
	}
}
 
