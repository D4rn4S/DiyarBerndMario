import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class weitertesten {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		frame.setBounds(100, 100, 328, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Artikelanlegen = new JLabel("Legen Sie ein neuen Artikel an!");
		Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artikelanlegen.setBounds(56, 11, 197, 31);
		frame.getContentPane().add(Artikelanlegen);
		
		JLabel Artikelname = new JLabel("Artikelname :");
		 Artikelname.setBounds(37, 64, 96, 14);
		frame.getContentPane().add(Artikelname);
		
		textArtikel= new JTextField();
		textArtikel.setBounds(37, 89, 96, 20);
		frame.getContentPane().add(textArtikel);
		textArtikel.setColumns(10);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer :");
		lblArtikelnummer.setBounds(37, 120, 96, 14);
		frame.getContentPane().add(lblArtikelnummer);
		
		textNummer = new JTextField();
		textNummer.setColumns(10);
		textNummer.setBounds(37, 145, 37, 20);
		frame.getContentPane().add(textNummer);
		
		
		
		JLabel Preis = new JLabel("Preis :");
		Preis.setBounds(187, 64, 96, 14);
		frame.getContentPane().add(Preis);
		
		textPreis = new JTextField();
		textPreis.setColumns(10);
		textPreis.setBounds(187, 89, 96, 20);
		frame.getContentPane().add(textPreis);
		
		
		JLabel Bestand = new JLabel("Bestand");
		Bestand.setBounds(187, 120, 96, 14);
		frame.getContentPane().add(Bestand);
		
		textBestand = new JTextField();
		textBestand.setColumns(10);
		textBestand.setBounds(187, 145, 96, 20);
		frame.getContentPane().add(textBestand);
		
		
		
		JLabel Mindestbestand = new JLabel("Mindestbestand :");
		Mindestbestand.setBounds(37, 176, 96, 14);
		frame.getContentPane().add(Mindestbestand);
		
		textMindestbestand = new JTextField();
		textMindestbestand.setColumns(10);
		textMindestbestand.setBounds(37, 201, 96, 20);
		frame.getContentPane().add(textMindestbestand);
		
		JButton Hinzufügen = new JButton("Hinzuf\u00FCgen");
		Hinzufügen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Hinzufügen.setBounds(177, 189, 104, 32);
		frame.getContentPane().add(Hinzufügen);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(81, 232, 132, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
