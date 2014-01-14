package test.ServerTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Server.User;

public class UserTest {
	
	@Test
	public void testSendNotifikation(){
		User a = new User(null, false, null, null, 0);
		a.sendNotification("Hallo");
		
	}
	
	@Test
	public void testSetName(){
		User a = new User(null, false, null, null, 0);
		a.setName("Gustav");
		if(a.getName().equals("Gustav")){
			assertTrue(true);
			
		}else{
			assertFalse(false);
		}
		
	}
	@Test
	public void testGetIP(){
		User a = new User(null, false, null,"10.20.30.40", 0);
		
		if(a.getIP().equals("10.20.30.40") ){
			assertTrue(true);
			
		}else{
			assertTrue(false);
		}
		
	}
	@Test
	public void testSetOnline(){
		User a = new User(null, false, null,"10.20.30.40", 0);
		a.setOnline(true);
		if(a.getOnline()==true ){
			assertTrue(true);
			
		}else{
			assertTrue(false);
		}
		
	}

}
