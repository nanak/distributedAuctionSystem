package Server;

import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;

/**
 * User Model
 * @author Tobi
 *
 */
public class User implements Serializable{

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

	public void getNotifications() {
		for(int x=0;x<notifications.size();x++){
			this.sendNotification(notifications.get(x).toString());
			notifications.remove(x);
		}
	}

	public void addNotifications(Notification notification) {
		this.notifications.add(notification);
	}

	public Date getLastSeen() {
		return lastSeen;
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

	public void setLastSeen() {
		this.lastSeen=new Date();
	}

	public String getIP(){
		return this.ip;
	}
	
	
	public void sendNotification(String message){
		if(this.online){
			try{
				DatagramSocket toSocket = new DatagramSocket();
				InetAddress ia;
				ia = InetAddress.getByName(ip);
				String s = message;
				byte[] data = s.getBytes();
				//Zum senden und empfangen wird DatagramPacket verwendet
				DatagramPacket packet = new DatagramPacket( data, data.length, ia, 1234 );
				//@SuppressWarnings("resource")
				//dieses packet wird ueber das DatagramSocket versendet
				toSocket.send( packet ); //tatsaechliches senden
			}catch (Exception e){
				e.printStackTrace();
			}
		}else{
			this.addNotifications(new Notification(message));
		}
	}
}

