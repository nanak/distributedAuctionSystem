package test.ServerTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ClientTest.ServerListenerTest;



/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 1/12/14 7:31 PM
 * @author Michaela Lipovits
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CreateCommandTest.class,
	ListCommandTest.class,
	BidCommandTest.class,
	LoginCommandTest.class,
	LogoutCommandTest.class,
	DataManagerTest.class,
	NotifiyTest.class,
	ServerclasTest.class,
	UserTest.class,
	RunServerTest.class
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 1/12/14 7:31 PM
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
