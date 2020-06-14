package GUI;

//package CUI;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Datenstrukturen.Lager;
import Datenstrukturen.Mitarbeiter;
import Datenstrukturen.Verkaufsstand;
import Datenstrukturen.Warenkorb;
import Datenstrukturen.tempArtikel;
import Manager.ChangeLogManager;
import Datenstrukturen.Artikel;
import Datenstrukturen.Buero;
import Datenstrukturen.Changelog;
import Datenstrukturen.Kunde;



/**
 * 
 * @author Mario
 *
 */
public class testgui extends JFrame{
	
	private static Lager lager;
	private static Buero buero;
	private static Verkaufsstand verkaufsstand;
	private static Changelog changelog;
	private static ChangeLogManager logmanager;
	private static Warenkorb warenkorb;
	static List<String> log = new ArrayList<String>();
	private List<Artikel> aliste;
	private List<Kunde> kliste;
	private List<Mitarbeiter> mliste;
	private JFrame gibMenueAus;
	private JFrame shopAnmeldung;
	private JFrame shopKundeRegistrierung;
	private JFrame shopMitarbeiterRegistrierung;
	private JFrame shopAnmeldungMitarbeiter;
	private JFrame shopAnmeldungKunde;
	private JFrame mitarbeiterMenue;
	private JFrame ArtikelHinzufuegenMenue;
	private JFrame kundenMenue;
	private JFrame ArtikelLoeschenMenue;
	private JFrame artikelScreach;
	private JTextField textVorname;
	private JTextField textNachname;
	private JTextField textWohnort;
	private JTextField textStraße;
	private JTextField textplz;
	private JTextField textNr;
	private JTextField textBenutzername;
	private JTextField textID;
	private JTextField textArtikel;
	private JTextField textArtikel2;
	private JTextField textNummer;
	private JTextField textPreis;
	private JTextField textBestand;
	private JTextField textMindestbestand;
	private JTextField textArtikelNummer;
	private JTextField textArtikelname;
	private JTextField textAnzahl;
	private JTextField textArtikelNr;
	private JTextField textArtikelNr1;
	private JTextField textAnzahl1;
	private JPasswordField textPasswort;
	private JTextField textKundeNr;
	private JTextField textMitarbeiterNr;
	private JTextField textKundenNummer;
	private JLabel FalscheKundenNr;
	private JLabel FalscheMitarbeiterNr;
	private JLabel FalscheIDundPw;
	private JLabel falscherArtikel;
	private JLabel falscheEingabe;
	private JTable tabelle;
	private JTable tabelle1;
	private JTable tabelle2;
	private JTable tabelle3;
	private JLabel gesamtPreisZahl;
	private JFrame kundLoeschen;
	private JFrame artikelScreach1;
	private JFrame mitaLoeschen;
	private JTextField textMitarbeiterNummer;
	private JFrame mitarbeiterScreach;
	
	
	/**
	 * 
	 * Verwendet von: Der Main Methode
	 * Methodenbeschriebung: Der Konstrukter der GUI Erzeugt die Manager und ihre schnittstellen. Außerdem wird der Changelog und der Warenkorb erzeugt.
	 * 
	 * @param dArtikel ist die Datei in der die Artikel stehen
	 * @param dMitarbeiter ist die Datei in der die Mitarbeiter stehen
	 * @param dKunden ist die Datei in der die Kunden stehen
	 * @param dLog ist die Datei in der der Log steht
	 */
	public testgui(String dArtikel, String dMitarbeiter, String dKunden, String dLog) {
		
		try {
			lager = new Lager(dArtikel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//changelog.schreibeLog("Das Lager wurde erstellt");
		
		try {
			buero = new Buero(dMitarbeiter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//changelog.schreibeLog("Das Buero wurde erstellt");
		
		try {
			verkaufsstand = new Verkaufsstand(dKunden);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//changelog.schreibeLog("Der Verkaufsstand wurde erstellt");
		
		
		logmanager = new ChangeLogManager();
		
		try {
			logmanager.liesLog("Log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			logmanager.schreibeDaten("Log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		mliste = buero.gibAlleMitarbeiter();
		
		kliste = verkaufsstand.gibAlleKunden();
		
		aliste = lager.gibAlleArtikel();
		
		changelog = new Changelog();
		warenkorb = new Warenkorb(aliste);
		
		
	}
	
	
	/**
	 * Funktion wird nicht mehr benötigt in der GUI, kommt aus der CUI..
	 * @return
	 */
	public String liesEingabe() {
		//einlesen von Konsoleneingaben
		String input = "";
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		
		// Funktion zum Beenden des Programms 
		if(input.equals("quit")) {
			System.out.println("das Programm wird jetzt beendet...");
			changelog.schreibeLog("Das Programm wird beendet.");
			try {
				logmanager.schreibeDaten("Log");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit( 0 );
		}
		return input;
	}
	
	


/**
 *  startet das Programm, wird eigentlich auch nicht mehr richtig benötigt..
 */
	public void run() {
		// Variable für Eingaben von der Konsole
		String input = "";
	
		//Hauptschliefe der Benutzeroberfläche
		do {
			gibMenueAus();
		} while (!input.equals("q"));
	
	}


	/**
	 *  Beschreibung: Gibt das GUI aus, in dem man sich entweder anmelden oder Registrieren kann
	 *  Verwendung: Es ist das erste Menue, welches beim starten erscheint.
	 * 
	 */
	public void gibMenueAus() {
		
			// Fenster erstellen
		
			gibMenueAus = new JFrame();
			gibMenueAus.setTitle("E-Shop");
			gibMenueAus.setBounds(500, 300, 418, 269);
			gibMenueAus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gibMenueAus.getContentPane().setLayout(null);
			gibMenueAus.setVisible(true);
			
			//Label Wilkommen
			
			JLabel Willkommen = new JLabel("Herzlich Wilkommen auf unseren Online Shop!");
			Willkommen.setBounds(73, 37, 312, 14);
			gibMenueAus.getContentPane().add(Willkommen);
			
			//Label Anmeldung oder Registrieren
			
			JLabel AoderR = new JLabel("Anmelden oder Registrieren?");
			AoderR.setBounds(115, 100, 241, 14);
			gibMenueAus.getContentPane().add(AoderR);
			
			//button Mitarbeiter
			
			JButton Anmelden = new JButton("Anmelden");
			Anmelden.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					gibMenueAus.setVisible(false);
					shopAnmeldung();
						
				}
			});
			Anmelden.setBounds(225, 165, 105, 23);
			gibMenueAus.getContentPane().add(Anmelden);
			
			//button Kunde
			
			JButton Registrieren = new JButton("Registrieren");
			Registrieren.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					gibMenueAus.setVisible(false);
					shopKundeRegistrierung(false);
					
						}
			});
			
			Registrieren.setBounds(73, 165, 105, 23);
			gibMenueAus.getContentPane().add(Registrieren);

	}
	 
	/**
	 * Verwendet von: MitarbeiterMenue
	 * Beschreibung: füllt die Tabelle in Mitarbeiter Fenster fuer die Artikel.
	 * @param l ist die Liste die welche in die Tabelle gefüllt werden soll.
	 */
	// tabellen befüllen und aktualisieren
	public void updateTabelle(List<Artikel> l) {
		DefaultTableModel TabelleBefüllen = (DefaultTableModel) tabelle.getModel(); //gibt an welche Tabelle befüllt werden soll.
		TabelleBefüllen.setRowCount(0); //leert die aktuelle Tabelle
        Object rowData[] = new Object[5]; //gibt an wie viele Spalten die Tabelle hat
        for(int i = 0; i < l.size(); i++) //geht die Liste durch und speichert die Daten der Spalten
        {
            rowData[0] = l.get(i).getName();
            rowData[1] = l.get(i).getNummer();
            rowData[2] = l.get(i).getPreis();
            rowData[3] = l.get(i).getBestand();
            rowData[4] = l.get(i).getMindestbestand();
            if(l.get(i).getBestand()<= l.get(i).getMindestbestand()) { //nur ein test
            	//TabelleBefüllen
            }
            TabelleBefüllen.addRow(rowData); //befüllt eine Zeile mit allen Spalten
        }
	} 
	
	/**
	 * Verwendet von: MitarbeiterMenue
	 * Beschreibung: füllt die Tabelle für die Mitarbeiter im Benutzermanagement. Funktioniert genauso wie Update Tabelle
	 * @param l gibt die Liste an welche in die Tabelle soll
	 */
	public void updateBenutzerMitarbeiterTabelle(List<Mitarbeiter> l) {
		DefaultTableModel TabelleBefüllen = (DefaultTableModel) tabelle3.getModel();
		TabelleBefüllen.setRowCount(0); //leert die tabelle
        Object rowData[] = new Object[7];
        for(int i = 0; i < l.size(); i++)
        {
            rowData[0] = l.get(i).getMitarbeiterNr();
            rowData[1] = l.get(i).getUsername();
            rowData[2] = l.get(i).getVorname();
            rowData[3] = l.get(i).getNachname();
            rowData[4] = l.get(i).getWohnort();
            rowData[5] = l.get(i).getPlz();
            rowData[6] = l.get(i).getStrasse();
            TabelleBefüllen.addRow(rowData);
        }
	}
	
	/**
	 * Verwendet von: MitarbeiterMenue
	 * Beschreibung: füllt die Tabelle für die Kunden im BenutzerManagement. Funktioniert genauso wie die UpdateTabelle.
	 * @param l gibt die Lsite an, welche in die Tabelle soll.
	 */
	public void updateBenutzerKundenTabelle(List<Kunde> l) {
		DefaultTableModel TabelleBefüllen = (DefaultTableModel) tabelle2.getModel();
		TabelleBefüllen.setRowCount(0); //leert die tabelle
        Object rowData[] = new Object[7];
        for(int i = 0; i < l.size(); i++)
        {
            rowData[0] = l.get(i).getKundenNr();
            rowData[1] = l.get(i).getUsername();
            rowData[2] = l.get(i).getVorname();
            rowData[3] = l.get(i).getNachname();
            rowData[4] = l.get(i).getWohnort();
            rowData[5] = l.get(i).getPlz();
            rowData[6] = l.get(i).getStrasse();
            TabelleBefüllen.addRow(rowData);
        }
	}
	
	
	/**
	 * Verwendet von: KundenMenue
	 * Beschreibung: fuellt die Tabelle für die Artikelliste im KundenMenue, funktioniert genauso wie die Update Tabelle
	 * @param l gibt die Liste an, welche in die Tabelle soll.
	 */
	public void updateKundenTabelle(List<Artikel> l) {
		DefaultTableModel TabelleBefüllen = (DefaultTableModel) tabelle.getModel();
		TabelleBefüllen.setRowCount(0);
        Object rowData[] = new Object[5];
        for(int i = 0; i < l.size(); i++)
        {
            rowData[0] = l.get(i).getName();
            rowData[1] = l.get(i).getNummer();
            rowData[2] = l.get(i).getPreis();
            rowData[3] = l.get(i).getBestand();
            if(l.get(i).getBestand()<= l.get(i).getMindestbestand()) {
            	//TabelleBefüllen
            }
            TabelleBefüllen.addRow(rowData);
        }
	}
	
	
	/**
	 * Verwendet von: KundenMenue
	 * Beschriebung: fuellt die Tabelle im Warenkorb vom Kunden.
	 * @param l ist die Liste welche die Tabelle vom Warenkorb befüllen soll.
	 */
	public void updateKundenWarenkorbTabelle(List<tempArtikel> l) {
		double gesamtpreis;
		double test = 0;
		String testString = "";
		
		DefaultTableModel TabelleBefüllen = (DefaultTableModel) tabelle1.getModel();
		TabelleBefüllen.setRowCount(0);
        Object rowData[] = new Object[5];
        for(int i = 0; i < l.size(); i++)
        {
            rowData[0] = l.get(i).getArtikel().getName();
            rowData[1] = l.get(i).getArtikel().getNummer();
            rowData[2] = l.get(i).getAnzahl();
            rowData[3] = l.get(i).getArtikel().getPreis();
            rowData[4] = l.get(i).getArtikel().getPreis() * l.get(i).getAnzahl();
            
            gesamtpreis = l.get(i).getArtikel().getPreis()* l.get(i).getAnzahl();
            test = gesamtpreis + test;
            testString = String.valueOf(test);
            TabelleBefüllen.addRow(rowData);
            gesamtPreisZahl.setText("  " + testString + " €");
        }
        
	}
	
	
	/**
	 *  Verwendet von: shopAnmelungMitarbeiter
	 *  Beschriebung: Erzeugt die GUI für das MitarbeiterFenster. Hier werden alle Tabs erstellt und auch die Funktionen aufgerufen für das Mitarbeiter Menue.
	 */
	public void mitarbeiterMenue() {
		
		// mitarbeiter menue erstellt 
		
		mitarbeiterMenue = new JFrame();
		mitarbeiterMenue.setVisible(true);
		mitarbeiterMenue.setTitle("Menü für Mitarbeiter");
		mitarbeiterMenue.setBounds(300, 150, 680, 564);
		mitarbeiterMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mitarbeiterMenue.getContentPane().setLayout(null);
		
		// main tab erstellt
		
				JTabbedPane Maintab = new JTabbedPane(JTabbedPane.TOP);
				Maintab.setBounds(0, 0, 668, 507);
				mitarbeiterMenue.getContentPane().add(Maintab);
				
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
				tabelle = new JTable();
				tabelle.setModel(new DefaultTableModel(
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
				tabelle.getColumnModel().getColumn(0).setPreferredWidth(45);
				tabelle.getColumnModel().getColumn(1).setPreferredWidth(55);
				tabelle.getColumnModel().getColumn(2).setPreferredWidth(40);
				tabelle.getColumnModel().getColumn(3).setPreferredWidth(57);
				tabelle.getColumnModel().getColumn(4).setPreferredWidth(90);
				Layout.setViewportView(tabelle);
				
					
				//Tabelle erstes mal befüllen , ruft methode oben auf
				updateTabelle(lager.gibAlleArtikel());
     
			    
				
				//erstellt ein button "artikel hinzufügen"
				
				JButton ArtikelHinzufuegen = new JButton("Artikel hinzufuegen");
				ArtikelHinzufuegen.addActionListener(new ActionListener() {
					
			    // Funktion zum öffnen eines neuen Fensters, um artikel hinzufügen zu können
					
					public void actionPerformed(ActionEvent e) {
						
						ArtikelHinzufuegenMenue = new JFrame();
						ArtikelHinzufuegenMenue.setTitle("Artikel hinzufuegen");
						ArtikelHinzufuegenMenue.setVisible(true);
						ArtikelHinzufuegenMenue.setBounds(970, 150, 328, 299);
						ArtikelHinzufuegenMenue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						ArtikelHinzufuegenMenue.getContentPane().setLayout(null);
						
						JLabel Artikelanlegen = new JLabel("Legen Sie ein neuen Artikel an!");
						Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
						Artikelanlegen.setBounds(56, 11, 197, 31);
						ArtikelHinzufuegenMenue.getContentPane().add(Artikelanlegen);
						
						JLabel Artikelname = new JLabel("Artikelname :");
						 Artikelname.setBounds(37, 64, 96, 14);
						 ArtikelHinzufuegenMenue.getContentPane().add(Artikelname);
						
						textArtikel= new JTextField(null);
						textArtikel.setBounds(37, 89, 96, 20);
						ArtikelHinzufuegenMenue.getContentPane().add(textArtikel);
						textArtikel.setColumns(10);
						
						JLabel lblArtikelnummer = new JLabel("Artikelnummer :");
						lblArtikelnummer.setBounds(37, 120, 96, 14);
						ArtikelHinzufuegenMenue.getContentPane().add(lblArtikelnummer);
						
						textNummer = new JTextField(null);
						textNummer.setColumns(10);
						textNummer.setBounds(37, 145, 37, 20);
						ArtikelHinzufuegenMenue.getContentPane().add(textNummer);
						
						
						
						JLabel Preis = new JLabel("Preis :");
						Preis.setBounds(187, 64, 96, 14);
						ArtikelHinzufuegenMenue.getContentPane().add(Preis);
						
						textPreis = new JTextField(null);
						textPreis.setColumns(10);
						textPreis.setBounds(187, 89, 96, 20);
						ArtikelHinzufuegenMenue.getContentPane().add(textPreis);
						
						
						JLabel Bestand = new JLabel("Bestand");
						Bestand.setBounds(187, 120, 96, 14);
						ArtikelHinzufuegenMenue.getContentPane().add(Bestand);
						
						textBestand = new JTextField(null);
						textBestand.setColumns(10);
						textBestand.setBounds(187, 145, 96, 20);
						ArtikelHinzufuegenMenue.getContentPane().add(textBestand);
						
						
						
						JLabel Mindestbestand = new JLabel("Mindestbestand :");
						Mindestbestand.setBounds(37, 176, 96, 14);
						ArtikelHinzufuegenMenue.getContentPane().add(Mindestbestand);
						
						textMindestbestand = new JTextField(null);
						textMindestbestand.setColumns(10);
						textMindestbestand.setBounds(37, 201, 96, 20);
						ArtikelHinzufuegenMenue.getContentPane().add(textMindestbestand);
						
						falscherArtikel = new JLabel("Bitte füllen Sie alle Felder.");
						falscherArtikel.setBounds(81, 232, 170, 14);
						falscherArtikel.setForeground(Color.BLACK);
						falscherArtikel.setFont(new Font("Tahoma", Font.PLAIN, 13));
						ArtikelHinzufuegenMenue.getContentPane().add(falscherArtikel);
					
						
						JButton Hinzufügen = new JButton("Hinzuf\u00FCgen");
						Hinzufügen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String aName = "";
								String aNummer = "";
								String aPreis = "";
								String aBestand = "";
								String aMBestand = "";
								
								int aNum;
								double aPre; 
								int aBe; 
								int aMb;
								
								
								aName = textArtikel.getText();
								System.out.println(aName);
								
								aNummer = textNummer.getText();
								System.out.println(aNummer);
								aNum = Integer.parseInt(aNummer);
								
								aPreis = textPreis.getText();
								System.out.println(aPreis);
								aPre = Double.parseDouble(aPreis);
								
								aBestand = textBestand.getText();
								System.out.println(aBestand);
								aBe = Integer.parseInt(aBestand);
								
								aMBestand = textMindestbestand.getText();
								System.out.println(aMBestand);
								aMb = Integer.parseInt(aMBestand);
								
								/* fehlermeldung wenn nicht alle Felder befüllt sind
								if(textArtikel.getText().isEmpty()) {
									System.out.println("lol");
								}  */
								
								
								for(Artikel a : lager.gibAlleArtikel()) {
									if(a.getNummer() == aNum) {	
										falscherArtikel.setForeground(Color.RED);
										falscherArtikel.setText("Die ArtikelNr existiert bereits!"); 
										textNummer.setText(null);
									    			    
									    
									} 	
								}
								
								if(!textNummer.getText().isEmpty()) {
									changelog.schreibeLog("Der Artikel - Name: " + aName + " | Nummer: " + aNum + " | Preis: " + aPre + " | Bestand: " + aBe + " wurde erstellt.");
									lager.fuegeArtikelEin(aName, aNum, aPre, aBe, aMb);
									try {
										lager.schreibeArtikel();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
						
									ArtikelHinzufuegenMenue.setVisible(false);
									updateTabelle(lager.gibAlleArtikel());
								}
							
							}
						});
						Hinzufügen.setBounds(177, 189, 104, 32);
						ArtikelHinzufuegenMenue.getContentPane().add(Hinzufügen);
							
						
					}
				});
				ArtikelHinzufuegen.setBounds(486, 11, 153, 23);
				LagerTab.add(ArtikelHinzufuegen);
				
				//erstellt button "artikel löschen" 
				
				JButton ArtikelLoeschen = new JButton("Artikel L\u00F6schen");
				ArtikelLoeschen.addActionListener(new ActionListener() {
					
					// Funktion zum öffnen eines neuen Fensters, um artikel löschen zu können
					
					public void actionPerformed(ActionEvent e) {
						
						ArtikelLoeschenMenue = new JFrame();
						ArtikelLoeschenMenue.setTitle("Loeschen eines Artikels");
						ArtikelLoeschenMenue.setVisible(true);
						ArtikelLoeschenMenue.setBounds(970, 150, 304, 246);
						ArtikelLoeschenMenue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						ArtikelLoeschenMenue.getContentPane().setLayout(null);
						
						JLabel ArtikelLöschen = new JLabel("L\u00F6schen Sie ein Artikel!");
						ArtikelLöschen.setFont(new Font("Tahoma", Font.PLAIN, 14));
						ArtikelLöschen.setBounds(68, 11, 160, 31);
						ArtikelLoeschenMenue.getContentPane().add(ArtikelLöschen);
						
						JLabel ANumNichtvergeben = new JLabel("  ");
						ANumNichtvergeben.setForeground(Color.RED);
						ANumNichtvergeben.setBounds(10, 186, 280, 14);
						ArtikelLoeschenMenue.getContentPane().add(ANumNichtvergeben);
						
						JLabel eingeben = new JLabel("Geben Sie die Artikelnummer des Artikels ein :");
						eingeben.setBounds(10, 68, 282, 14);
						ArtikelLoeschenMenue.getContentPane().add(eingeben);
						
						textArtikelNummer = new JTextField();
						textArtikelNummer.setBounds(107, 93, 54, 20);
						ArtikelLoeschenMenue.getContentPane().add(textArtikelNummer);
						textArtikelNummer.setColumns(10);
						
						JButton Loeschen = new JButton("L\u00F6schen");
						Loeschen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String aNummer = "";
								int aNum;
								
								aNummer = textArtikelNummer.getText();
								System.out.println(aNummer);
								aNum = Integer.parseInt(aNummer);
								
								for(Artikel a : lager.gibAlleArtikel()) {
									if(a.getNummer() == aNum) {	
										lager.loescheArtikel(aNum);
										ArtikelLoeschenMenue.setVisible(false);
										updateTabelle(lager.gibAlleArtikel());
										changelog.schreibeLog("Der Artikel mit der Nummer: " + aNum +" wurde gelöscht.");
										try {
											lager.schreibeArtikel();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
									} else {
										ANumNichtvergeben.setText("Bitte geben Sie eine gültige Artikelnummer ein!");
										textArtikelNummer.setText(null);
									}
								}
								
						
							}
						});
						Loeschen.setBounds(81, 143, 104, 32);
						ArtikelLoeschenMenue.getContentPane().add(Loeschen);
					}
				});
				ArtikelLoeschen.setBounds(330, 11, 126, 23);
				LagerTab.add(ArtikelLoeschen);
				
				
				
				
				// erstellt button "artikel suchen"
				
				JButton ArtikelSuchen = new JButton("Artikel suchen");
				ArtikelSuchen.addActionListener(new ActionListener() {
					
					//Funktion zum öffnen eines neuen Fensters, um artikel suchen zu können
					
					public void actionPerformed(ActionEvent e) {
						
						artikelScreach = new JFrame();
						artikelScreach.setTitle("Artikel suchen");
						artikelScreach.setVisible(true);
						artikelScreach.setBounds(970, 150, 304, 246);
						artikelScreach.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						artikelScreach.getContentPane().setLayout(null);
						
						JLabel Artikelanlegen = new JLabel("Welchen Artikel Suchen Sie?");
						Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
						Artikelanlegen.setBounds(50, 11, 193, 31);
						artikelScreach.getContentPane().add(Artikelanlegen);
						
						JLabel Artikelname = new JLabel("Geben Sie den Artikelname des Artikels ein :");
						Artikelname.setBounds(10, 68, 282, 14);
						artikelScreach.getContentPane().add(Artikelname);
						
						textArtikel2 = new JTextField();
						textArtikel2.setBounds(81, 93, 104, 20);
						artikelScreach.getContentPane().add(textArtikel2);
						textArtikel2.setColumns(10);
						
						JLabel FalscherArtikel = new JLabel("");
						FalscherArtikel.setForeground(Color.RED);
						FalscherArtikel.setBounds(26, 186, 240, 14);
						artikelScreach.getContentPane().add(FalscherArtikel);
						
						JButton Suchen = new JButton("Suchen");
						Suchen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String aName = "";
								
								aName = textArtikel2.getText();
								
								for(Artikel a : lager.gibAlleArtikel()) {
									if(a.getName().equals(aName)) {	
										updateTabelle(lager.sucheNachName(aName));
										artikelScreach.setVisible(false);
										changelog.schreibeLog("Der Artikel mit dem Namen: " + aName +" wurde gesucht.");
										break;
									} else {
										FalscherArtikel.setText("Ungültiger Name!");
										textArtikel2.setText(null);
									}
								}
								
								
							}
						});
						Suchen.setBounds(81, 143, 104, 32);
						artikelScreach.getContentPane().add(Suchen);
						
						
						
						
					}
				});
				ArtikelSuchen.setBounds(194, 11, 126, 23);
				LagerTab.add(ArtikelSuchen);
				
				
				
				// erstellen button" Artikel anzeigen"
				
				JButton Anzeigen = new JButton("Artikel anzeigen");
				Anzeigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						updateTabelle(lager.gibAlleArtikel());
						
					}
				});
				Anzeigen.setBounds(10, 11, 153, 23);
				LagerTab.add(Anzeigen);
				
				
				
				
				
				//erstellt button "Artikel sortieren Nummer"
				
				JButton ArtikelSoNum = new JButton("Artikel Sortieren Nummer");
				ArtikelSoNum.addActionListener(new ActionListener() {
					
					//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
					public void actionPerformed(ActionEvent e) {
						updateTabelle(sortNummerArtikelliste(lager.gibAlleArtikel()));
					}
				});
				ArtikelSoNum.setBounds(0, 419, 195, 23);
				LagerTab.add(ArtikelSoNum);
				
				
				
				
				// erstellt button " artikeln sortieren Namen"
				
				JButton ArtikelSoNam = new JButton("Artikel Sortieren Namen");
				ArtikelSoNam.addActionListener(new ActionListener() {
					
					//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
					
					public void actionPerformed(ActionEvent e) {
						
						updateTabelle(sortNameArtikelliste(lager.gibAlleArtikel()));
					
					}
				});
				ArtikelSoNam.setBounds(0, 373, 196, 23);
				LagerTab.add(ArtikelSoNam);
				
				
				// erstell layout für die bestandserhöhung 
				
				JScrollPane Layout1 = new JScrollPane();
				Layout1.setBounds(10, 147, 170, 202);
				LagerTab.add(Layout1);
				
				// erstell "Raster im layout, um buttons etc einfügen zu können
				
				JPanel Raster = new JPanel();
				Layout1.setViewportView(Raster);
				Raster.setLayout(null);  
				
                // erstellt Label für neuer bestand
				
				JLabel NeuerBestand = new JLabel("Neuer Bestand :");
				NeuerBestand.setBounds(37, 72, 113, 14);
				Raster.add(NeuerBestand);
				
				//erstellt eine Texteingabe zum schreiben für bestand
				
				textBestand = new JTextField();
				textBestand.setBounds(37, 92, 96, 20);
				Raster.add(textBestand);
				textBestand.setColumns(10);
				
				// erstellt label für Artikelname
				
				JLabel lblNewLabel_1_1 = new JLabel("ArtikelNr :");
				lblNewLabel_1_1.setBounds(37, 16, 113, 14);
				Raster.add(lblNewLabel_1_1);
				
				//erstellt eine Texteingabe zum schreiben für Artikelname
				
				textArtikel = new JTextField();
				textArtikel.setColumns(10);
				textArtikel.setBounds(37, 41, 96, 20);
				Raster.add(textArtikel);
				
				JLabel FalscheArtNr = new JLabel(" ");
				FalscheArtNr.setForeground(Color.RED);
				FalscheArtNr.setBounds(7, 168, 170, 14);
				Raster.add(FalscheArtNr);
				
				System.out.println(textArtikel.getText());
				// erstellt button " bestand aendern"
				
				JButton Bestandaendern = new JButton("Bestand \u00E4ndern");
				Bestandaendern.addActionListener(new ActionListener() {
					
				// erstellt funktion zum bestand ändern 	
					
					public void actionPerformed(ActionEvent e) {
						
						String aNummer = "";
						String aBestand ="";
						int aBe;
						int aNum;
						System.out.println(textArtikel.getText());
						aNummer = textArtikel.getText();
						System.out.println(textArtikel.getText());
						aNum = Integer.parseInt(aNummer);
						aBestand = textBestand.getText();
						aBe = Integer.parseInt(aBestand);
						
						for(Artikel a : lager.gibAlleArtikel()) {
							if(a.getNummer() == aNum) {	
								a.setBestand(aBe);
								changelog.schreibeLog("Bei dem Artikel mit der Nummer: " + aNum +" wurde der Bestand auf: "+aBe +" gesetzt.");
								FalscheArtNr.setText(null);
								textArtikel.setText(null);
								textBestand.setText(null);
								updateTabelle(lager.gibAlleArtikel());
								FalscheArtNr.setForeground(Color.black);
								FalscheArtNr.setText("Bestand geändert!");
								try {
									lager.schreibeArtikel();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								break;
							} else {
								FalscheArtNr.setForeground(Color.RED);
								FalscheArtNr.setText("Fehlerhafte Artikelnummer!");
								textArtikel.setText(null);
								textBestand.setText(null);
							}
						}
						
					}
				});
				Bestandaendern.setBounds(10, 134, 152, 23);
				Raster.add(Bestandaendern);
				
				
				
				
				/*-------------------------------------------------------------------------------------*/
				
				JPanel panel_1 = new JPanel();
				Maintab.addTab("Warenkorb", null, panel_1, null);
				panel_1.setLayout(null);
				
				/*-------------------------------------------------------------------------------------*/
				
				JPanel panel_2 = new JPanel();
				Maintab.addTab("Changelog", null, panel_2, null);
				panel_2.setLayout(null);
				
				/*-------------------------------------------------------------------------------------*/
				
				
				JPanel 	Benutzermanagement = new JPanel();
				Maintab.addTab("Benutzermanagement", null, Benutzermanagement, null);
				Benutzermanagement.setLayout(null);
				
				// ScrollPane für Tabelle erstellt
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(38, 50, 414, 165);
				Benutzermanagement.add(scrollPane);
				
				// erstellt tabelle für Kunde
				
				tabelle2 = new JTable();
				tabelle2.setModel(new DefaultTableModel(
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
				tabelle2.getColumnModel().getColumn(0).setPreferredWidth(62);
				tabelle2.getColumnModel().getColumn(1).setPreferredWidth(63);
				tabelle2.getColumnModel().getColumn(2).setPreferredWidth(58);
				tabelle2.getColumnModel().getColumn(3).setPreferredWidth(63);
				tabelle2.getColumnModel().getColumn(4).setPreferredWidth(57);
				tabelle2.getColumnModel().getColumn(5).setPreferredWidth(35);
				tabelle2.getColumnModel().getColumn(6).setPreferredWidth(52);
				scrollPane.setViewportView(tabelle2);
				
				
				//befüllen der Tabelle
				updateBenutzerKundenTabelle(verkaufsstand.gibAlleKunden());
				
				/*-----------------------------------------------------*/
				
				// scrollPane für die 2. tabelle erstellt
				
				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setBounds(38, 274, 414, 175);
				Benutzermanagement.add(scrollPane1);
				
				// erstellt tabelle für Mitarbeiter
				
				tabelle3 = new JTable();
				tabelle3.setModel(new DefaultTableModel(
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
				tabelle3.getColumnModel().getColumn(1).setPreferredWidth(61);
				tabelle3.getColumnModel().getColumn(2).setPreferredWidth(58);
				tabelle3.getColumnModel().getColumn(3).setPreferredWidth(64);
				tabelle3.getColumnModel().getColumn(4).setPreferredWidth(57);
				tabelle3.getColumnModel().getColumn(5).setPreferredWidth(34);
				tabelle3.getColumnModel().getColumn(6).setPreferredWidth(51);
				scrollPane1.setViewportView(tabelle3);
				
				//befüllen der Tabelle
				updateBenutzerMitarbeiterTabelle(buero.gibAlleMitarbeiter());
				
				
				// erstellt button mitarbeiter suchen 
				
				JButton mitarbeiterSuchen = new JButton("Mitarbeiter suchen");
				mitarbeiterSuchen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						
						mitarbeiterScreach = new JFrame();
						mitarbeiterScreach.setTitle("Mitarbeiter suchen");
						mitarbeiterScreach.setVisible(true);
						mitarbeiterScreach.setBounds(970, 150, 304, 246);
						mitarbeiterScreach.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						mitarbeiterScreach.getContentPane().setLayout(null);
						
						JLabel mitarbeitersuche = new JLabel("Welchen Mitarbeiter suchen Sie?");
						mitarbeitersuche.setFont(new Font("Tahoma", Font.PLAIN, 14));
						mitarbeitersuche.setBounds(50, 11, 193, 31);
						mitarbeiterScreach.getContentPane().add(mitarbeitersuche);
						
						JLabel mitarbeiterNr = new JLabel("Geben Sie die MitarbeiterNr ein :");
						mitarbeiterNr.setBounds(50, 68, 282, 14);
						mitarbeiterScreach.getContentPane().add(mitarbeiterNr);
						
						textMitarbeiterNr = new JTextField();
						textMitarbeiterNr.setBounds(81, 93, 104, 20);
						mitarbeiterScreach.getContentPane().add(textMitarbeiterNr);
						textMitarbeiterNr.setColumns(10);
						
						JLabel FalscherArtikel = new JLabel("");
						FalscherArtikel.setForeground(Color.RED);
						FalscherArtikel.setBounds(26, 186, 240, 14);
						mitarbeiterScreach.getContentPane().add(FalscherArtikel);
						
						JButton suchen = new JButton("Suchen");
						suchen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String mNummer = "";
								int mNum;
								mNummer = textMitarbeiterNr.getText();
								mNum = Integer.parseInt(mNummer);
								
								for(Mitarbeiter m : buero.gibAlleMitarbeiter()) {
									if(m.getMitarbeiterNr() == mNum) {	
										updateBenutzerMitarbeiterTabelle(buero.sucheNachNummer(mNum));
										mitarbeiterScreach.setVisible(false);
										changelog.schreibeLog("Der Artikel mit dem Namen: " + mNum +" wurde gesucht.");
										break;
									} else {
										FalscherArtikel.setText("Ungültige Nr!");
										textArtikel.setText(null);
									}
								}
								
								
							}
						});
						suchen.setBounds(81, 143, 104, 32);
						mitarbeiterScreach.getContentPane().add(suchen);
						
					}
				});
				mitarbeiterSuchen.setBounds(484, 329, 155, 23);
				Benutzermanagement.add(mitarbeiterSuchen);
				
				
				
				// erstellt button mitarbeiter löschen 
				
				JButton mitarbeiterLoeschen = new JButton("Mitarbeiter l\u00F6schen ");
				mitarbeiterLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						mitaLoeschen = new JFrame();
						mitaLoeschen.setTitle("Loeschen eines Mitarbeiter");
						mitaLoeschen.setVisible(true);
						mitaLoeschen.setBounds(970, 150, 304, 246);
						mitaLoeschen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						mitaLoeschen.getContentPane().setLayout(null);
						
						JLabel mitaLoesch = new JLabel("L\u00F6schen Sie ein Mitarbeiter!");
						mitaLoesch.setFont(new Font("Tahoma", Font.PLAIN, 14));
						mitaLoesch.setBounds(68, 11, 160, 31);
						mitaLoeschen.getContentPane().add(mitaLoesch);
						
						JLabel mitaNrNichtvergeben = new JLabel("  ");
						mitaNrNichtvergeben.setForeground(Color.RED);
						mitaNrNichtvergeben.setBounds(10, 186, 280, 14);
						mitaLoeschen.getContentPane().add(mitaNrNichtvergeben);
						
						JLabel eingeben = new JLabel("Geben Sie die MitarbeiterNr des Mitarbeiter ein :");
						eingeben.setBounds(10, 68, 282, 14);
						mitaLoeschen.getContentPane().add(eingeben);
						
						textMitarbeiterNummer = new JTextField();
						textMitarbeiterNummer.setBounds(107, 93, 54, 20);
						mitaLoeschen.getContentPane().add(textMitarbeiterNummer);
						textMitarbeiterNummer.setColumns(10);
						
						JButton Loeschen = new JButton("L\u00F6schen");
						Loeschen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String mNummer = "";
								int mNum;
								
								mNummer = textMitarbeiterNummer.getText();
								System.out.println(mNummer);
								mNum = Integer.parseInt(mNummer);
								
								for(Mitarbeiter m : buero.gibAlleMitarbeiter()) {
									if(m.getMitarbeiterNr() == mNum) {	
										buero.loescheMitarbeiter(mNum);
										mitaLoeschen.setVisible(false);
										updateBenutzerMitarbeiterTabelle(buero.gibAlleMitarbeiter());
										changelog.schreibeLog("Der Mitarbeiter mit der Nummer: " + mNum +" wurde gelöscht.");
										try {
											buero.schreibeMitarbeiter();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
									} else {
										mitaNrNichtvergeben.setText("Bitte geben Sie eine gültige Mitarbeiternummer ein!");
										textMitarbeiterNummer.setText(null);
									}
								}
								
						
							}
						});
						Loeschen.setBounds(81, 143, 104, 32);
						mitaLoeschen.getContentPane().add(Loeschen);
						
					}
				});
				mitarbeiterLoeschen.setBounds(484, 380, 155, 23);
				Benutzermanagement.add(mitarbeiterLoeschen);
				
				
				
				// erstellt button mitarbeiter anlegen
				
				JButton mitarbeiterAnlegen = new JButton("Mitarbeiter anlegen");
				mitarbeiterAnlegen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						shopMitarbeiterRegistrierung(true);
						updateBenutzerMitarbeiterTabelle(buero.gibAlleMitarbeiter());
					}
				});
				mitarbeiterAnlegen.setBounds(484, 426, 155, 23);
				Benutzermanagement.add(mitarbeiterAnlegen);
				
				
				
				
				//erstellt button kunde suchen
				
				JButton kundeSuchen = new JButton("Kunde suchen");
				kundeSuchen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						artikelScreach1 = new JFrame();
						artikelScreach1.setTitle("Kunden suchen");
						artikelScreach1.setVisible(true);
						artikelScreach1.setBounds(970, 150, 304, 246);
						artikelScreach1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						artikelScreach1.getContentPane().setLayout(null);
						
						JLabel Artikelanlegen = new JLabel("Welchen Kunden suchen Sie?");
						Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
						Artikelanlegen.setBounds(50, 11, 193, 31);
						artikelScreach1.getContentPane().add(Artikelanlegen);
						
						JLabel KundenNr = new JLabel("Geben Sie die KundenNr ein :");
						KundenNr.setBounds(50, 68, 282, 14);
						artikelScreach1.getContentPane().add(KundenNr);
						
						textKundeNr = new JTextField();
						textKundeNr.setBounds(81, 93, 104, 20);
						artikelScreach1.getContentPane().add(textKundeNr);
						textKundeNr.setColumns(10);
						
						JLabel FalscherArtikel = new JLabel("");
						FalscherArtikel.setForeground(Color.RED);
						FalscherArtikel.setBounds(26, 186, 240, 14);
						artikelScreach1.getContentPane().add(FalscherArtikel);
						
						JButton suchen = new JButton("Suchen");
						suchen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String kNummer = "";
								int kNum;
								kNummer = textKundeNr.getText();
								kNum = Integer.parseInt(kNummer);
								
								for(Kunde k : verkaufsstand.gibAlleKunden()) {
									if(k.getKundenNr() == kNum) {	
										updateBenutzerKundenTabelle(verkaufsstand.sucheNachNummer(kNum));
										artikelScreach1.setVisible(false);
										changelog.schreibeLog("Der Kunde mit der Nummer: " + kNum +" wurde gesucht.");
										break;
									} else {
										FalscherArtikel.setText("Ungültige Nr!");
										textKundeNr.setText(null);
									}
								}
								
								
							}
						});
						suchen.setBounds(81, 143, 104, 32);
						artikelScreach1.getContentPane().add(suchen);	
					}
				});
				kundeSuchen.setBounds(484, 53, 155, 23);
				Benutzermanagement.add(kundeSuchen);
				
				
				
				
				// erstellt button kunde löschen
				
				JButton kundeLoeschen = new JButton("Kunde l\u00F6schen");
				kundeLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						kundLoeschen = new JFrame();
						kundLoeschen.setTitle("Loeschen eines Kunden");
						kundLoeschen.setVisible(true);
						kundLoeschen.setBounds(970, 150, 304, 246);
						kundLoeschen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						kundLoeschen.getContentPane().setLayout(null);
						
						JLabel kundeLoeschArt = new JLabel("L\u00F6schen Sie ein Kunde!");
						kundeLoeschArt.setFont(new Font("Tahoma", Font.PLAIN, 14));
						kundeLoeschArt.setBounds(68, 11, 160, 31);
						kundLoeschen.getContentPane().add(kundeLoeschArt);
						
						JLabel kundNrNichtvergeben = new JLabel("  ");
						kundNrNichtvergeben.setForeground(Color.RED);
						kundNrNichtvergeben.setBounds(10, 186, 280, 14);
						kundLoeschen.getContentPane().add(kundNrNichtvergeben);
						
						JLabel eingeben = new JLabel("Geben Sie die KundenNr des Kunden ein :");
						eingeben.setBounds(10, 68, 282, 14);
						kundLoeschen.getContentPane().add(eingeben);
						
						textKundenNummer = new JTextField();
						textKundenNummer.setBounds(107, 93, 54, 20);
						kundLoeschen.getContentPane().add(textKundenNummer);
						textKundenNummer.setColumns(10);
						
						JButton Loeschen = new JButton("L\u00F6schen");
						Loeschen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String kNummer = "";
								int kNum;
								
								kNummer = textKundenNummer.getText();
								System.out.println(kNummer);
								kNum = Integer.parseInt(kNummer);
								
								for(Kunde k : verkaufsstand.gibAlleKunden()) {
									if(k.getKundenNr() == kNum) {	
										verkaufsstand.loescheKunde(kNum);
										kundLoeschen.setVisible(false);
										updateBenutzerKundenTabelle(verkaufsstand.gibAlleKunden());
										changelog.schreibeLog("Der Kunde mit der Nummer: " + kNum +" wurde gelöscht.");
										try {
											verkaufsstand.schreibeKunden();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
									} else {
										kundNrNichtvergeben.setText("Bitte geben Sie eine gültige Kundennummer ein!");
										textKundenNummer.setText(null);
									}
								}
								
						
							}
						});
						Loeschen.setBounds(81, 143, 104, 32);
						kundLoeschen.getContentPane().add(Loeschen);
					
					}
				});
				kundeLoeschen.setBounds(484, 101, 155, 23);
				Benutzermanagement.add(kundeLoeschen);
				
				
				
				
				// erstellt button kunden anlegen 
				
				JButton kundeAnlegen = new JButton("Kunde anlegen");
				kundeAnlegen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						shopKundeRegistrierung(true);
						System.out.println("kommt das?");
						updateBenutzerKundenTabelle(verkaufsstand.gibAlleKunden());
						
					}
				});
				 kundeAnlegen.setBounds(484, 147, 155, 23);
				Benutzermanagement.add( kundeAnlegen);
				
				
				
				
				// erstellt button listen aktualisieren 
				
				JButton listenAktualisieren = new JButton("Listen aktualisieren");
				listenAktualisieren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						updateBenutzerKundenTabelle(verkaufsstand.gibAlleKunden());
						updateBenutzerMitarbeiterTabelle(buero.gibAlleMitarbeiter());
					}
				});
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
				
				
				
				
				// erstellt Ausloggen button und schickt uns zurück zum Startfenster
				
				JButton Ausloggen = new JButton("Ausloggen");
				Ausloggen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						gibMenueAus();
						mitarbeiterMenue.setVisible(false);
						
					}
				});
				Ausloggen.setBounds(549, 506, 119, 23);
				mitarbeiterMenue.getContentPane().add(Ausloggen);
				
				
				
				
				JLabel Creater = new JLabel("E-Shop creater : Mario Schulz, Bernd Henke, Dyar lol");
				Creater.setBounds(40, 510, 442, 14);
				mitarbeiterMenue.getContentPane().add(Creater);
			}		
	/*	
		String input = "";
		String aName = "";
		String aNummer = "";
		String aPreis = "";
		String aBestand = "";
		String aMindestbestand = "";
		String mNummer = "";
		String kNummer = "";
		String aAnzahl = "";
		int aAnz;
		int kNum;
		int mNum;
		int aMin;
		int aBes;
		int aNum;
		double aPre;
		

				
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("1. Alle Artikel ausgeben: '1': ");
		System.out.println("2. Einen Artikel löschen: '2': ");
		System.out.println("3. Einen Artikel einfügen: '3': ");
		System.out.println("4. Einen Artikel suchen: '4': ");
		System.out.println("5. Artikel nach Namen Sortieren: '5': ");
		System.out.println("6. Artikel nach Nummer Sortieren: '6': ");
		System.out.println("7. Artikelliste sichern: '7': ");
		System.out.println("8. Artikel zum Warenkorb hinzufügen: '8': ");
		System.out.println("9. Artikel aus dem Warenkorb entfernen: '9': ");
		System.out.println("10. Warenkorb leeren: '10': ");
		System.out.println("11. Warenkorb anzeigen: '11': ");
		System.out.println("12. Warenkorb kaufen: '12': ");
		System.out.println("13. Changelog anzeigen: '13': ");
		System.out.println("14. Neuen Mitarbeiter anlegen: '14': ");
		System.out.println("15. Alle Mitarbeiter anzeigen: '15': ");
		System.out.println("16. Einen Mitarbeiter löschen: '16': ");
		System.out.println("17. Einen Mitarbeiter suchen: '17': ");
		System.out.println("18. Einen Kunden anlegen: '18': ");
		System.out.println("19. Einen Kunden löschen: '19': ");
		System.out.println("20. Alle Kunden anzeigen: '20': ");
		System.out.println("21. Einen Kunden suchen: '21': ");
		System.out.println("22. Kundenliste sichern: '22': ");
		System.out.println("23. Mitarbeiterliste sichern: '23': ");
		System.out.println("24. Abmelden: '24': ");
		System.out.println("25. ChangeLog ausgeben: '25': ");
		System.out.println("26. ChangeLog speichern: '26': ");
		System.out.println("-----------------------------------------------");
		System.out.println("");
		System.out.print(">>");
		
		input = liesEingabe();
		switch(input) {
		case "1": //artikel anzeigen
			System.out.println("");
			gibArtikellisteAus(aliste);
			System.out.println("");
			changelog.schreibeLog("Alle Artikel wurden Angezeigt");
			mitarbeiterMenue();
			break;
		case "2": //artikel löschen
			System.out.println("");
			System.out.println("Bitte geben Sie die Artikelnummer des zu löschenden Artikels ein: ");
			System.out.println("");
			System.out.print(">>");
			aNummer = liesEingabe();
			aNum = Integer.parseInt(aNummer);
			lager.loescheArtikel(aNum);
			System.out.println("");
			System.out.println("Der Artikel wurde erfolgreich gelöscht.");
			changelog.schreibeLog("Der Artikel mit der Artikelnummer " + aNum + " wurde gelöscht");
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "3": //Artikel einfgügen
			System.out.println("");
			System.out.println("Bitte geben Sie den Artikelnamen an: ");
			System.out.println("");
			System.out.print(">>");
			aName = liesEingabe();
			
			System.out.println("");
			System.out.println("Bitte geben Sie die Artikelnummer an: ");
			System.out.println("");
			System.out.print(">>");
			aNummer = liesEingabe();
			aNum = Integer.parseInt(aNummer);
			
			System.out.println("");
			System.out.println("Bitte geben Sie den Artikelpreis an: ");
			System.out.println("");
			System.out.print(">>");
			aPreis = liesEingabe();
			aPre = Double.parseDouble(aPreis);
			
			System.out.println("");
			System.out.println("Bitte geben Sie den Artikelbestand an: ");
			System.out.println("");
			System.out.print(">>");
			aBestand = liesEingabe();
			aBes = Integer.parseInt(aBestand);
			
			System.out.println("");
			System.out.println("Bitte geben Sie den Artikelmidestbestand an: ");
			System.out.println("");
			System.out.print(">>");
			aMindestbestand = liesEingabe();
			aMin = Integer.parseInt(aMindestbestand);
			
			lager.fuegeArtikelEin(aName, aNum, aPre, aBes, aMin);
			System.out.println("");
			System.out.println("Der Artikel wurde erfolgreich angelegt.");
			changelog.schreibeLog("Der Artikel - Name: " + aName + " | Nummer: " + aNum + " | Preis: " + aPre + " | Bestand: " + aBes + " wurde erstellt.");
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "4": //Artikel suchen
			System.out.println("");
			System.out.println("Artikelname:    ");
			aName = liesEingabe();
			aliste = lager.sucheNachName(aName);
			gibArtikellisteAus(aliste);
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "5": //Artikel nach namen sortieren
			sortNameArtikelliste(aliste);
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "6": //Artikel nach Nummer sortieren
			sortNummerArtikelliste(aliste);
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "7": //Artikelliste sichern
			try {
				lager.schreibeArtikel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "8": //artikel den warenkorb hinzufügen
			System.out.println("");
			System.out.println("Bitte geben Sie die Artikelnummer des Artikels an: ");
			System.out.println("");
			System.out.print(">>");
			aNummer = liesEingabe();
			aNum = Integer.parseInt(aNummer);
			
			System.out.println("");
			System.out.println("Bitte geben Sie die Anzahl der Artikel an: ");
			System.out.println("");
			System.out.print(">>");
			aAnzahl = liesEingabe();
			aAnz = Integer.parseInt(aAnzahl);
			
			System.out.println("");
			warenkorb.addArtikel(aNum, aAnz);
			System.out.println("Der Artikel wurde dem Warenkorb hinzugefügt.");
			System.out.println("");
			warenkorb.anzeigen();
			System.out.println("");
			mitarbeiterMenue();
			break; 
		case "9": //Artikel ausn Warenkorb nehmen
			System.out.println("");
			System.out.println("Bitte geben Sie die Artikelnummer des Artikels an: ");
			System.out.println("");
			System.out.print(">>");
			aNummer = liesEingabe();
			aNum = Integer.parseInt(aNummer);
			
			System.out.println("");
			System.out.println("Bitte geben Sie die Anzahl der Artikel an: ");
			System.out.println("");
			System.out.print(">>");
			aAnzahl = liesEingabe();
			aAnz = Integer.parseInt(aAnzahl);
			
			System.out.println("");
			warenkorb.delArtikel(aNum, aAnz);
			System.out.println("Der Artikel wurde aus dem Warenkorb entfernt.");
			System.out.println("");
			warenkorb.anzeigen();
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "10": // warenkorb leeren
			System.out.println("");
			System.out.println("Der Warenkorb wurde geleert.");
			System.out.println("");
			warenkorb.leeren();
			mitarbeiterMenue();
			break;
		case "11": //Warenkorb anzeigen
			System.out.println("");
			warenkorb.anzeigen();
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "12": //Warenkorb kaufen
			System.out.println("");
			warenkorb.kaufen();
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "13": // Changelog anzeigen
			break;
		case "14": //neuen mitarbeiter anlegen
			System.out.println("");
			shopMitarbeiterRegistrierung();
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "15": //alle Mitarbeiter anzeigen
			System.out.println("");
			gibMitarbeiterlisteAus(mliste);
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "16": //Mitarbeiter löschen
			System.out.println("");
			System.out.println("Bitte geben Sie die Mitarbeiternummer des zu löschenden Mitarbeiters ein: ");
			System.out.println("");
			System.out.print(">>");
			mNummer = liesEingabe();
			mNum = Integer.parseInt(mNummer);
			buero.loescheMitarbeiter(mNum);
			System.out.println("");
			System.out.println("Der Mitarbeiter wurde gelöscht.");
			changelog.schreibeLog("Der Mitarbeiter mit der Mitarbeiternummer " + mNum + " wurde gelöscht");
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "17": //Mitarbeiter suchen
			System.out.println("");
			System.out.println("Mitarbeitername:    ");
			mNummer = liesEingabe();
			mNum = Integer.parseInt(mNummer);
			mliste = buero.sucheNachNummer(mNum);
			gibMitarbeiterlisteAus(mliste);
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "18": //neuen Kunden erstellen
			System.out.println("");
			shopKundeRegistrierung();
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "19": //Kunden löschen
			System.out.println("");
			System.out.println("Bitte geben sie die Kundennummer des zu löschenden Kundens ein: ");
			System.out.println("");
			System.out.print(">>");
			kNummer = liesEingabe();
			kNum = Integer.parseInt(kNummer);
			verkaufsstand.loescheKunde(kNum);
			System.out.println("");
			System.out.println("Der Kunde wurde erfolgreich gelöscht.");
			changelog.schreibeLog("Der Kunde mit der Kundennummer " + kNum + " wurde gelöscht");
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "20": //Alle Kunden anzeigen
			System.out.println("");
			gibKundenlisteAus(kliste);
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "21": //Kunden suchen
			System.out.println("");
			System.out.println("Kundennummer:    ");
			kNummer = liesEingabe();
			kNum = Integer.parseInt(kNummer);
			kliste = verkaufsstand.sucheNachNummer(kNum);
			gibMitarbeiterlisteAus(mliste);
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "22": //Kundenliste sichern
			try {
				verkaufsstand.schreibeKunden();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
			System.out.println("Die Kundenliste wurde gesichert.");
			changelog.schreibeLog("Die Kundenliste wurde gesichert");
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "23": //Mitarbeiterliste sichern
			try {
				buero.schreibeMitarbeiter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
			System.out.println("Die Mitarbeiterliste wurde gesichert.");
			changelog.schreibeLog("Die Mitarbeiterliste wurde gesichert");
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "24": //logout
			System.out.println("");
			changelog.schreibeLog("Der Benutzer hat sich abgemeldet");
			System.out.println("Sie werden jetzt Abgemeldet...");
			System.out.println("");
			shopAnmeldung();
			break;
		case "25": //changelog ausgeben
			System.out.println("");
			gibLogAus();
			System.out.println("");
			changelog.schreibeLog("Der Changelog wurde angezeigt...");
			mitarbeiterMenue();
			break;
		case "26": //changelog speichern
			System.out.println("");
			try {
				logmanager.schreibeDaten("Log");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
			changelog.schreibeLog("Der Changelog wurde gespeichert...");
			mitarbeiterMenue();
			break;
		default:
			System.out.println("");
			changelog.schreibeLog("Fehlerhafte eingabe im Mitarbeiter-Menue");
			System.out.println("Fehlerhafte eingabe, bitte versuchen Sie es Erneut...");
			System.out.println("");
			mitarbeiterMenue();
		}
		    */
	
	/*--------------------------------------------------------------------------------*/
	
	
	/**
	 *  Verwendet von: shopAnmeldungKunde
	 *  Beschriebung: erzeugt die GUI für das KundenMenue. Hier sind auch alle funktionisaufrufe die in der GUI stattfinden.
	 */
	public void kundenMenue() {
		
		
		kundenMenue = new JFrame();
		kundenMenue.setVisible(true);
		kundenMenue.setTitle("Menü für Kunden");
		kundenMenue.setBounds(300, 150, 680, 564);
		kundenMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kundenMenue.getContentPane().setLayout(null);
		
		// main tab 
		
		JTabbedPane Maintab = new JTabbedPane(JTabbedPane.TOP);
		Maintab.setBounds(0, 0, 668, 507);
		kundenMenue.getContentPane().add(Maintab);
		
		/*-------------------------------------------------------------------------------------*/
		
		 // tab sortiment erstellt
		
		JPanel LagerTab = new JPanel();
		Maintab.addTab("Sortiment", null, LagerTab, null);
		LagerTab.setLayout(null);
		
		// erstellt das Layout, wo die Tabelle entsteht
		
		JScrollPane Layout = new JScrollPane();
		Layout.setBounds(320, 58, 319, 410);
		LagerTab.add(Layout);
		
		// erstellt die Tabelle
		tabelle = new JTable();
		tabelle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Nummer", "Preis","Auf Lager"
			}
		) {
			// die Klassen mit jeweils den Parametern
			
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Double.class, Integer.class
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
		tabelle.getColumnModel().getColumn(0).setPreferredWidth(45);
		tabelle.getColumnModel().getColumn(1).setPreferredWidth(55);
		
		Layout.setViewportView(tabelle);
		
		//tabelle befüllen
		updateKundenTabelle(lager.gibAlleArtikel());
		
		// erstellt button "artikel suchen"
		
		JButton ArtikelSuchen = new JButton("Artikel suchen");
		ArtikelSuchen.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel zu suchen
			
			public void actionPerformed(ActionEvent e) {
				
				artikelScreach = new JFrame();
				artikelScreach.setTitle("Artikel suchen");
				artikelScreach.setVisible(true);
				artikelScreach.setBounds(970, 150, 304, 246);
				artikelScreach.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				artikelScreach.getContentPane().setLayout(null);
				
				JLabel Artikelanlegen = new JLabel("Welchen Artikel Suchen Sie?");
				Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
				Artikelanlegen.setBounds(50, 11, 193, 31);
				artikelScreach.getContentPane().add(Artikelanlegen);
				
				JLabel Artikelname = new JLabel("Geben Sie den Artikelname des Artikels ein :");
				Artikelname.setBounds(10, 68, 282, 14);
				artikelScreach.getContentPane().add(Artikelname);
				
				textArtikel = new JTextField();
				textArtikel.setBounds(81, 93, 104, 20);
				artikelScreach.getContentPane().add(textArtikel);
				textArtikel.setColumns(10);
				
				JLabel FalscherArtikel = new JLabel("");
				FalscherArtikel.setForeground(Color.RED);
				FalscherArtikel.setBounds(26, 186, 240, 14);
				artikelScreach.getContentPane().add(FalscherArtikel);
				
				JButton Suchen = new JButton("Suchen");
				Suchen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String aName = "";
						
						aName = textArtikel.getText();
						
						for(Artikel a : aliste) {
							if(a.getName().equals(aName)) {	
								updateTabelle(lager.sucheNachName(aName));
								artikelScreach.setVisible(false);
								changelog.schreibeLog("Der Artikel mit dem Namen: " + aName +" wurde gesucht.");
							} else {
								FalscherArtikel.setText("Bitte geben Sie ein gültigen Artikelnamen an!");
								textArtikel.setText(null);
							}
						}
						
						updateTabelle(lager.sucheNachName(aName));
						artikelScreach.setVisible(false);
					}
				});
				Suchen.setBounds(81, 143, 104, 32);
				artikelScreach.getContentPane().add(Suchen);
				
				
				
				
			}
		
			
		});
		ArtikelSuchen.setBounds(513, 11, 126, 23);
		LagerTab.add(ArtikelSuchen);
		
		
		
		//erstellt button "Artikel sortieren Nummer"
		
		JButton ArtikelSoNum = new JButton("Artikel Sortieren Nummer");
		ArtikelSoNum.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
			public void actionPerformed(ActionEvent e) {
				updateKundenTabelle(sortNummerArtikelliste(lager.gibAlleArtikel()));
			}
		});
		ArtikelSoNum.setBounds(52, 417, 195, 23);
		LagerTab.add(ArtikelSoNum);
		
		
		
		// erstellt button " artikeln sortieren Namen"
		
		JButton ArtikelSoNam = new JButton("Artikel Sortieren Namen");
		ArtikelSoNam.addActionListener(new ActionListener() {
			
			//Funktion zum öffnen eines neuen Fensters, um artikel zu sortieren zu können
			
			public void actionPerformed(ActionEvent e) {
				updateKundenTabelle(sortNameArtikelliste(lager.gibAlleArtikel()));
			}
		});
		ArtikelSoNam.setBounds(51, 372, 196, 23);
		LagerTab.add(ArtikelSoNam);
		
		// erstellt button " Artikel anzeigen" 
		
		JButton btnArtikelAnzeigen = new JButton("Artikel anzeigen");
		btnArtikelAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateKundenTabelle(lager.gibAlleArtikel());
			}
		});
		btnArtikelAnzeigen.setBounds(319, 11, 153, 23);
		LagerTab.add(btnArtikelAnzeigen);
		
		// erstell layout um Artikel hinzufügen (Warenkorb) 
		
		JScrollPane Layout1 = new JScrollPane();
		Layout1.setBounds(10, 58, 249, 291);
		LagerTab.add(Layout1);
		
		// erstell "Raster im layout, um buttons etc einfügen zu können
		
		JPanel Raster = new JPanel();
		Layout1.setViewportView(Raster);
		Raster.setLayout(null);  
		
		JLabel FalscherArt = new JLabel("  ");
		FalscherArt.setBounds(65, 263, 170, 14);
		Raster.add(FalscherArt);
		
		

		
		// erstellt button " artikel hinzufügen"
		
		JButton ArtikelHinzufügen = new JButton("Artikel hinzuf\u00FCgen");
		ArtikelHinzufügen.addActionListener(new ActionListener() {
			
		// erstellt eine funktion um ware im warenkorb hinzuzufügen 
			
			public void actionPerformed(ActionEvent e) {
				
				String aNummer = "";
				int aNum;
				aNummer = textArtikelNr.getText();
				aNum = Integer.parseInt(aNummer);
				
				String aAnzahl ="";
				int aAnz;
				aAnzahl = textAnzahl.getText();
				aAnz = Integer.parseInt(aAnzahl);
				
				for(Artikel a : lager.gibAlleArtikel()) {
					System.out.println(a.getNummer()==aNum && aAnz <= a.getBestand());
					System.out.println(!( a.getNummer() == aNum));
					System.out.println( a.getBestand() <= aAnz);
					if(a.getNummer()==aNum && aAnz <= a.getBestand()) {	
						warenkorb.addArtikel(aNum, aAnz);
						changelog.schreibeLog("Der Artikel mit der Nummer: " + aNum +" wurde "+ aAnz +" zum Warenkorb hinzugefügt.");
						warenkorb.anzeigen();
						FalscherArt.setForeground(Color.BLACK);
						FalscherArt.setText("Artikel hinzugefügt.");
						textArtikelNr.setText(null);
						textAnzahl.setText(null);
						
						// funktion zum laden in der Tabelle
						
						updateKundenWarenkorbTabelle(warenkorb.getWarenkorb());
						break;
					} else {
						FalscherArt.setForeground(Color.RED);
						FalscherArt.setText("     Falsche Eingabe!");
						textArtikelNr.setText(null);
						textAnzahl.setText(null);
						
					} 
				}
				   
				
				
			}
		});
		ArtikelHinzufügen.setBounds(49, 229, 152, 23);
		Raster.add(ArtikelHinzufügen);
		
		JLabel Anzahl = new JLabel("Anzahl :");
		Anzahl.setBounds(76, 141, 113, 14);
		Raster.add(Anzahl);
		
		textAnzahl = new JTextField();
		textAnzahl.setBounds(76, 176, 96, 20);
		Raster.add(textAnzahl);
		textAnzahl.setColumns(10);
		
		JLabel ArtikelName = new JLabel("ArtikelNr:");
		ArtikelName.setBounds(76, 74, 113, 14);
		Raster.add(ArtikelName);
		
		textArtikelNr = new JTextField();
		textArtikelNr.setColumns(10);
		textArtikelNr.setBounds(76, 110, 96, 20);
		Raster.add(textArtikelNr);
		
		JLabel ueberschrift = new JLabel("Artikel zum Warenkorb hinzuf\u00FCgen");
		ueberschrift.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ueberschrift.setBounds(20, 11, 227, 32);
		Raster.add(ueberschrift);
		

		
		
		/*-------------------------------------------------------------------------------------*/
		
		// erstellt warenkorb tab
		
		JPanel Warenkorb = new JPanel();
		Maintab.addTab("Warenkorb", null, Warenkorb, null);
		Warenkorb.setLayout(null);
		
		// erstellt das fenster in den Tab
		
		JScrollPane Layout3 = new JScrollPane();
		Layout3.setBounds(54, 21, 326, 374);
		Warenkorb.add(Layout3);
		
		// erstellt eine tabelle mit den jeweiligen eigenschaften
		
		tabelle1 = new JTable();
		tabelle1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Nr", "Anzahl", "St\u00FCckpreis", "Preis"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		// größe der einzelnen componenten in der tabelle
		
		tabelle1.getColumnModel().getColumn(0).setPreferredWidth(36);
		tabelle1.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabelle1.getColumnModel().getColumn(2).setPreferredWidth(48);
		tabelle1.getColumnModel().getColumn(3).setPreferredWidth(64);
		tabelle1.getColumnModel().getColumn(4).setPreferredWidth(40);
		Layout3.setViewportView(tabelle1);
		
		//laden des Warenkorbs
		
		//updateKundenWarenkorbTabelle(warenkorb.getWarenkorb());
		
		// layout größe für Gesamtpreis
		
		JScrollPane Layout2 = new JScrollPane();
		Layout2.setBounds(52, 404, 219, 37);
		Warenkorb.add(Layout2);
		
		// Label für gesamtpreis
		
		JLabel gesamtPreis = new JLabel("Gesamtpreis :");
		Layout2.setRowHeaderView(gesamtPreis);
		gesamtPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		// label für den Preis, der angezeigt wird
		
		gesamtPreisZahl = new JLabel("");
		gesamtPreisZahl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Layout2.setViewportView(gesamtPreisZahl);
		
		
		
		// button "kaufen" erstellt
		
		JButton kaufen = new JButton("Kaufen");
		kaufen.addActionListener(new ActionListener() {
			
		// funktion zum kaufen der Artikeln
			
			public void actionPerformed(ActionEvent e) {
				
				warenkorb.kaufen();
				warenkorb.leeren();
				try {
					lager.schreibeArtikel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gesamtPreisZahl.setText(null);
				updateKundenWarenkorbTabelle(warenkorb.getWarenkorb());
				updateKundenTabelle(lager.gibAlleArtikel());
			}
		});
		kaufen.setBounds(291, 406, 89, 35);
		Warenkorb.add(kaufen);
		

		
		
		// button " artikel entfernen" erstellt 
		
		JButton artikelEntfernen = new JButton("Artikel entfernen");
		
		// erstellt funktion um artikel entfernen zu können
		
		artikelEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String aNummer = "";
				int aNum;
				aNummer = textAnzahl1.getText();
				aNum = Integer.parseInt(aNummer);
				
				String aAnzahl ="";
				int aAnz;
				aAnzahl = textArtikelNr1.getText();
				aAnz = Integer.parseInt(aAnzahl);
				
				for(tempArtikel a : warenkorb.getWarenkorb()) {
					
					
					if(a.getArtikel().getNummer() == aNum && a.getAnzahl()>= aAnz) {
						warenkorb.delArtikel(aNum, aAnz);
						changelog.schreibeLog("Der Artikel mit der Nummer: " + aNum +" wurde "+ aAnz +" zum aus dem Warenkorb entfernt.");
						falscheEingabe.setForeground(Color.BLACK);
						falscheEingabe.setText("Artikel entfernt.");
						textArtikelNr1.setText(null);
						textAnzahl1.setText(null);
						updateKundenWarenkorbTabelle(warenkorb.getWarenkorb());
						break;
					} else if(!(a.getArtikel().getNummer() == aNum)) {
						falscheEingabe.setForeground(Color.RED);
						falscheEingabe.setText("Falsche ArtikelNr!");
						textArtikelNr1.setText(null);
						textAnzahl1.setText(null);
					} else if(!(a.getAnzahl()>= aAnz)) {
						falscheEingabe.setForeground(Color.RED);
						falscheEingabe.setText("Anzahl zu groß!");
						textArtikelNr1.setText(null);
						textAnzahl1.setText(null);
					}
					
				}
				
			}
		});
		
		artikelEntfernen.setBounds(446, 372, 141, 23);
		Warenkorb.add(artikelEntfernen);
		
		// erstellt label für artikelnr
		
		JLabel artikelNr = new JLabel("ArtikelNr :");
		artikelNr.setBounds(489, 247, 59, 14);
		Warenkorb.add(artikelNr);
		
		// erstellt eine texteingabe für artikelnr
		
		textArtikelNr1 = new JTextField();
		textArtikelNr1.setBounds(467, 329, 96, 20);
		Warenkorb.add(textArtikelNr1);
		textArtikelNr1.setColumns(10);
		
		// erstellt ein label für anzahl
		
		JLabel anzahl = new JLabel(" Anzahl :");
		 anzahl.setBounds(489, 304, 59, 14);
		Warenkorb.add( anzahl);
		
		// erstellt eine texteingabe für anzahl 
		
		textAnzahl1 = new JTextField();
		textAnzahl1.setColumns(10);
		textAnzahl1.setBounds(467, 272, 96, 20);
		Warenkorb.add(textAnzahl1);
		
		falscheEingabe = new JLabel("  ");
		falscheEingabe.setForeground(Color.RED);
		falscheEingabe.setBounds(475, 404, 141, 14);
		Warenkorb.add(falscheEingabe);
		
		// erstellt layout größe für artikel entfernen
		
		JScrollPane Layout4 = new JScrollPane();
		Layout4.setBounds(422, 211, 184, 226);
		Warenkorb.add(Layout4);
		
		
		
		
		
		
		
		// erstell button "warenkorb leeren" 
		
		JButton warenkorbLeeren = new JButton("Warenkorb leeren");
		warenkorbLeeren.addActionListener(new ActionListener() {
			
			// funktion zum leeren des warenkorbs
			
			public void actionPerformed(ActionEvent e) {
				
				warenkorb.leeren();
				gesamtPreisZahl.setText(null);
				updateKundenWarenkorbTabelle(warenkorb.getWarenkorb());
			
			}
		});
		warenkorbLeeren.setBounds(446, 133, 141, 23);
		Warenkorb.add(warenkorbLeeren);
		
		
		
		
		// erstellt button "artikel suchen"
		
		JButton artikelSuchen = new JButton("Artikel suchen");
		artikelSuchen.addActionListener(new ActionListener() {
			
			// funktion zum suchen der Artikeln im warenkorb 
			
			public void actionPerformed(ActionEvent e) {
				
				
				artikelScreach = new JFrame();
				artikelScreach.setVisible(true);
				artikelScreach.setTitle("Artikeln suchen");
				artikelScreach.setBounds(970, 150, 304, 246);
				artikelScreach.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				artikelScreach.getContentPane().setLayout(null);
				
				JLabel Artikelanlegen = new JLabel("Welchen Artikel Suchen Sie?");
				Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
				Artikelanlegen.setBounds(50, 11, 193, 31);
				artikelScreach.getContentPane().add(Artikelanlegen);
				
				JLabel Artikelname = new JLabel("Geben Sie den Artikelname des Artikels ein :");
				Artikelname.setBounds(10, 68, 282, 14);
				artikelScreach.getContentPane().add(Artikelname);
				
				textArtikel = new JTextField();
				textArtikel.setBounds(81, 93, 104, 20);
				artikelScreach.getContentPane().add(textArtikel);
				textArtikel.setColumns(10);
				
				JLabel FalscherArtikel = new JLabel(" ");
				FalscherArtikel.setForeground(Color.RED);
				FalscherArtikel.setBounds(26, 186, 240, 14);
				artikelScreach.getContentPane().add(FalscherArtikel);
				
				JButton Suchen = new JButton("Suchen");
				Suchen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String aName = "";
						
						aName = textArtikel.getText();
						
						for(tempArtikel a : warenkorb.getWarenkorb()) {
							if(a.getArtikel().getName().equals(aName)) {	
								updateKundenWarenkorbTabelle(warenkorb.sucheNachName(aName));
								artikelScreach.setVisible(false);
								changelog.schreibeLog("Der Artikel mit dem Namen: " + aName +" wurde gesucht.");
								break;
							} else {
								FalscherArtikel.setText("Ungültiger Name!");
								textArtikel.setText(null);
							}
						}
						
						
					}
				});
				Suchen.setBounds(81, 143, 104, 32);
				artikelScreach.getContentPane().add(Suchen);
				
				
				
				
			}
		});
		
		
		artikelSuchen.setBounds(446, 24, 141, 23);
		Warenkorb.add(artikelSuchen);
		
		
		
		
		// erstellt button "artikel anzeigen" 
		
		JButton artikelAnzeigen = new JButton("Artikel anzeigen");
		artikelAnzeigen.addActionListener(new ActionListener() {
			
			// funktion zum anzeigen der Artikeln, nachdem man ein artikel gesucht hat ( sinnig)
			
			public void actionPerformed(ActionEvent e) {
				updateKundenWarenkorbTabelle(warenkorb.getWarenkorb());
			}
		});
		artikelAnzeigen.setBounds(446, 72, 141, 23);
		Warenkorb.add(artikelAnzeigen);
	
		
				
		JButton btnNewButton = new JButton("Ausloggen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gibMenueAus();
				kundenMenue.setVisible(false);
			}
		});
		btnNewButton.setBounds(549, 506, 119, 23);
		kundenMenue.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("E-Shop creater : Mario Schulz, Bernd Henke, Dyar lol");
		lblNewLabel.setBounds(40, 510, 442, 14);
		kundenMenue.getContentPane().add(lblNewLabel);
		
	/*	String input = "";
		String aName = "";
		String aNummer ="";
		int aNum;
		String aAnzahl ="";
		int aAnz;

		List<Artikel> aliste;
		aliste = lager.gibAlleArtikel();
		
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("1. Alle Artikel ausgeben: '1': ");
		System.out.println("2. Einen Artikel suchen: '2': ");
		System.out.println("3. Artikel nach Namen Sortieren: '3': ");
		System.out.println("4. Artikel nach Nummer Sortieren: '4': ");
		System.out.println("5. Artikel zum Warenkorb hinzufügen: '5': ");
		System.out.println("6. Artikel aus dem Warenkorb entfernen: '6': ");
		System.out.println("7. Warenkorb leeren: '7': ");
		System.out.println("8. Warenkorb anzeigen: '8': ");
		System.out.println("9. Warenkorb kaufen: '9': ");
		System.out.println("10. Abmelden: '10': ");
		System.out.println("-----------------------------------------------");
		System.out.println("");
		System.out.print(">>");
		
		input = liesEingabe();
		switch(input) {
		case "1": //alle artikel ausgeben
			System.out.println("");
			gibArtikellisteAus(aliste);
			System.out.println("");
			changelog.schreibeLog("Alle Artikel wurden Angezeigt");
			kundenMenue();
			break;
		case "2": //einen Artikel suchen
			System.out.println("");
			System.out.println("Artikelname:    ");
			aName = liesEingabe();
			aliste = lager.sucheNachName(aName);
			gibArtikellisteAus(aliste);
			System.out.println("");
			changelog.schreibeLog("Der Artikel " + aName + " wurde gesucht.");
			kundenMenue();
			break;
		case "3": //Artikel nach Namen sortieren
			sortNameArtikelliste(aliste);
			System.out.println("");
			changelog.schreibeLog("Der Kunde hat alle Artikel nach Namen sortiert.");
			kundenMenue();
			break;
		case "4": //Artikel nach Nummer sortieren
			sortNummerArtikelliste(aliste);
			System.out.println("");
			changelog.schreibeLog("Der Kunde hat alle Artikel nach Nummer sortiert.");
			kundenMenue();
			break;
		case "5": //Artikel zum Warenkorb hinzufügen
			System.out.println("");
			System.out.println("Bitte geben Sie die Artikelnummer des Artikels an: ");
			System.out.println("");
			System.out.print(">>");
			aNummer = liesEingabe();
			aNum = Integer.parseInt(aNummer);
			
			System.out.println("");
			System.out.println("Bitte geben Sie die Anzahl der Artikel an: ");
			System.out.println("");
			System.out.print(">>");
			aAnzahl = liesEingabe();
			aAnz = Integer.parseInt(aAnzahl);
			
			System.out.println("");
			warenkorb.addArtikel(aNum, aAnz);
			System.out.println("Der Artikel wurde dem Warenkorb hinzugefügt.");
			System.out.println("");
			warenkorb.anzeigen();
			System.out.println("");
			kundenMenue();
			break;
		case "6": //Artikel aus dem Warenkorb entfernen
			System.out.println("");
			System.out.println("Bitte geben Sie die Artikelnummer des Artikels an: ");
			System.out.println("");
			System.out.print(">>");
			aNummer = liesEingabe();
			aNum = Integer.parseInt(aNummer);
			
			System.out.println("");
			System.out.println("Bitte geben Sie die Anzahl der Artikel an: ");
			System.out.println("");
			System.out.print(">>");
			aAnzahl = liesEingabe();
			aAnz = Integer.parseInt(aAnzahl);
			
			System.out.println("");
			warenkorb.delArtikel(aNum, aAnz);
			System.out.println("Der Artikel wurde aus dem Warenkorb entfernt.");
			System.out.println("");
			warenkorb.anzeigen();
			System.out.println("");
			kundenMenue();
			break;
		case "7": //Warenkorb leeren
			System.out.println("");
			System.out.println("Der Warenkorb wurde geleert.");
			System.out.println("");
			warenkorb.leeren();
			System.out.println("");
			kundenMenue();
			break;
		case "8": //Warenkorb anzeigen
			System.out.println("");
			warenkorb.anzeigen();
			System.out.println("");
			kundenMenue();
			break;
		case "9": //Warenkorb kaufen
			System.out.println("");
			warenkorb.kaufen();
			System.out.println("");
			kundenMenue();
			break;
		case "10": //Logout
			System.out.println("Sie werden jetzt ausgeloggt..");
			System.out.println("");
			changelog.schreibeLog("Der Kunde hat sich abgemeldet.");
			shopAnmeldung();
			break;
		
		default:
			System.out.println("");
			System.out.println("Fehlerhafte eingabe, bitte versuchen sie es Erneut...");
			changelog.schreibeLog("Es kam zu einer Fehlerhaften eingabe im Kunden-Menue.");
			System.out.println("");
			kundenMenue();
		}  */
	}                 
	
	/**
	 * verwendet von: gibMenueAus
	 * Beschriebung: GUI fenster in dem Gewählt werden kann, ob man ein Mitarbeiter oder Kunde ist.
	 */
	public void shopAnmeldung() {
		
				//Fenster erstellen
		
				shopAnmeldung = new JFrame();
				shopAnmeldung.setTitle("E-Shop");
				shopAnmeldung.setBounds(500, 300, 418, 269);
				shopAnmeldung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				shopAnmeldung.getContentPane().setLayout(null);
				shopAnmeldung.setVisible(true);
				
				//Label Kunde oder Mitarbeiter
				
				JLabel lblNewLabel_1 = new JLabel("Sind sie ein Kunde oder Mitarbeiter?");
				lblNewLabel_1.setBounds(93, 88, 241, 14);
				shopAnmeldung.getContentPane().add(lblNewLabel_1);
				
				//button Mitarbeiter
				
				JButton btnNewButton = new JButton("Mitarbeiter");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						shopAnmeldung.setVisible(false);
						shopAnmeldungMitarbeiter();
						
					}
				});
				
				btnNewButton.setBounds(225, 165, 105, 23);
				shopAnmeldung.getContentPane().add(btnNewButton);
				
				
				//button Kunde
				
				JButton btnNewButton_1 = new JButton("Kunde");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						shopAnmeldung.setVisible(false);
						shopAnmeldungKunde();
						
							}
				});
				
				btnNewButton_1.setBounds(73, 165, 105, 23);
				shopAnmeldung.getContentPane().add(btnNewButton_1);
			
	
		/*
		
		String input = "";
		System.out.println("");
		System.out.println("Bist du ein Kunde oder Mitarbeiter? Bitte wähle für Kunde 'K' und für Mitarbeiter 'M': ");
		System.out.println("");
		System.out.print(">>");
		input = liesEingabe();
		switch(input) {
		case "K": //Kunde
			shopAnmeldungKunde();
			break;
		case "M": //Mitarbeiter
			shopAnmeldungMitarbeiter();
			break;
		default:
			System.out.println("Fehlerhafte eingabe!");
			changelog.schreibeLog("Es kam zu einer Fehlerhaften eingabe im Startmenue.");
			gibMenueAus(); 
		}    */
	}
	
	
	
	
	/**
	 * verwendet von: shopAnmeldung
	 * Beschriebung: Erzeugt die GUI in der Benutzername und Passwort vom Mitarbeiter eingetragen werden.
	 */
	public void shopAnmeldungMitarbeiter() {
		
		shopAnmeldungMitarbeiter = new JFrame();
		shopAnmeldungMitarbeiter.setTitle("Mitarbeiterfenster");
		shopAnmeldungMitarbeiter.setBounds(500, 300, 320, 204);
		shopAnmeldungMitarbeiter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopAnmeldungMitarbeiter.getContentPane().setLayout(null);
		shopAnmeldungMitarbeiter.setVisible(true);
		
		// erstellt Benutzernametext + eingabetext
		
		JLabel Benutzername = new JLabel("Benutzername :");
		Benutzername.setBounds(36, 35, 103, 14);
		shopAnmeldungMitarbeiter.getContentPane().add(Benutzername);
		
		textID = new JTextField();
		textID.setBounds(36, 60, 96, 20);
		shopAnmeldungMitarbeiter.getContentPane().add(textID);
		textID.setColumns(10);
		
		// erstellt Passworttext + eingabetext
		
		JLabel Passwort = new JLabel("Passwort :");
		Passwort.setBounds(167, 35, 103, 14);
		shopAnmeldungMitarbeiter.getContentPane().add(Passwort);
		
		textPasswort = new JPasswordField();
		textPasswort.setColumns(10);
		textPasswort.setBounds(167, 60, 96, 20);
		shopAnmeldungMitarbeiter.getContentPane().add(textPasswort);
		
		FalscheIDundPw = new JLabel("    ");
		FalscheIDundPw.setForeground(Color.RED);
		FalscheIDundPw.setBounds(32, 91, 240, 14);
		shopAnmeldungMitarbeiter.getContentPane().add(FalscheIDundPw);
		
		// erstellt Button + Funktion zum überprüfen der Anmeldedaten
		
		JButton Anmelden = new JButton("Anmelden");
		Anmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = "";
				String passwort = "";
				boolean einloggen = false;
				List<Mitarbeiter> liste;
				liste = buero.gibAlleMitarbeiter();
				
				username = textID.getText();
				System.out.print(username);
				
				passwort = textPasswort.getText();
				System.out.print(passwort);
				
				for(Mitarbeiter m : liste) {
					if(m.getUsername().equals(username) && m.getPasswort().equals(passwort)) {
						einloggen = true;
						break;
					}
				}
				
				System.out.println(einloggen);
				if(!einloggen) {
				
					FalscheIDundPw.setText("Benutzername oder Passwort sind falsch!");
					changelog.schreibeLog("Es gab eine Fehlerhafte eingabe bei der Mitarbeiteranmeldung.");
					System.out.println("");
					
				} else {
				
				
			    shopAnmeldungMitarbeiter.setVisible(false);
				changelog.schreibeLog("Der Mitarbeiter " + username + " hat sich angemeldet.");
				System.out.println("");
				mitarbeiterMenue();
				}                
				
			}
		});
		
		Anmelden.setBounds(104, 115, 103, 23);
		shopAnmeldungMitarbeiter.getContentPane().add(Anmelden);
	}
	
	
	/**
	 * verwendet von: shopAnmeldung
	 * Beschriebung: erzeugt die GUI in der Benutzername und Passwort für einen Kunden eingetragen werden können.
	 */
	public void shopAnmeldungKunde() {
		
		shopAnmeldungKunde = new JFrame();
		shopAnmeldungKunde.setTitle("Kundenfenster");
		shopAnmeldungKunde.setBounds(500, 300, 320, 204);
		shopAnmeldungKunde.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopAnmeldungKunde.getContentPane().setLayout(null);
		shopAnmeldungKunde.setVisible(true);
		
		// erstellt Benutzernametext + eingabetext
		
		JLabel Benutzername = new JLabel("Benutzername :");
		Benutzername.setBounds(36, 35, 103, 14);
		shopAnmeldungKunde.getContentPane().add(Benutzername);
		
		textID = new JTextField();
		textID.setBounds(36, 60, 96, 20);
		shopAnmeldungKunde.getContentPane().add(textID);
		textID.setColumns(10);
		
		// erstellt Passworttext + eingabetext
		
		JLabel Passwort = new JLabel("Passwort :");
		Passwort.setBounds(167, 35, 103, 14);
		shopAnmeldungKunde.getContentPane().add(Passwort);
		
		textPasswort = new JPasswordField();
		textPasswort.setColumns(10);
		textPasswort.setBounds(167, 60, 96, 20);
		shopAnmeldungKunde.getContentPane().add(textPasswort);
		
		// erstellt ein Text, falls man falsche id und pw eingegeben hat 
		
		FalscheIDundPw = new JLabel("    ");
		FalscheIDundPw.setForeground(Color.RED);
		FalscheIDundPw.setBounds(32, 91, 240, 14);
		shopAnmeldungKunde.getContentPane().add(FalscheIDundPw); 
		
		// erstellt Button + Funktion zum überprüfen der Anmeldedaten
		
		JButton Anmelden = new JButton("Anmelden");
		Anmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = "";
				String passwort = "";
				boolean einloggen = false;
				List<Kunde> liste;
				liste = verkaufsstand.gibAlleKunden();
				
				username = textID.getText();
				System.out.print(username);
				
				passwort = textPasswort.getText();
				System.out.print(passwort);
				
				for(Kunde k : liste) {
					if(k.getUsername().equals(username) && k.getPasswort().equals(passwort)) {
						einloggen = true;
						break;
					}
				}
						
				if(!einloggen) {
				
					FalscheIDundPw.setText("Benutzername oder Passwort sind falsch!");
					
					changelog.schreibeLog("Es kam zu einen Fehler bei der Kundenanmeldung.");
					System.out.println("");
					
				} else {
					shopAnmeldungKunde.setVisible(false);
			
				changelog.schreibeLog("Der Kunde " + username + " hat sich angemeldet.");
				System.out.println("");
				kundenMenue();
				}                   
				
			}
		});
		
		Anmelden.setBounds(104, 115, 103, 23);
		shopAnmeldungKunde.getContentPane().add(Anmelden);
		
	}
	
	
	/**
	 * Verwendet von: MitarbeiterMenue & gibMenueAus
	 * Beschreibung: Die GUI für die Kundenregistrierung wird erzeugt.
	 * @param b gibt an ob man schon angemeldet ist oder ob das Programm noch vor der Anmeldung ist
	 */
	public void shopKundeRegistrierung(boolean b) {
		
		 // erstellt das Fenster für die Registrierung
		
		 shopKundeRegistrierung = new JFrame();
		 shopKundeRegistrierung.setTitle("Registrierungsfenster");
		 shopKundeRegistrierung.setBounds(500, 300, 397, 394);
		 shopKundeRegistrierung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 shopKundeRegistrierung.getContentPane().setLayout(null);
		 shopKundeRegistrierung.setVisible(true);
		 
		// erstellt Vornametext + eingabetext
		 
		JLabel Vorname = new JLabel("Vorname:");
		Vorname.setBounds(24, 38, 115, 14);
		shopKundeRegistrierung.getContentPane().add(Vorname);
		
		textVorname = new JTextField();
		textVorname.setColumns(10);
		textVorname.setBounds(24, 63, 115, 20);
		shopKundeRegistrierung.getContentPane().add(textVorname);
		
		// erstellt Nachnametext + eingabetext
		
		JLabel Nachname = new JLabel("Nachname:");
		Nachname.setBounds(24, 94, 115, 14);
		shopKundeRegistrierung.getContentPane().add(Nachname);
		
		textNachname = new JTextField();
		textNachname.setColumns(10);
		textNachname.setBounds(24, 119, 115, 20);
		shopKundeRegistrierung.getContentPane().add(textNachname);
		
		// erstellt Wohnorttext + eingabetext
		
		JLabel Wohnort = new JLabel("Wohnort:");
		Wohnort.setBounds(171, 38, 115, 14);
		shopKundeRegistrierung.getContentPane().add(Wohnort);
		
		textWohnort = new JTextField();
		textWohnort.setColumns(10);
		textWohnort.setBounds(171, 63, 115, 20);
		shopKundeRegistrierung.getContentPane().add(textWohnort);
		
		// erstellt Straßetext + eingabetext
		
		JLabel Straße = new JLabel("Stra\u00DFe:");
		Straße.setBounds(171, 94, 115, 14);
		shopKundeRegistrierung.getContentPane().add(Straße);
		
		textStraße = new JTextField();
		textStraße.setColumns(10);
		textStraße.setBounds(171, 119, 115, 20);
		shopKundeRegistrierung.getContentPane().add(textStraße);
		
		
		// erstellt PLZtext + eingabetext
		
		JLabel PLZ = new JLabel("PLZ:");
		PLZ.setBounds(296, 38, 95, 14);
		shopKundeRegistrierung.getContentPane().add(PLZ);
		
		textplz = new JTextField();
		textplz.setColumns(10);
		textplz.setBounds(296, 63, 57, 20);
		shopKundeRegistrierung.getContentPane().add(textplz);
		
	
		// erstellt ein Hintergrund Balken (Rechteck layout)
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 20, 364, 140);
		shopKundeRegistrierung.getContentPane().add(progressBar);
		
		// erstellt Benutzernametext + eingabetext
		
		JLabel Benutzername = new JLabel("Geben Sie einen Benutzernamen ein :");
		Benutzername.setBounds(24, 194, 221, 14);
		shopKundeRegistrierung.getContentPane().add(Benutzername);
		
		textBenutzername = new JTextField();
		textBenutzername.setColumns(10);
		textBenutzername.setBounds(24, 219, 115, 20);
		shopKundeRegistrierung.getContentPane().add(textBenutzername);
		
		// erstellt Passworttext + eingabetext
		
		JLabel Passwort = new JLabel("Legen Sie einen Passwort fest : ");
		Passwort.setBounds(24, 251, 221, 14);
		shopKundeRegistrierung.getContentPane().add(Passwort);
		
		textPasswort = new JPasswordField();
		textPasswort.setColumns(10);
		textPasswort.setBounds(24, 272, 115, 20);
		shopKundeRegistrierung.getContentPane().add(textPasswort);
		
		// erstellt KundenNrtext + eingabetext
		
		JLabel KundeNr = new JLabel("KundenNr angeben :");
		KundeNr.setBounds(232, 219, 121, 14);
		shopKundeRegistrierung.getContentPane().add(KundeNr);
		
		textKundeNr = new JTextField();
		textKundeNr.setColumns(10);
		textKundeNr.setBounds(264, 248, 43, 20);
		shopKundeRegistrierung.getContentPane().add(textKundeNr);
		
		//  bei bereits existernder KundenNr!
		
		FalscheKundenNr = new JLabel("      ");
		FalscheKundenNr.setForeground(Color.RED);
		FalscheKundenNr.setBounds(232, 279, 180, 14);
		shopKundeRegistrierung.getContentPane().add(FalscheKundenNr);  
		
		// erstellt ein Hintergrund Balken (Rechteck layout)
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 180, 364, 129);
		shopKundeRegistrierung.getContentPane().add(progressBar_1);
		
		//Erstellt Button
		
		JButton Registrieren = new JButton("Registrieren!");
		Registrieren.setBounds(141, 325, 115, 23);
		shopKundeRegistrierung.getContentPane().add(Registrieren);
		
		
		/*Funktion zum Speichern der Daten beim klick auf button
		 * bzw Registrierung eines neuen Kunden*/
		
		
		Registrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String username = "";
				String passwort = "";
				String vorname = "";
				String nachname = "";
				String wohnort = "";
				String PLZ = "";
				String strasse = "";
				String kundenNummer = "";
				int kundenNr;
				List<Kunde> liste;
				liste = verkaufsstand.gibAlleKunden();
				
				
				vorname = textVorname.getText();
				System.out.print(vorname);
				
				nachname = textNachname.getText();
				System.out.print(nachname);
				
				wohnort = textWohnort.getText();
				System.out.print(wohnort);
				
				strasse = textStraße.getText();
				System.out.print(strasse);
				
				PLZ = textplz.getText();
				System.out.print(strasse);
				
				
				username = textBenutzername.getText();
				System.out.print(username);
				
				passwort = textPasswort.getText();
				System.out.print(passwort);
				
				kundenNummer = textKundeNr.getText();
				System.out.print(kundenNummer);
				
				kundenNr = Integer.parseInt(kundenNummer);
				
				for(Kunde k : liste) {
					if(k.getKundenNr() == kundenNr) {				
					    FalscheKundenNr.setText("Die KundenNr existiert bereits!"); 
					    textKundeNr.setText(null);
					    			    
					    
					} 	
				}
				
				if(!textKundeNr.getText().isEmpty()) {
					changelog.schreibeLog("Ein neuer Kunde wurde angelegt. Er hat die Nummer " + kundenNr + ". ");
					verkaufsstand.fuegeKundeEin(username, passwort, vorname, nachname, wohnort, PLZ, strasse, kundenNr);
					try {
						verkaufsstand.schreibeKunden();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					shopKundeRegistrierung.setVisible(false);
					System.out.println("Kunde wurde angelegt.");
					if(!b) {
						shopAnmeldungKunde();	
					}
					
				}
			}

			
				
			
		});
		
	}
	
	
	
	/**
	 * verwendet von: MitarbeiterMenue
	 * beschriebung: erzeugt das Registrierungsfenster für einen neuen Mitarbeiter
	 * @param b gibt an ob die Funktion aus dem MitarbeiterMenue aufgerufen wird oder nicht
	 */
	public void shopMitarbeiterRegistrierung(boolean b) {
		
		 // erstellt das Fenster für die Registrierung
		
		 shopMitarbeiterRegistrierung = new JFrame();
		 shopMitarbeiterRegistrierung.setTitle("Registrierungsfenster");
		 shopMitarbeiterRegistrierung.setBounds(500, 300, 397, 394);
		 shopMitarbeiterRegistrierung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 shopMitarbeiterRegistrierung.getContentPane().setLayout(null);
		 shopMitarbeiterRegistrierung.setVisible(true);
		 
		// erstellt Vornametext + eingabetext
		 
		JLabel Vorname = new JLabel("Vorname:");
		Vorname.setBounds(24, 38, 115, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(Vorname);
		
		textVorname = new JTextField();
		textVorname.setColumns(10);
		textVorname.setBounds(24, 63, 115, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textVorname);
		
		// erstellt Nachnametext + eingabetext
		
		JLabel Nachname = new JLabel("Nachname:");
		Nachname.setBounds(24, 94, 115, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(Nachname);
		
		textNachname = new JTextField();
		textNachname.setColumns(10);
		textNachname.setBounds(24, 119, 115, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textNachname);
		
		// erstellt Wohnorttext + eingabetext
		
		JLabel Wohnort = new JLabel("Wohnort:");
		Wohnort.setBounds(171, 38, 115, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(Wohnort);
		
		textWohnort = new JTextField();
		textWohnort.setColumns(10);
		textWohnort.setBounds(171, 63, 115, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textWohnort);
		
		// erstellt Straßetext + eingabetext
		
		JLabel Straße = new JLabel("Stra\u00DFe:");
		Straße.setBounds(171, 94, 115, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(Straße);
		
		textStraße = new JTextField();
		textStraße.setColumns(10);
		textStraße.setBounds(171, 119, 115, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textStraße);
		
		
		// erstellt PLZtext + eingabetext
		
		JLabel PLZ = new JLabel("PLZ:");
		PLZ.setBounds(296, 38, 95, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(PLZ);
		
		textplz = new JTextField();
		textplz.setColumns(10);
		textplz.setBounds(296, 63, 57, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textplz);
		
	
		// erstellt ein Hintergrund Balken (Rechteck layout)
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 20, 364, 140);
		shopMitarbeiterRegistrierung.getContentPane().add(progressBar);
		
		// erstellt Benutzernametext + eingabetext
		
		JLabel Benutzername = new JLabel("Geben Sie einen Benutzernamen ein :");
		Benutzername.setBounds(24, 194, 221, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(Benutzername);
		
		textBenutzername = new JTextField();
		textBenutzername.setColumns(10);
		textBenutzername.setBounds(24, 219, 115, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textBenutzername);
		
		// erstellt Passworttext + eingabetext
		
		JLabel Passwort = new JLabel("Legen Sie einen Passwort fest : ");
		Passwort.setBounds(24, 251, 221, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(Passwort);
		
		textPasswort = new JPasswordField();
		textPasswort.setColumns(10);
		textPasswort.setBounds(24, 272, 115, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textPasswort);
		
		// erstellt KundenNrtext + eingabetext
		
		JLabel KundeNr = new JLabel("MitarbeiterNr angeben :");
		KundeNr.setBounds(232, 219, 121, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(KundeNr);
		
		textMitarbeiterNr = new JTextField();
		textMitarbeiterNr.setColumns(10);
		textMitarbeiterNr.setBounds(264, 248, 43, 20);
		shopMitarbeiterRegistrierung.getContentPane().add(textMitarbeiterNr);
		
		//  bei bereits existernder KundenNr!
		
		FalscheMitarbeiterNr = new JLabel("      ");
		FalscheMitarbeiterNr.setForeground(Color.RED);
		FalscheMitarbeiterNr.setBounds(232, 279, 180, 14);
		shopMitarbeiterRegistrierung.getContentPane().add(FalscheMitarbeiterNr);  
		
		// erstellt ein Hintergrund Balken (Rechteck layout)
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 180, 364, 129);
		shopMitarbeiterRegistrierung.getContentPane().add(progressBar_1);
		
		//Erstellt Button
		
		JButton Registrieren = new JButton("Registrieren!");
		Registrieren.setBounds(141, 325, 115, 23);
		shopMitarbeiterRegistrierung.getContentPane().add(Registrieren);
		
		
		/*Funktion zum Speichern der Daten beim klick auf button
		 * bzw Registrierung eines neuen Kunden*/
		
		
		Registrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String username = "";
				String passwort = "";
				String vorname = "";
				String nachname = "";
				String wohnort = "";
				String PLZ = "";
				String strasse = "";
				String mitarbeiterNummer = "";
				int mitarbeiterNr;
				/*List<Kunde> liste;
				liste = verkaufsstand.gibAlleKunden();*/
				
				
				vorname = textVorname.getText();
				System.out.print(vorname);
				
				nachname = textNachname.getText();
				System.out.print(nachname);
				
				wohnort = textWohnort.getText();
				System.out.print(wohnort);
				
				strasse = textStraße.getText();
				System.out.print(strasse);
				
				PLZ = textplz.getText();
				System.out.print(strasse);
				
				
				username = textBenutzername.getText();
				System.out.print(username);
				
				passwort = textPasswort.getText();
				System.out.print(passwort);
				
				mitarbeiterNummer = textMitarbeiterNr.getText();
				System.out.print(mitarbeiterNummer);
				
				mitarbeiterNr = Integer.parseInt(mitarbeiterNummer);
				
				for(Mitarbeiter m : buero.gibAlleMitarbeiter()) {
					if(m.getMitarbeiterNr() == mitarbeiterNr) {				
					    FalscheMitarbeiterNr.setText("Die MitarbeiterNr existiert bereits!"); 
					    textMitarbeiterNr.setText(null);
					    			    
					    
					} 	
				}
				
				if(!textMitarbeiterNr.getText().isEmpty()) {
					changelog.schreibeLog("Ein neuer Mitarbeiter wurde angelegt. Er hat die Nummer " + mitarbeiterNr + ". ");
					buero.fuegeMitarbeiterEin(username, passwort, vorname, nachname, wohnort, PLZ, strasse, mitarbeiterNr);
					try {
						buero.schreibeMitarbeiter();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					shopMitarbeiterRegistrierung.setVisible(false);
					System.out.println("Mitarbeiter wurde angelegt.");
					if(!b) {
						shopAnmeldungMitarbeiter();	
					}
					
				}
			}

			
				
			
		});
		
	}
	
	/**
	 * Beschreibung: wird nicht mehr benötigt, hat in der CUI eine Liste ausgegeben
	 * @param liste ist die Liste die ausgegegeben werden soll
	 */
	private void gibArtikellisteAus(List<Artikel> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			for (Artikel a : liste) {
				System.out.println(a);
			}
		}
	}
	
	
	/**
	 * verwendet von: MitarbeiterMenue & KundenMenue
	 * Beschriebung: Sortiert mit hilfe von einen Comperator die Artikelliste nach Namen
	 * 
	 * @param liste ist die Liste die Sortier werden woll
	 * @return ist die Sortiere liste
	 */
	private List<Artikel> sortNameArtikelliste(List<Artikel> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			
			Collections.sort(liste, new Comparator<Artikel>() {
				  @Override
				  public int compare(Artikel u1, Artikel u2) {
				    return u1.getName().compareTo(u2.getName());
				  }
				});
				
			}
		return liste;
		}
	
	/**
	 * verwendet von: MitarbeiterMenue & KundenMenue
	 * Beschriebung: Sortiert mit hilfe eines Comperators die Artikelliste nach Nummer
	 * @param liste ist die Artikelliste
	 * @return gibt die Sortiere Liste zurück
	 */
	private List<Artikel> sortNummerArtikelliste(List<Artikel> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			
			Collections.sort(liste, new Comparator<Artikel>() {
				  @Override
				  public int compare(Artikel u1, Artikel u2) {
				  
					  int x = Integer.compare(u1.getNummer(),u2.getNummer());
					  
				    return x;
				  }
				});
				
			}
		return liste;
		}
	
	/**
	 * Beschriebung: wird nicht mehr benötigt, kommt aus der CUI
	 * @param liste
	 */
	private void gibMitarbeiterlisteAus(List<Mitarbeiter> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			for (Mitarbeiter m : liste) {
				System.out.println(m);
			}
		}
	}
	/**
	 * Beschreibgung: wird nicht mehr benötigt, kommt aus der CUI
	 * @param liste
	 */
	private void gibKundenlisteAus(List<Kunde> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			for (Kunde k : liste) {
				System.out.println(k);
			}
		}
	}
	
	/**
	 * Beschreibung: wird nicht mehr benötigt, kommt aus der CUI
	 */
	private void gibLogAus() {
		
		try {
			log = logmanager.liesLog("Log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (log.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			for (String l : log) {
				System.out.println(l);
			}
		}
	}
	
	/**
	 * Beschreibung: startet das Programm. Erstellt die GUI. Speichert alle Listen bevor das Programm beendet wird.
	 * @param args
	 */
	public static void main(String[] args) {
		
		testgui gui;
		
		gui = new testgui("Art","Mit","Kund","Log");
		
		
		gui.gibMenueAus();
		
		//speichert alle Daten vor dem Beenden des Programmes
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	changelog.schreibeLog("Das Programm wurde beendet.");
	        	System.out.println("test");
	            try {
					logmanager.schreibeDaten("Log");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            try {
					lager.schreibeArtikel();
				} catch (IOException e) {
					e.printStackTrace();
				}
	            try {
					verkaufsstand.schreibeKunden();
				} catch (IOException e) {
					e.printStackTrace();
				}
	            try {
					buero.schreibeMitarbeiter();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }, "Shutdown-thread"));
	
	}

	
	
}