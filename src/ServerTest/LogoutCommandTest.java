package ServerTest;

import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.*;

import Server.Auction;
import Server.CommandMapFactory;
import Server.LogoutCommand;
import Server.ManageConnection;
import Server.User;
import static org.junit.Assert.*;

/**
 * The class <code>LogoutCommandTest</code> contains tests for the class <code>{@link LogoutCommand}</code>.
 *
 * @generatedBy CodePro at 1/13/14 2:18 AM
 * @author mlipovits
 * @version $Revision: 1.0 $
 */
public class LogoutCommandTest {
	/**
	 * Run the LogoutCommand(ArrayList<User>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@Test
	public void testLogoutCommand_1()
		throws Exception {
		ArrayList<User> userlist = new ArrayList<User>();

		LogoutCommand result = new LogoutCommand(userlist);

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
	public void testExecute_true()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1");
		u.add(user);
		LogoutCommand fixture = new LogoutCommand(u);
		String cmd = "!logout";


		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		assertTrue(result);
	}

	/**
	 * Run the boolean execute(String,ManageConnection,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@Test
	public void testExecute_notLoggedIn()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", false, new Date(System.currentTimeMillis()), "1.1.1.1");
		u.add(user);
		LogoutCommand fixture = new LogoutCommand(u);
		String cmd = "!logout";


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
	public void testExecute_userlistEmpty()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1");
		u.add(user);
		LogoutCommand fixture = new LogoutCommand(new ArrayList<User>());
		String cmd = "!logout";


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
	public void testExecute_noSuchUser()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", false, new Date(System.currentTimeMillis()), "1.1.1.1");
		u.add(user);
		LogoutCommand fixture = new LogoutCommand(u);
		String cmd = "!logout";


		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "muhkuh", "1.1.1.1");

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
	public void testExecute_works()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1");
		u.add(user);
		LogoutCommand fixture = new LogoutCommand(u);
		String cmd = "!logout";


		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		assertEquals(false, u.get(0).getOnline());
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
	 *
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
		new org.junit.runner.JUnitCore().run(LogoutCommandTest.class);
	}
}