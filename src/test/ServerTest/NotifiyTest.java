package test.ServerTest;

import static org.junit.Assert.*;

import org.junit.*;

import Server.Notification;

public class NotifiyTest {
	
	@Test
	public void testNotification(){
		Notification a = new Notification("Hallo");
		
	}
	
	@Test
	public void testToString(){
		Notification a = new Notification("Hallo");
		if(a.toString().equals("Hallo")== true){
			assertTrue(true);
		}else{
			assertFalse(false);
		}
	}

}
