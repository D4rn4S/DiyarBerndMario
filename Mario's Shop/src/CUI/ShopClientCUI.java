package CUI;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
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


public class ShopClientCUI {
	
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

	public ShopClientCUI(String dArtikel, String dMitarbeiter, String dKunden, String dLog) {
		
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
		// Variable f�r Eingaben von der Konsole
		String input = "";
	
		//Hauptschliefe der Benutzeroberfl�che
		do {
			gibMenueAus();
		} while (!input.equals("q"));
	
	}


	//Startmenue
	public void gibMenueAus() {
		String input = "";
		System.out.println("Bitte melden sie sich an oder Regestrieren sie sich...");
		System.out.println("Um sich anzumelden, dr�cken sie 'A'");
		System.out.println("Neukunde? Um sich zu registrieren dr�cken sie 'R'");
		System.out.println("");
		System.out.print(">>");
		input = liesEingabe();
		switch(input) {
		case "A": //Anmeldung
			shopAnmeldung();
			break;
		case "R": //Registrierung
			shopKundeRegistrierung();
			break;		
		default:
			System.out.println("Fehlerhafte eingabe!");
			gibMenueAus();
		}
	}
	
	public void mitarbeiterMenue() {
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
		System.out.println("2. Einen Artikel l�schen: '2': ");
		System.out.println("3. Einen Artikel einf�gen: '3': ");
		System.out.println("4. Einen Artikel suchen: '4': ");
		System.out.println("5. Artikel nach Namen Sortieren: '5': ");
		System.out.println("6. Artikel nach Nummer Sortieren: '6': ");
		System.out.println("7. Artikelliste sichern: '7': ");
		System.out.println("8. Artikel zum Warenkorb hinzuf�gen: '8': ");
		System.out.println("9. Artikel aus dem Warenkorb entfernen: '9': ");
		System.out.println("10. Warenkorb leeren: '10': ");
		System.out.println("11. Warenkorb anzeigen: '11': ");
		System.out.println("12. Warenkorb kaufen: '12': ");
		System.out.println("13. Changelog anzeigen: '13': ");
		System.out.println("14. Neuen Mitarbeiter anlegen: '14': ");
		System.out.println("15. Alle Mitarbeiter anzeigen: '15': ");
		System.out.println("16. Einen Mitarbeiter l�schen: '16': ");
		System.out.println("17. Einen Mitarbeiter suchen: '17': ");
		System.out.println("18. Einen Kunden anlegen: '18': ");
		System.out.println("19. Einen Kunden l�schen: '19': ");
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
		case "2": //artikel l�schen
			System.out.println("");
			System.out.println("Bitte geben Sie die Artikelnummer des zu l�schenden Artikels ein: ");
			System.out.println("");
			System.out.print(">>");
			aNummer = liesEingabe();
			aNum = Integer.parseInt(aNummer);
			lager.loescheArtikel(aNum);
			System.out.println("");
			System.out.println("Der Artikel wurde erfolgreich gel�scht.");
			changelog.schreibeLog("Der Artikel mit der Artikelnummer " + aNum + " wurde gel�scht");
			System.out.println("");
			mitarbeiterMenue();
			break;
		case "3": //Artikel einfg�gen
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
		case "8": //artikel den warenkorb hinzuf�gen
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
			System.out.println("Der Artikel wurde dem Warenkorb hinzugef�gt.");
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
		case "16": //Mitarbeiter l�schen
			System.out.println("");
			System.out.println("Bitte geben Sie die Mitarbeiternummer des zu l�schenden Mitarbeiters ein: ");
			System.out.println("");
			System.out.print(">>");
			mNummer = liesEingabe();
			mNum = Integer.parseInt(mNummer);
			buero.loescheMitarbeiter(mNum);
			System.out.println("");
			System.out.println("Der Mitarbeiter wurde gel�scht.");
			changelog.schreibeLog("Der Mitarbeiter mit der Mitarbeiternummer " + mNum + " wurde gel�scht");
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
		case "19": //Kunden l�schen
			System.out.println("");
			System.out.println("Bitte geben sie die Kundennummer des zu l�schenden Kundens ein: ");
			System.out.println("");
			System.out.print(">>");
			kNummer = liesEingabe();
			kNum = Integer.parseInt(kNummer);
			verkaufsstand.loescheKunde(kNum);
			System.out.println("");
			System.out.println("Der Kunde wurde erfolgreich gel�scht.");
			changelog.schreibeLog("Der Kunde mit der Kundennummer " + kNum + " wurde gel�scht");
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
		
	}
	
	public void kundenMenue() {
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
		System.out.println("5. Artikel zum Warenkorb hinzuf�gen: '5': ");
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
		case "5": //Artikel zum Warenkorb hinzuf�gen
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
			System.out.println("Der Artikel wurde dem Warenkorb hinzugef�gt.");
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
		String input = "";
		System.out.println("");
		System.out.println("Bist du ein Kunde oder Mitarbeiter? Bitte w�hle f�r Kunde 'K' und f�r Mitarbeiter 'M': ");
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
		}
	}
	
	
	
	
	
	public void shopAnmeldungMitarbeiter() {
		String username = "";
		String passwort = "";
		boolean einloggen = false;
		List<Mitarbeiter> liste;
		liste = buero.gibAlleMitarbeiter();
		
		System.out.println("");
		System.out.println("Bitte gebe deinen Benutzernamen ein: ");
		System.out.println("");
		System.out.print(">>");
		username = liesEingabe();
		
		System.out.println("Bitte gebe dein Passwort ein: ");
		System.out.println("");
		System.out.print(">>");
		passwort = liesEingabe();
		
		for(Mitarbeiter m : liste) {
			if(m.getUsername().equals(username) && m.getPasswort().equals(passwort)) {
				einloggen = true;
				break;
			}
		}
		
		System.out.println(einloggen);
		if(!einloggen) {
			System.out.println("");
			System.out.println("Benutzername oder Passwort sind falsch..");
			changelog.schreibeLog("Es gab eine Fehlerhafte eingabe bei der Mitarbeiteranmeldung.");
			System.out.println("");
			shopAnmeldung();
		} else {
		
		System.out.println("");
		System.out.println("Du wurdest erfolgreich angemeldet!");
		changelog.schreibeLog("Der Mitarbeiter " + username + " hat sich angemeldet.");
		System.out.println("");
		mitarbeiterMenue();
		}
	}
	
	public void shopAnmeldungKunde() {
		String username = "";
		String passwort = "";
		boolean einloggen = false;
		List<Kunde> liste;
		liste = verkaufsstand.gibAlleKunden();
		
		System.out.println("");
		System.out.println("Bitte gebe deinen Benutzernamen ein: ");
		System.out.println("");
		System.out.print(">>");
		username = liesEingabe();
		
		System.out.println("Bitte gebe dein Passwort ein: ");
		System.out.println("");
		System.out.print(">>");
		passwort = liesEingabe();
		
		for(Kunde k : liste) {
			if(k.getUsername().equals(username) && k.getPasswort().equals(passwort)) {
				einloggen = true;
				break;
			}
		}
				
		if(!einloggen) {
			System.out.println("");
			System.out.println("Benutzername oder Passwort sind falsch..");
			changelog.schreibeLog("Es kam zu einen Fehler bei der Kundenanmeldung.");
			System.out.println("");
			shopAnmeldung();
		} else {
		System.out.println("");
		System.out.println("Du wurdest erfolgreich angemeldet!");
		changelog.schreibeLog("Der Kunde " + username + " hat sich angemeldet.");
		System.out.println("");
		kundenMenue();
		}
	}
	
	public void shopKundeRegistrierung() {
		String username = "";
		String passwort = "";
		String vorname = "";
		String nachname = "";
		String wohnort = "";
		String plz = "";
		String strasse = "";
		String kundenNummer = "";
		int kundenNr;
		List<Kunde> liste;
		liste = verkaufsstand.gibAlleKunden();
		
		System.out.println("");
		System.out.println("Bitte gebe deinen Benutzernamen ein: ");
		System.out.println("");
		System.out.print(">>");
		username = liesEingabe();

		System.out.println("");
		System.out.println("Bitte lege ein Passwort fest: ");
		System.out.println("");
		System.out.print(">>");
		passwort = liesEingabe();

		
		System.out.println("");
		System.out.println("Bitte gebe deinen Vornamen ein: ");
		System.out.println("");
		System.out.print(">>");
		vorname = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe deinen Nachnamen ein: ");
		System.out.println("");
		System.out.print(">>");
		nachname = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe deinen Wohnort ein: ");
		System.out.println("");
		System.out.print(">>");
		wohnort = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe deinen Postleitzahl ein: ");
		System.out.println("");
		System.out.print(">>");
		plz = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte gebe deine Strasse ein: ");
		System.out.println("");
		System.out.print(">>");
		strasse = liesEingabe();
		
		System.out.println("");
		System.out.println("Bitte lege deine Kunden-Nummer fest: ");
		System.out.println("");
		System.out.print(">>");
		kundenNummer = liesEingabe();
		kundenNr = Integer.parseInt(kundenNummer);
		for(Kunde k : liste) {
			while(k.getKundenNr() == kundenNr) {
				System.out.println("");
				System.out.println("Bitte w�hle eine andere Kunden-Nr..");
				System.out.println("");
				System.out.print(">>");
				kundenNummer = liesEingabe();
				kundenNr = Integer.parseInt(kundenNummer);
			}
		}
		
		changelog.schreibeLog("Ein neuer Kunde wurde angelegt. Er hat die Nummer " + kundenNr + ". ");
		verkaufsstand.fuegeKundeEin(username, passwort, vorname, nachname, wohnort, plz, strasse, kundenNr);
		
		try {
			verkaufsstand.schreibeKunden();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
		System.out.println("du bist jetzt Registriert");
		System.out.println("");
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
				System.out.println("Bitte w�hle eine andere Mitarbeiter-Nr..");
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
		
		ShopClientCUI cui;
		
		cui = new ShopClientCUI("Art","Mit","Kund","Log");
		
		
		cui.run();
	
	}
	
}