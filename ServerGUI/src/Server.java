import java.net.*;
import java.io.*;

public class Server {

	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String inputLine;
	private String[] inData;

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

	public void sendMsg() {
		
		
		String dataToSend = msg + "," + number;
		out.print(dataToSend);
	}
	
	public void getMsg() throws IOException {
		ServerGUI.main(null);
		while ((inputLine = in.readLine()) != null) {
			inData = inputLine.split(",");
			ServerGUI.textArea.append(inData[0]);
			ServerGUI.textField.setText(inData[1]);
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