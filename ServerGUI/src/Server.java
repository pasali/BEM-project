import java.net.*;
import java.io.*;

public class Server {

	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String inputLine;
	private String[] data;

	public String getInputLine() {
		return inputLine;
	}

	public void setInputLine(String inputLine) {
		this.inputLine = inputLine;
	}

	public void init() throws IOException {
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
	}

	public void getMsg() throws IOException {
		ServerGUI.main(null);
		while ((inputLine = in.readLine()) != null) {
			data = inputLine.split(",");
			ServerGUI.textArea.append(data[0]);
			ServerGUI.textField.setText(data[1]);
			ServerGUI.textArea.append("\n *** \n");

		}

	}

	public void close() throws IOException {
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}

}