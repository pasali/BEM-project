import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private int port = 1238;
	private ServerSocket socket;
	private Socket conn;
	private OutputStream s_out   = null;
	private BufferedReader s_in;
	
	
	public   void Gogo() throws IOException{
		socket = new ServerSocket(port);
		conn = socket.accept();
		System.out.println(conn.getInetAddress());
		s_in = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
		String line = s_in.readLine();
		System.out.println(line);
		s_in.close();
		conn.close();
		socket.close();
	}
}
