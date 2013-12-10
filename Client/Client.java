package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Client {
 
	private String host;
	 
	private int tcpport;
	 
	private int udpport;
	 
	private DatagramSocket udpsocket;
	 
	private ServerListener serverListener;
	 
	public boolean Client(String host, int tcp, int udp) {
		return false;
	}
	 
	public void shutdown() {
	 
	}
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
     void test() throws IOException {
        String ip = "127.0.0.1"; // localhost
        int port = 1234;
        java.net.Socket socket = new java.net.Socket(ip,port); // verbindet sich mit Server
        String zuSendendeNachricht = "Hello, world!";
        send(socket, zuSendendeNachricht);
        //String empfangeneNachricht = recevie(socket);
        //System.out.println(empfangeneNachricht);
     }
     void send(java.net.Socket socket, String nachricht) throws IOException {
        PrintWriter printWriter =new PrintWriter( new OutputStreamWriter(socket.getOutputStream()));
        printWriter.print(nachricht);
        printWriter.flush();
    }
    String recevie(java.net.Socket socket) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] buffer = new char[200];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
        String nachricht = new String(buffer, 0, anzahlZeichen);
        return nachricht;
    }
}
 
