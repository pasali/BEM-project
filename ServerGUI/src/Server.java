import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String inputLine;
		
		try {
			serverSocket = new ServerSocket(1238);
		} catch (IOException e) {
			System.err.println("I/O exception: " + e.getMessage());
			System.exit(1);
		}
		System.out.println("Bağlantı bekleniyor...");
		
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		System.out.println(clientSocket.getLocalAddress() + " baglandı.");
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		
		while ((inputLine = in.readLine()) != null) {
			System.out.println("client:" + inputLine);
			if (inputLine.equals("fak"))
				break;
		}
		System.out.println(clientSocket.getLocalSocketAddress()
				+ " baglantisi kesildi.");
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}