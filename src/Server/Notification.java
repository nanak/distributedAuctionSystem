package Server;
/**
 * This class handles the Notifications
 * @author tobi,nanak
 *
 */
public class Notification {
 
	private String data;
	 
	public Notification(String data){
		this.data=data;
	}
	/**
	 * Returns the notification as a String
	 * @return the notification
	 */
	@Override
	public String toString() {
		return this.data;
	}
	 
}
 
