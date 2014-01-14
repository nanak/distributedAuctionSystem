package ServerTest;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.*;

import Client.TCPConnection;
import Server.Auction;
import Server.BidCommand;
import Server.CommandMapFactory;
import Server.ManageConnection;
import Server.User;
import static org.junit.Assert.*;

/**
 * The class <code>BidCommandTest</code> contains tests for the class <code>{@link BidCommand}</code>.
 *
 * @generatedBy CodePro at 1/12/14 7:49 PM
 * @author mlipovits
 * @version $Revision: 1.0 $
 */
public class BidCommandTest {
	/**
	 * Run the BidCommand(ArrayList<Auction>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testBidCommand_1()
		throws Exception {
		ArrayList<Auction> auctionlist = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		BidCommand result = new BidCommand(auctionlist, u);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_cmd1word()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		User user2=new User("hansi", true, new Date(System.currentTimeMillis()), "2.2.2.2",1234);
		u.add(user);
		u.add(user2);
		Auction auc= new Auction(0, 10000, user2, null, 0.0, "muhkuhli");
		a.add(auc);
		
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid";
		
		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_value1FormatError()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		User user2=new User("hansi", true, new Date(System.currentTimeMillis()), "2.2.2.2",1234);
		u.add(user);
		u.add(user2);
		Auction auc= new Auction(0, 10000, user2, null, 0.0, "muhkuhli");
		a.add(auc);
		
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid muh 2";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_value2FormatError()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		User user2=new User("hansi", true, new Date(System.currentTimeMillis()), "2.2.2.2",1234);
		u.add(user);
		u.add(user2);
		Auction auc= new Auction(0, 10000, user2, null, 0.0, "muhkuhli");
		a.add(auc);
		
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid 2 ha";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_cmd2words()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		User user2=new User("hansi", true, new Date(System.currentTimeMillis()), "2.2.2.2",1234);
		u.add(user);
		u.add(user2);
		Auction auc= new Auction(0, 10000, user2, null, 0.0, "muhkuhli");
		a.add(auc);
		
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid 2";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_true()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user2=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		User user=new User("hansi",true, new Date(System.currentTimeMillis()), "2.2.2.2",1234);
		u.add(user);
		u.add(user2);
		Auction auc= new Auction(0, 10000, user, null, 0.0, "muhkuhli");
		a.add(auc);
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid 0 100";
		
		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertTrue(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_idNotInList()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		User user2=new User("hansi", true, new Date(System.currentTimeMillis()), "2.2.2.2",1234);
		u.add(user);
		u.add(user2);
		Auction auc= new Auction(0, 10000, user2, null, 0.0, "muhkuhli");
		a.add(auc);
		
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid 1 100";
		
		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_auctionEmpty()
		throws Exception {
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		BidCommand fixture = new BidCommand(new ArrayList<Auction>(), u);
		String cmd = "!bid 0 100";

		
		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(new ArrayList<Auction>(), u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_notHighestBid()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		User user2=new User("hansi", true, new Date(System.currentTimeMillis()), "2.2.2.2",1234);
		u.add(user);
		u.add(user2);
		Auction auc= new Auction(0, 10000, user2, null, 20, "muhkuhli");
		a.add(auc);
		
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid 0 10";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_userEmpty()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, null, null, 0.0, "muhkuhli");
		a.add(auc);
		BidCommand fixture = new BidCommand(a, new ArrayList<User>());
		String cmd = "!bid 1 100";

		
		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, new ArrayList<User>())), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_bidderIsOwner()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		Auction auc= new Auction(0, 10000, user, null, 0.0, "muhkuhli");
		a.add(auc);
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid 0 100";
		
		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	@Test
	public void testExecute_noBidderName()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		Auction auc= new Auction(0, 10000, user, null, 0.0, "muhkuhli");
		a.add(auc);
		
		BidCommand fixture = new BidCommand(a, u);
		String cmd = "!bid 2 ha";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.BidCommand.execute(BidCommand.java:26)
		assertFalse(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/12/14 7:49 PM
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
	 * @generatedBy CodePro at 1/12/14 7:49 PM
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
	 * @generatedBy CodePro at 1/12/14 7:49 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BidCommandTest.class);
	}
}