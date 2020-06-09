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
import Manager.ChangeLogManager;
import Datenstrukturen.Artikel;
import Datenstrukturen.Buero;
import Datenstrukturen.Changelog;
import Datenstrukturen.Kunde;




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
	private JFrame shopAnmeldungMitarbeiter;
	private JFrame shopAnmeldungKunde;
	private JFrame mitarbeiterMenue;
	private JFrame mitarbeiterHinzufuegenMenue;
	private JFrame kundenMenue;
	private JTextField textVorname;
	private JTextField textNachname;
	private JTextField textWohnort;
	private JTextField textStraße;
	private JTextField textplz;
	private JTextField textNr;
	private JTextField textBenutzername;
	private JTextField textID;
	private JTextField textArtikel;
	private JTextField textNummer;
	private JTextField textPreis;
	private JTextField textBestand;
	private  JTextField textMindestbestand;
	private JPasswordField textPasswort;
	private JTextField textKundeNr;
	private JLabel FalscheKundenNr;
	private JLabel FalscheIDundPw;
	private JLabel falscherArtikel;
	
	
	

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
	
	



	public void run() {
		// Variable für Eingaben von der Konsole
		String input = "";
	
		//Hauptschliefe der Benutzeroberfläche
		do {
			gibMenueAus();
		} while (!input.equals("q"));
	
	}


	//Startmenue
	public void gibMenueAus() {
		
			//Fenster erstellen
		
			gibMenueAus = new JFrame();
			gibMenueAus.setTitle("E-Shop");
			gibMenueAus.setBounds(100, 100, 418, 269);
			gibMenueAus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gibMenueAus.getContentPane().setLayout(null);
			gibMenueAus.setVisible(true);
			
			//Label Wilkommen
			
			JLabel Willkommen = new JLabel("Herzlich Wilkommen auf unseren Online Shop!");
			Willkommen.setBounds(73, 37, 312, 14);
			gibMenueAus.getContentPane().add(Willkommen);
			
			//Label Anmeldung oder Registrieren
			
			JLabel AoderR = new JLabel("Anmelden oder Registrieren?");
			AoderR.setBounds(93, 88, 241, 14);
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
					shopKundeRegistrierung();
					
						}
			});
			
			Registrieren.setBounds(73, 165, 105, 23);
			gibMenueAus.getContentPane().add(Registrieren);

	}
	
	
	
	public void mitarbeiterMenue() {
		
		mitarbeiterMenue = new JFrame();
		mitarbeiterMenue.setVisible(true);
		mitarbeiterMenue.setTitle("Menü für Mitarbeiter");
		mitarbeiterMenue.setBounds(100, 100, 680, 564);
		mitarbeiterMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mitarbeiterMenue.getContentPane().setLayout(null);
		
		// main tab 
		
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
				JTable tabelle = new JTable();
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
				
					//tabelle befüllen
			    
			        DefaultTableModel TabelleBefüllen = (DefaultTableModel) tabelle.getModel();
			        
			        Object rowData[] = new Object[5];
			        for(int i = 0; i < aliste.size(); i++)
			        {
			            rowData[0] = aliste.get(i).getName();
			            rowData[1] = aliste.get(i).getNummer();
			            rowData[2] = aliste.get(i).getPreis();
			            rowData[3] = aliste.get(i).getBestand();
			            rowData[4] = aliste.get(i).getMindestbestand();
			            TabelleBefüllen.addRow(rowData);
			        }
			                
			    
				
				//erstellt ein button "artikel hinzufügen"
				
				JButton ArtikelHinzufuegen = new JButton("Artikel hinzufuegen");
				ArtikelHinzufuegen.addActionListener(new ActionListener() {
					
			    // Funktion zum öffnen eines neuen Fensters, um artikel hinzufügen zu können
					
					public void actionPerformed(ActionEvent e) {
						
						mitarbeiterHinzufuegenMenue = new JFrame();
						mitarbeiterHinzufuegenMenue.setVisible(true);
						mitarbeiterHinzufuegenMenue.setBounds(100, 100, 328, 299);
						mitarbeiterHinzufuegenMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						mitarbeiterHinzufuegenMenue.getContentPane().setLayout(null);
						
						JLabel Artikelanlegen = new JLabel("Legen Sie ein neuen Artikel an!");
						Artikelanlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
						Artikelanlegen.setBounds(56, 11, 197, 31);
						mitarbeiterHinzufuegenMenue.getContentPane().add(Artikelanlegen);
						
						JLabel Artikelname = new JLabel("Artikelname :");
						 Artikelname.setBounds(37, 64, 96, 14);
						mitarbeiterHinzufuegenMenue.getContentPane().add(Artikelname);
						
						textArtikel= new JTextField(null);
						textArtikel.setBounds(37, 89, 96, 20);
						mitarbeiterHinzufuegenMenue.getContentPane().add(textArtikel);
						textArtikel.setColumns(10);
						
						JLabel lblArtikelnummer = new JLabel("Artikelnummer :");
						lblArtikelnummer.setBounds(37, 120, 96, 14);
						mitarbeiterHinzufuegenMenue.getContentPane().add(lblArtikelnummer);
						
						textNummer = new JTextField(null);
						textNummer.setColumns(10);
						textNummer.setBounds(37, 145, 37, 20);
						mitarbeiterHinzufuegenMenue.getContentPane().add(textNummer);
						
						
						
						JLabel Preis = new JLabel("Preis :");
						Preis.setBounds(187, 64, 96, 14);
						mitarbeiterHinzufuegenMenue.getContentPane().add(Preis);
						
						textPreis = new JTextField(null);
						textPreis.setColumns(10);
						textPreis.setBounds(187, 89, 96, 20);
						mitarbeiterHinzufuegenMenue.getContentPane().add(textPreis);
						
						
						JLabel Bestand = new JLabel("Bestand");
						Bestand.setBounds(187, 120, 96, 14);
						mitarbeiterHinzufuegenMenue.getContentPane().add(Bestand);
						
						textBestand = new JTextField(null);
						textBestand.setColumns(10);
						textBestand.setBounds(187, 145, 96, 20);
						mitarbeiterHinzufuegenMenue.getContentPane().add(textBestand);
						
						
						
						JLabel Mindestbestand = new JLabel("Mindestbestand :");
						Mindestbestand.setBounds(37, 176, 96, 14);
						mitarbeiterHinzufuegenMenue.getContentPane().add(Mindestbestand);
						
						textMindestbestand = new JTextField(null);
						textMindestbestand.setColumns(10);
						textMindestbestand.setBounds(37, 201, 96, 20);
						mitarbeiterHinzufuegenMenue.getContentPane().add(textMindestbestand);
						
						falscherArtikel = new JLabel("Bitte füllen Sie alle Felder.");
						falscherArtikel.setBounds(81, 232, 170, 14);
						falscherArtikel.setForeground(Color.BLACK);
						falscherArtikel.setFont(new Font("Tahoma", Font.PLAIN, 13));
						mitarbeiterHinzufuegenMenue.getContentPane().add(falscherArtikel);
					
						
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
								}
								if(textArtikel.getText().isEmpty() || textNummer.getText().isEmpty() || textPreis.getText().isEmpty() || textBestand.getText().isEmpty() || textMindestbestand.getText().isEmpty()) {
									falscherArtikel.setText("Bitte füllen sie alle Felder");
									textNummer.setText(null);
									textArtikel.setText(null);
									textPreis.setText(null);
									textBestand.setText(null);
									textMindestbestand.setText(null);
								} */
								
								for(Artikel a : aliste) {
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
						
									mitarbeiterHinzufuegenMenue.setVisible(false);
								}
							
							}
						});
						Hinzufügen.setBounds(177, 189, 104, 32);
						mitarbeiterHinzufuegenMenue.getContentPane().add(Hinzufügen);
							
						
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
				mitarbeiterMenue.getContentPane().add(btnNewButton);
				
				JLabel lblNewLabel = new JLabel("E-Shop creater : Mario Schulz, Bernd Henke, Dyar lol");
				lblNewLabel.setBounds(40, 510, 442, 14);
				mitarbeiterMenue.getContentPane().add(lblNewLabel);
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
	
	
	public void kundenMenue() {
		
		kundenMenue = new JFrame();
		kundenMenue.setVisible(true);
		kundenMenue.setTitle("Menü für Kunden");
		kundenMenue.setBounds(100, 100, 727, 666);
		kundenMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String input = "";
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
		}
	}
	
	
	public void shopAnmeldung() {
		
				//Fenster erstellen
		
				shopAnmeldung = new JFrame();
				shopAnmeldung.setTitle("E-Shop");
				shopAnmeldung.setBounds(100, 100, 418, 269);
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
	
	
	
	
	
	public void shopAnmeldungMitarbeiter() {
		
		shopAnmeldungMitarbeiter = new JFrame();
		shopAnmeldungMitarbeiter.setTitle("Mitarbeiterfenster");
		shopAnmeldungMitarbeiter.setBounds(100, 100, 320, 204);
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
		FalscheIDundPw.setBounds(46, 91, 240, 14);
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
	
	public void shopAnmeldungKunde() {
		
		shopAnmeldungKunde = new JFrame();
		shopAnmeldungKunde.setTitle("Kundenfenster");
		shopAnmeldungKunde.setBounds(100, 100, 320, 204);
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
		FalscheIDundPw.setBounds(46, 91, 240, 14);
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
	
	
	
	public void shopKundeRegistrierung() {
		
		 // erstellt das Fenster für die Registrierung
		
		 shopKundeRegistrierung = new JFrame();
		 shopKundeRegistrierung.setTitle("Registrierungsfenster");
		 shopKundeRegistrierung.setBounds(100, 100, 397, 394);
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
					shopAnmeldungKunde();
				}
			}

			
				
			
		});
		
	}
	
	
	
	
	public void shopMitarbeiterRegistrierung() {
		String username = "";
		String passwort = "";
		String vorname = "";
		String nachname = "";
		String wohnort = "";
		String plz = "";
		String strasse = "";
		String mitarbeiterNummer = "";
		int mitarbeiterNr;
		List<Mitarbeiter> liste;
		liste = buero.gibAlleMitarbeiter();
		
		System.out.println("");
		System.out.println("Bitte gebe einen Benutzernamen ein: ");
		System.out.println("");
		System.out.print(">>");
		username = liesEingabe();

		System.out.println("");
		System.out.println("Bitte lege ein Passwort fest: ");
		System.out.println("");
		System.out.print(">>");
		passwort = liesEingabe();

		
		System.out.println("");
		System.out.println("Bitte gebe einen Vornamen ein: ");
		System.out.println("");
		System.out.print(">>");
		vorname = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe einen Nachnamen ein: ");
		System.out.println("");
		System.out.print(">>");
		nachname = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe einen Wohnort ein: ");
		System.out.println("");
		System.out.print(">>");
		wohnort = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe einen Postleitzahl ein: ");
		System.out.println("");
		System.out.print(">>");
		plz = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe eine Strasse ein: ");
		System.out.println("");
		System.out.print(">>");
		strasse = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte lege eine Mitarbeiter-Nummer fest: ");
		System.out.println("");
		System.out.print(">>");
		mitarbeiterNummer = liesEingabe();
		mitarbeiterNr = Integer.parseInt(mitarbeiterNummer);
		
		for(Mitarbeiter m : liste) {
			while(m.getMitarbeiterNr() == mitarbeiterNr) {
				System.out.println("");
				System.out.println("Bitte wähle eine andere Mitarbeiter-Nr..");
				System.out.println("");
				System.out.print(">>");
				mitarbeiterNummer = liesEingabe();
				mitarbeiterNr = Integer.parseInt(mitarbeiterNummer);
			}
		}
		
		
		changelog.schreibeLog("Ein neuer Mitarbeiter wurde angelegt. Er hat die Nummer " + mitarbeiterNr + ". ");
		buero.fuegeMitarbeiterEin(username, passwort, vorname, nachname, wohnort, plz, strasse, mitarbeiterNr);
		
		try {
			buero.schreibeMitarbeiter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
		System.out.println("Ein neuer Mitarbeiter wurde regestriert...");
		System.out.println("");
	}
	

	private static void gibArtikellisteAus(List<Artikel> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			for (Artikel a : liste) {
				System.out.println(a);
			}
		}
	}
	
	private static void sortNameArtikelliste(List<Artikel> liste) {
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
			for (Artikel a : liste) {
				System.out.println(a);
			}
		}
		
	private static void sortNummerArtikelliste(List<Artikel> liste) {
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
			for (Artikel a : liste) {
				System.out.println(a);
			}
		}
	
	
	private static void gibMitarbeiterlisteAus(List<Mitarbeiter> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			for (Mitarbeiter m : liste) {
				System.out.println(m);
			}
		}
	}

	private static void gibKundenlisteAus(List<Kunde> liste) {
		if (liste.isEmpty()) {
			System.out.println("Liste ist leer.");
		} else {
			for (Kunde k : liste) {
				System.out.println(k);
			}
		}
	}
	
	private static void gibLogAus() {
		
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
	
	
	public static void main(String[] args) {
		
		testgui gui;
		
		gui = new testgui("Art","Mit","Kund","Log");
		
		
		gui.gibMenueAus();
	
	}

	
	
}