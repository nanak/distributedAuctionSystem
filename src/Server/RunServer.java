package Server;

import java.io.Console;
import java.util.Scanner;

/**
 * Test Class
 * @author Tobi
 *
 */
public class RunServer{
	public static void main (String [] args){
		if(args.length==1){
			Server s=new Server(Integer.parseInt(args[0]));
		}else{
			Server s=new Server(1111);
		};
	}	 
}
 
