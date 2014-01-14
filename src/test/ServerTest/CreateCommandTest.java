package test.ServerTest;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.*;

import Server.Auction;
import Server.CommandMapFactory;
import Server.CreateCommand;
import Server.ManageConnection;
import Server.User;
import static org.junit.Assert.*;

/**
 * The class <code>CreateCommandTest</code> contains tests for the class <code>{@link CreateCommand}</code>.
 *
 * @generatedBy CodePro at 1/12/14 7:15 PM
 * @author mlipovits
 * @version $Revision: 1.0 $
 */
public class CreateCommandTest {
	/**
	 * Run the CreateCommand(ArrayList<Auction>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	@Test
	public void testCreateCommand_1()
		throws Exception {
		ArrayList<Auction> auctionlist = new ArrayList<Auction>();
		ArrayList<User> userlist = new ArrayList<User>();

		CreateCommand result = new CreateCommand(auctionlist,userlist);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	@Test
	public void testExecute_true()
		throws Exception {
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, user, null, 0.0, "muhkuhli");
		a.add(auc);	
		CreateCommand fixture = new CreateCommand(a,u);
		String cmd = "!create 100 new stuff";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.CreateCommand.execute(CreateCommand.java:25)
		assertTrue(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	@Test
	public void testExecute_idNotNumber()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, null, null, 0.0, "muhkuhli");
		a.add(auc);
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		CreateCommand fixture = new CreateCommand(a,u);

		String cmd = "!create muh muh";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.CreateCommand.execute(CreateCommand.java:25)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	@Test
	public void testExecute_1badArgument()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, null, null, 0.0, "muhkuhli");
		a.add(auc);
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		CreateCommand fixture = new CreateCommand(a,u);
		
		String cmd = "!create x";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.CreateCommand.execute(CreateCommand.java:25)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PMss
	 */
	@Test
	public void testExecute_only1argument()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, null, null, 0.0, "muhkuhli");
		a.add(auc);
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		CreateCommand fixture = new CreateCommand(a,u);
		
		String cmd = "!create 10";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.CreateCommand.execute(CreateCommand.java:25)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	@Test
	public void testExecute_noArguments()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, null, null, 0.0, "muhkuhli");
		a.add(auc);
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		CreateCommand fixture = new CreateCommand(a,u);
		
		String cmd = "!create";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.CreateCommand.execute(CreateCommand.java:25)
		assertFalse(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	@Test
	public void testExecute_trueLong()
		throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, null, null, 0.0, "muhkuhli");
		a.add(auc);
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		CreateCommand fixture = new CreateCommand(a,u);
		
		String cmd = "!create 100 new stuff dko asj dpa saj dpsajadp sd sdsajopsa djsa awsü";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.CreateCommand.execute(CreateCommand.java:25)
		assertTrue(result);
	}

	/**
	 * Run the boolean execute(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	@Test
	public void testExecute_userlistEmpty()
		throws Exception {
		ArrayList<User> u = new ArrayList<User>();
		User user=new User("mimi", true, new Date(System.currentTimeMillis()), "1.1.1.1",1234);
		u.add(user);
		ArrayList<Auction> a = new ArrayList<Auction>();
		Auction auc= new Auction(0, 10000, user, null, 0.0, "muhkuhli");
		a.add(auc);	
		CreateCommand fixture = new CreateCommand(a,new ArrayList<User>());
		String cmd = "!create 100 new stuff";

		boolean result = fixture.execute(cmd, new ManageConnection(null, new CommandMapFactory(a, u)), "mimi", "1.1.1.1");

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Server.CreateCommand.execute(CreateCommand.java:25)
		assertFalse(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/12/14 7:15 PM
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
	 * @generatedBy CodePro at 1/12/14 7:15 PM
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
	 * @generatedBy CodePro at 1/12/14 7:15 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CreateCommandTest.class);
	}
}