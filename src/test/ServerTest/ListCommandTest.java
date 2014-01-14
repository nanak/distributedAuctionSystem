package test.ServerTest;

import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.*;

import Server.Auction;
import Server.CommandMapFactory;
import Server.ListCommand;
import Server.ManageConnection;
import Server.User;
import static org.junit.Assert.*;

/**
 * The class <code>ListCommandTest</code> contains tests for the class <code>{@link ListCommand}</code>.
 *
 * @generatedBy CodePro at 1/13/14 2:18 AM
 * @author mlipovits
 * @version $Revision: 1.0 $
 */
public class ListCommandTest {
	/**
	 * Run the ListCommand(ArrayList<Auction>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@Test
	public void testListCommand_1()
		throws Exception {
		ArrayList<Auction> auctionlist = new ArrayList<Auction>();

		ListCommand result = new ListCommand(auctionlist);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean execute(String,ManageConnection,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@Test
	public void testExecute_noAuctions()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		ListCommand fixture = new ListCommand(a);
		String cmd = "!list";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String,ManageConnection,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@Test
	public void testExecute_true()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		Auction auc= new Auction(0, 10000, user, null, 0.0, "muhkuhli");
		a.add(auc);
		ListCommand fixture = new ListCommand(a);
		String cmd = "!list";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *ArrayList<Auction> auctionlist = new ArrayList<Auction>();
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ListCommandTest.class);
	}
}