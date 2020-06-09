import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class weitertesten {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					weitertesten window = new weitertesten();
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
	public weitertesten() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 304, 246);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Artikelanlegen = new JLabel("Welchen Artikel Suchen Sie?");
		Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artikelanlegen.setBounds(50, 11, 193, 31);
		frame.getContentPane().add(Artikelanlegen);
		
		
		
		JButton Suchen = new JButton("Suchen");
		Suchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Suchen.setBounds(81, 143, 104, 32);
		frame.getContentPane().add(Suchen);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Geben Sie die Artikelnummer des Artikels ein :");
		lblNewLabel_1.setBounds(10, 68, 282, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(81, 93, 104, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(26, 186, 240, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
