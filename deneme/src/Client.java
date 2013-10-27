import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws IOException {
		String serverName = "localhost";
		int port = 1233;
		Socket echoSocket = new Socket(serverName, port);
		PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				echoSocket.getInputStream()));
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));
		String a = stdIn.readLine();
		out.print(a);
		out.flush();
		echoSocket.close();
		in.close();
		out.close();

	}
}