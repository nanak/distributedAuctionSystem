package Server;

/**
 * Auction Model
 * @author Tobi
 *
 */
public class Auction {
 
	private int id;
	 
	private int duration;
	 
	private String description;
	 
	private double highestbid;
	 
	private User highestbidder;
	 
	private User owner;
	
	
	/**
	 * Returns the auction in the correct output
	 */
	public String toString() {
		return null;
	}
	/**
	 * Constructor
	 * @param id			UID of the Auction
	 * @param duration		How long the auction lasts
	 * @param owner			Owner of the auction
	 * @param highestbidder	highest bidder of the auction
	 * @param highestbid	highest bid
	 * @param description	Description of the auction
	 */
	public Auction(int id, int duration, User owner, User highestbidder, double highestbid, String description){
		this.id=id;
		this.duration=duration;
		this.description=description;
		this.highestbid=highestbid;
		this.setHighestbidder(highestbidder);
		this.owner=owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHighestbid() {
		return highestbid;
	}

	public void setHighestbid(double highestbid) {
		this.highestbid = highestbid;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getHighestbidder() {
		return highestbidder;
	}

	public void setHighestbidder(User highestbidder) {
		this.highestbidder = highestbidder;
	}
}
 
