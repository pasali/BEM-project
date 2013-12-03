import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendSmsGUI {

	private JFrame frame;
	public static JTextField textField;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SendSmsGUI window = new
	 * SendSmsGUI(); window.frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public SendSmsGUI(String no) {
		initialize(no);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String number) {
		frame = new JFrame();
		frame.setBounds(100, 100, 212, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnGnder = new JButton("Gönder");
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Run.s.sendMsg();
				frame.dispose();
			}
		});
		btnGnder.setBounds(82, 234, 100, 25);
		frame.getContentPane().add(btnGnder);

		textField = new JTextField();
		textField.setText(number);
		textField.setEditable(false);
		textField.setBounds(12, 38, 122, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JLabel lblGnderen = new JLabel("Kime:");
		lblGnderen.setBounds(12, 23, 97, 15);
		frame.getContentPane().add(lblGnderen);

		JLabel lblGelenMesaj = new JLabel("Mesaj:");
		lblGelenMesaj.setBounds(12, 81, 110, 15);
		frame.getContentPane().add(lblGelenMesaj);

		textArea = new JTextArea();
		textArea.setBounds(15, 103, 167, 119);

		frame.setVisible(true);
		frame.getContentPane().add(textArea);
	}
}
