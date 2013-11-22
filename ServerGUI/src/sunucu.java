package socketapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;

public class sunucu {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sunucu window = new sunucu();
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
	public sunucu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 424, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGnder = new JButton("Cevapla");
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGnder.setBounds(289, 234, 117, 25);
		frame.getContentPane().add(btnGnder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 398, 122);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(12, 38, 238, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblGnderen = new JLabel("Gönderen:");
		lblGnderen.setBounds(12, 23, 97, 15);
		frame.getContentPane().add(lblGnderen);
		
		JLabel lblGelenMesaj = new JLabel("Gelen Mesaj:");
		lblGelenMesaj.setBounds(12, 86, 110, 15);
		frame.getContentPane().add(lblGelenMesaj);
	}
}
