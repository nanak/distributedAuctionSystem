package Client;

/**
 * Main class to test
 * 
 * @author Tobi
 *
 */
public class RunClient {
	public static void main (String [] args){
		if(args.length==3){
			Client c=new Client(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		}else{
			Client c=new Client("127.0.0.1", 1111, 1234);
		}
		
	}
	 
}
 
