package Server;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	private Calendar cal;

	private SimpleDateFormat sdf;

	private String end;
	
	private Date date;
	
	//HIER FEHLT ENDDATUM (bei list muss enddatum azeigt werden
	

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
		// calculate enddate
		cal = Calendar.getInstance();
		sdf = new SimpleDateFormat("dd.MM.YYYY HH:mm");
		cal.add(Calendar.SECOND, (int) duration);
		this.end = sdf.format(cal.getTime());
		// TODO Zeitzone hier fehlt
		this.date = new Date();
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Returns the auction in the correct output
	 */
	public String toString() {
		return null;
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
	/**
	 * This method returns the enddate of the auction in the format dd.MM.YYYY HH:mm
	 * 
	 * @return enddate as String
	 */
	public String getEnd() {
		return end;
	}
}
 
