import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Kundenfenster {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kundenfenster window = new Kundenfenster();
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
	
	public Kundenfenster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// main tab 
		
		JTabbedPane Maintab = new JTabbedPane(JTabbedPane.TOP);
		Maintab.setBounds(0, 0, 668, 507);
		frame.getContentPane().add(Maintab);
		
		/*-------------------------------------------------------------------------------------*/
		
		 // lager tab erstellt
		
		JPanel LagerTab = new JPanel();
		Maintab.addTab("Lager", null, LagerTab, null);
		LagerTab.setLayout(null);
		
		// erstellt das Layout, wo die Tabelle entsteht
		
		JScrollPane Layout = new JScrollPane();
		Layout.setBounds(320, 58, 319, 410);
		LagerTab.add(Layout);
		
		// erstellt die Tabelle
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Nummer", "Preis",
			}
		) {
			// die Klassen mit jeweils den Parametern
			
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Double.class,
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		
		Layout.setViewportView(table);
		
		// erstellt button "artikel suchen"
		
		JButton ArtikelSuchen = new JButton("Artikel suchen");
		ArtikelSuchen.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel löschen zu können
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtikelSuchen.setBounds(513, 11, 126, 23);
		LagerTab.add(ArtikelSuchen);
		
		//erstellt button "Artikel sortieren Nummer"
		
		JButton ArtikelSoNum = new JButton("Artikel Sortieren Nummer");
		ArtikelSoNum.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtikelSoNum.setBounds(52, 417, 195, 23);
		LagerTab.add(ArtikelSoNum);
		
		// erstellt button " artikeln sortieren Namen"
		
		JButton ArtikelSoNam = new JButton("Artikel Sortieren Namen");
		ArtikelSoNam.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtikelSoNam.setBounds(51, 372, 196, 23);
		LagerTab.add(ArtikelSoNam);
		
		JButton btnArtikelAnzeigen = new JButton("Artikel anzeigen");
		btnArtikelAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnArtikelAnzeigen.setBounds(319, 11, 153, 23);
		LagerTab.add(btnArtikelAnzeigen);
		
		// erstell layout für die bestandserhöhung 
		
		JScrollPane Layout1 = new JScrollPane();
		Layout1.setBounds(10, 58, 249, 291);
		LagerTab.add(Layout1);
		
		// erstell "Raster im layout, um buttons etc einfügen zu können
		
		JPanel Raster = new JPanel();
		Layout1.setViewportView(Raster);
		Raster.setLayout(null);  
		
		// erstellt button " bestand erhoehen"
		
		JButton btnNewButton_1 = new JButton("Artikel hinzuf\u00FCgen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(49, 229, 152, 23);
		Raster.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Preis :");
		lblNewLabel_1.setBounds(76, 141, 113, 14);
		Raster.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(76, 176, 96, 20);
		Raster.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Artikelname :");
		lblNewLabel_1_1.setBounds(76, 74, 113, 14);
		Raster.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 110, 96, 20);
		Raster.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(49, 263, 152, 14);
		Raster.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Artikel zum Warenkorb hinzuf\u00FCgen");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 11, 227, 32);
		Raster.add(lblNewLabel_3);
		

		
		
		/*-------------------------------------------------------------------------------------*/
		
		JPanel panel_1 = new JPanel();
		Maintab.addTab("Warenkorb", null, panel_1, null);
		panel_1.setLayout(null);
		
				
		JButton btnNewButton = new JButton("Ausloggen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(549, 506, 119, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("E-Shop creater : Mario Schulz, Bernd Henke, Dyar lol");
		lblNewLabel.setBounds(40, 510, 442, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
