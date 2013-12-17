import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;


public class Filereader {
	
	public static void main(String[] args) throws IOException {
		
		
		
		   File file = new File("example.txt"); //for ex foo.txt
		       char[] chars = new char[(int) file.length()];
		       
		      
		   
		   
		
		 String text = 	""; 
		 String b2= "";
		 FileReader a = new FileReader(file);
		 a.read(chars);
		 
		 text = chars.toString();
		 if ( text.contains("Benutzer")== true ){
			 for(int i = 0;i<chars.length;i++){
			 if(chars[i] =='B'){
				 if(chars[i+7]=='r'){
					 int c = i;
					 for(;i<c+7;c++){
					b2= b2+" "+chars[i];
					text =b2.toString();
					 }
				 }
			 }
			 
			 
			 }
			 System.out.println("Die Gewünschten Werte sind"+text);
		
		 }
		 
		  
		 a.close();

	}}
