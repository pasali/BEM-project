import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ServerGUI {

	private JFrame frame;
	public static JTextField textField;
	public static JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI window = new ServerGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 196, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGnder = new JButton("Cevapla");
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGnder.setBounds(82, 234, 100, 25);
		frame.getContentPane().add(btnGnder);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(12, 38, 122, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblGnderen = new JLabel("Gönderen:");
		lblGnderen.setBounds(12, 23, 97, 15);
		frame.getContentPane().add(lblGnderen);
		
		JLabel lblGelenMesaj = new JLabel("Gelen Mesaj:");
		lblGelenMesaj.setBounds(12, 81, 110, 15);
		frame.getContentPane().add(lblGelenMesaj);
		
		textArea = new JTextArea();
		textArea.setBounds(15, 103, 167, 119);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
	}

}
