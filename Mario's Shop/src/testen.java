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

public class testen {

	private JFrame frame;
	private JTable table;

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
		
		
		/*-------------------------------------------------------------------------------------*/
		
		JPanel panel_1 = new JPanel();
		Maintab.addTab("Warenkorb", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		Maintab.addTab("Changelog", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		Maintab.addTab("Benutzermanagement", null, panel_3, null);
		
		JButton btnNewButton = new JButton("Ausloggen");
		btnNewButton.setBounds(549, 506, 119, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("E-Shop creater : Mario Schulz, Bernd Henke, Dyar lol");
		lblNewLabel.setBounds(40, 510, 442, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
