package test.ServerTest;

import org.junit.*;

import Server.RunServer;

public class RunServerTest {
	
	
	@Test
	public void testRunServer(){
		String[] a = new String[200];
		RunServer.main(a);
		
	}

}
