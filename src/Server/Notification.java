package Server;
/**
 * This class handles the Notifications
 * @author tobi,nanak
 *
 */
public class Notification {
 
	private String name;
	 
	private String type;
	
	public Notification(String name, String type){
		this.name=name;
		this.type=type;
	}
	/**
	 * Returns the notification as a String
	 * @return the notification
	 */
	@Override
	public String toString() {
		return this.name+":"+this.type;
	}
	 
}
 
