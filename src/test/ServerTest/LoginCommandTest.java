package test.ServerTest;

import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.*;

import Server.Auction;
import Server.CommandMapFactory;
import Server.LoginCommand;
import Server.ManageConnection;
import Server.User;
import static org.junit.Assert.*;

/**
 * The class <code>LoginCommandTest</code> contains tests for the class <code>{@link LoginCommand}</code>.
 *
 * @generatedBy CodePro at 1/13/14 2:18 AM
 * @author mlipovits
 * @version $Revision: 1.0 $
 */
public class LoginCommandTest {
	/**
	 * Run the LoginCommand(ArrayList<User>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/13/14 2:18 AM
	 */
	@Test
	public void testLoginCommand_1()
		throws Exception {
		ArrayList<User> userlist = new ArrayList<User>();

		LoginCommand result = new LoginCommand(userlist);

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
	public void testExecute_isAlreadyOnline()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		
		LoginCommand fixture = new LoginCommand(u);
		String cmd = "!login mimi";


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
	public void testExecute_newUserTrue()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		
		LoginCommand fixture = new LoginCommand(u);
		String cmd = "!login muhkuh";


		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "", "1.1.1.1");

		// add additional test code here
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
	public void testExecute_oldUserTrue()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", false, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		
		LoginCommand fixture = new LoginCommand(u);
		String cmd = "!login mimi";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "", "1.1.1.1");

		// add additional test code here
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
	public void testExecute_noUsername()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", false, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		
		LoginCommand fixture = new LoginCommand(u);
		String cmd = "!login";

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
	public void testExecute_badUsername()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", false, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		
		LoginCommand fixture = new LoginCommand(u);
		String cmd = "!login lili fee";

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
	public void testExecute_alreadyLoggedOn()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		
		LoginCommand fixture = new LoginCommand(u);
		String cmd = "!login muhkuh";


		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		assertFalse(result);
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
		new org.junit.runner.JUnitCore().run(LoginCommandTest.class);
	}
}