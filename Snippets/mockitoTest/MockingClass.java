package mockitoTest;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;


public class MockingClass {
	private UserService userService;
	private UserManager userManager;
	@Before
	public void setUp() throws Exception {
	    userService = Mockito.mock(UserService.class);
	    userManager = new UserManager();
	    userManager.setUserService(userService);
	}
	
	@Test
    public void testSaveUser() throws Exception {
        User user = new User("u1");
        userManager.saveUser(user);
 
        //Verify if saveUser was invoked on userService with given 'user' object.
        Mockito.verify(userService).saveUser(user);
 
        //Verify with Argument Matcher
        Mockito.verify(userService).saveUser(Mockito.<User>any());
    }
	
	@Test
	public void testCountNumberOfInteractions() throws Exception {
	 
	    userManager.findUser("user1");
	 
	    //Verify the number of interactions with mock
	    Mockito.verify(userService, Mockito.times(1)).findUserByName("user1");
	 
	    //There was only one interaction with userService
	    Mockito.verifyNoMoreInteractions(userService);
	}
	
	@Test
	public void testZeroInteractionsWithMock() throws Exception {
	 
	    User user = new User("user1", new Date());
	 
	    //call method where no call to userService will be made
	    userManager.getUserLastLogin(user);
	    Mockito.verifyZeroInteractions(userService);
	 
	    //Another way to check zero interactions
	    userManager.getUserLastLogin(user);
	    Mockito.verify(userService, Mockito.never());
	}
	
	@Test
	public void testFindUser() throws Exception {
	 
	    //Stub the value that will returned on call to userService.findUserByName
	    User stubbedUser = new User("userAfterSave");
	    Mockito.when(userService.findUserByName("user1")).thenReturn(stubbedUser);
	 
	    //make the call
	    User user = userManager.findUser("user1");
	 
	    //Verify if findUserByName method was invoked on userService call
	    Mockito.verify(userService).findUserByName("user1");
	 
	    Assert.assertEquals("userAfterSave", user.getUserName());
	}
	
	
}
