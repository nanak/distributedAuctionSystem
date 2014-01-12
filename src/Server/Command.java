package Server;

/**
 * Interface of the commandos
 * @author Tobi
 *
 */
public interface Command {
	public abstract boolean execute(String cmd,ManageConnection con);
}
 
