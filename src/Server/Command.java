package Server;

/**
 * Interface for the commands
 * @author Tobi
 *
 */
public interface Command {
	/**
	 * executes a command
	 * 
	 * @param cmd usercommand
	 * @param con ManagedConnection to send Messages to the user
	 * @param name usernae
	 * @param ip ip address of user
	 * @return true if successful
	 */
	public abstract boolean execute(String cmd,ManageConnection con, String name, String ip);
}
 
