import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import java.awt.Color;

public class testen {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testen window = new testen();
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
	
	public testen() {
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
		Layout.setBounds(194, 58, 445, 410);
		LagerTab.add(Layout);
		
		// erstellt die Tabelle
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Nummer", "Preis", "Bestand", "Mindestbestand"
			}
		) {
			// die Klassen mit jeweils den Parametern
			
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Double.class, Integer.class, Object.class
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
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(57);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		Layout.setViewportView(table);
		
		//erstellt ein button "artikel hinzufügen"
		
		JButton ArtikelHinzufuegen = new JButton("Artikel hinzufuegen");
		ArtikelHinzufuegen.addActionListener(new ActionListener() {
			
	    // Funktion zum öffnen eines neuen Fensters, um artikel hinzufügen zu können
			
			public void actionPerformed(ActionEvent e) {
					
				
			}
		});
		ArtikelHinzufuegen.setBounds(486, 11, 153, 23);
		LagerTab.add(ArtikelHinzufuegen);
		
		//erstellt button "artikel löschen" 
		
		JButton ArtikelLoeschen = new JButton("Artikel L\u00F6schen");
		ArtikelLoeschen.addActionListener(new ActionListener() {
			
			// Funktion zum öffnen eines neuen Fensters, um artikel löschen zu können
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtikelLoeschen.setBounds(330, 11, 126, 23);
		LagerTab.add(ArtikelLoeschen);
		
		// erstellt button "artikel suchen"
		
		JButton ArtikelSuchen = new JButton("Artikel suchen");
		ArtikelSuchen.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel löschen zu können
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtikelSuchen.setBounds(194, 11, 126, 23);
		LagerTab.add(ArtikelSuchen);
		
		//erstellt button "Artikel sortieren Nummer"
		
		JButton ArtikelSoNum = new JButton("Artikel Sortieren Nummer");
		ArtikelSoNum.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtikelSoNum.setBounds(0, 419, 195, 23);
		LagerTab.add(ArtikelSoNum);
		
		// erstellt button " artikeln sortieren Namen"
		
		JButton ArtikelSoNam = new JButton("Artikel Sortieren Namen");
		ArtikelSoNam.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtikelSoNam.setBounds(0, 373, 196, 23);
		LagerTab.add(ArtikelSoNam);
		
		JButton btnArtikelAnzeigen = new JButton("Artikel anzeigen");
		btnArtikelAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnArtikelAnzeigen.setBounds(10, 11, 153, 23);
		LagerTab.add(btnArtikelAnzeigen);
		
		// erstell layout für die bestandserhöhung 
		
		JScrollPane Layout1 = new JScrollPane();
		Layout1.setBounds(10, 147, 170, 202);
		LagerTab.add(Layout1);
		
		// erstell "Raster im layout, um buttons etc einfügen zu können
		
		JPanel Raster = new JPanel();
		Layout1.setViewportView(Raster);
		Raster.setLayout(null);  
		
		// erstellt button " bestand erhoehen"
		
		JButton btnNewButton_1 = new JButton("Bestand \u00E4ndern");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 134, 152, 23);
		Raster.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Neuer Bestand :");
		lblNewLabel_1.setBounds(37, 72, 113, 14);
		Raster.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(37, 92, 96, 20);
		Raster.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Artikelname :");
		lblNewLabel_1_1.setBounds(37, 16, 113, 14);
		Raster.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(37, 41, 96, 20);
		Raster.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 168, 152, 14);
		Raster.add(lblNewLabel_2);
		

		
		
		/*-------------------------------------------------------------------------------------*/
		
		JPanel panel_1 = new JPanel();
		Maintab.addTab("Warenkorb", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		
		JPanel panel_2 = new JPanel();
		Maintab.addTab("Changelog", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		
		/*---------------------------------------------------------------------------------------*/
		
		// erstellt tab benutzermanagement
		
		JPanel 	Benutzermanagement = new JPanel();
		Maintab.addTab("Benutzermanagement", null, Benutzermanagement, null);
		Benutzermanagement.setLayout(null);
		
		// ScrollPane für Tabelle erstellt
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 50, 414, 165);
		Benutzermanagement.add(scrollPane);
		
		// erstellt tabelle für Kunde
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"KundenNr", "Username", "Vorname", "Nachname", "Wohnort", "PLZ", "Strasse"
			}
		) {
			// eigenschaften in der Tabelle ( größe, int etc..)
			
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, true, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(62);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(63);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(58);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(63);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(57);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(35);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(52);
		scrollPane.setViewportView(table_1);
		
		
		/*-----------------------------------------------------*/
		
		// scrollPane für die 2. tabelle erstellt
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(38, 274, 414, 175);
		Benutzermanagement.add(scrollPane1);
		
		// erstellt tabelle für Mitarbeiter
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MitarbeiterNr", "Username", "Vorname", "Nachname", "Wohnort", "PLZ", "Strasse"
			}
		) {
			// eigenschaften in der Tabelle ( größe, int etc..)
			
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(1).setPreferredWidth(61);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(58);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(64);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(57);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(34);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(51);
		scrollPane1.setViewportView(table_2);
		
		
		// erstellt button mitarbeiter suchen 
		
		JButton mitarbeiterSuchen = new JButton("Mitarbeiter suchen");
		mitarbeiterSuchen.setBounds(484, 329, 155, 23);
		Benutzermanagement.add(mitarbeiterSuchen);
		
		// erstellt button mitarbeiter löschen 
		
		JButton mitarbeiterLoeschen = new JButton("Mitarbeiter l\u00F6schen ");
		mitarbeiterLoeschen.setBounds(484, 380, 155, 23);
		Benutzermanagement.add(mitarbeiterLoeschen);
		
		// erstellt button mitarbeiter anlegen
		
		JButton mitarbeiterAnlegen = new JButton("Mitarbeiter anlegen");
		mitarbeiterAnlegen.setBounds(484, 426, 155, 23);
		Benutzermanagement.add(mitarbeiterAnlegen);
		
		//erstellt button kunde suchen
		
		JButton kundeSuchen = new JButton("Kunde suchen");
		kundeSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		kundeSuchen.setBounds(484, 53, 155, 23);
		Benutzermanagement.add(kundeSuchen);
		
		// erstellt button kunde löschen
		
		JButton kundeLoeschen = new JButton("Kunde l\u00F6schen");
		kundeLoeschen.setBounds(484, 101, 155, 23);
		Benutzermanagement.add(kundeLoeschen);
		
		// erstellt button anlegen 
		
		JButton kundeAnlegen = new JButton("Kunde anlegen");
		 kundeAnlegen.setBounds(484, 147, 155, 23);
		Benutzermanagement.add( kundeAnlegen);
		
		// erstellt button listen aktualisieren 
		
		JButton listenAktualisieren = new JButton("Listen aktualisieren");
		listenAktualisieren.setBounds(484, 227, 155, 26);
		Benutzermanagement.add(listenAktualisieren);
		
		// erstellt ein label bzw übeschrift für die tabellen (kunde)
		
		JLabel labelKunden = new JLabel("Liste von Kunden");
		labelKunden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelKunden.setBounds(38, 13, 160, 26);
		Benutzermanagement.add(labelKunden);
		
		// erstellt ein label bzw übeschrift für die tabellen (mitarbeiter)
		
		JLabel labelMitarbeiter = new JLabel("Liste von Mitarbeiter");
		labelMitarbeiter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMitarbeiter.setBounds(38, 237, 160, 26);
		Benutzermanagement.add(labelMitarbeiter);
		
		
		
		
		/*-------------------------------------------------------------------*/
		
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
