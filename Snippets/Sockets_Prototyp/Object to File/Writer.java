import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Writer {
	public static void main(String[] args) {
		System.out.println("Geben sie den Text ein der gespeichert werden soll");
		
		 String text = 	""; 
		 try{
			    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    String s = bufferRead.readLine();
			    text = ""+s;
		 
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		 
		  
       try {
	          File file = new File("example.txt");
	          BufferedWriter output = new BufferedWriter(new FileWriter(file));
	          output.write(text);
	          output.close();
	        } catch ( IOException e ) {
	           e.printStackTrace();
	        }
	    }
}
	

