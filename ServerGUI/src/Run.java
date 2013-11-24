import java.io.IOException;


public class Run {
	public static void main(String[] args) throws IOException {
		Server s = new Server();
		s.init();
		s.getMsg();
		s.close();
	}
}
