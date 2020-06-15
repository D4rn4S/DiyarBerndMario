package Persistenz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Datenstrukturen.Artikel;
import Datenstrukturen.Kunde;
import Datenstrukturen.Mitarbeiter;

/**
 * 
 * @author Mario
 *
 */
public class FilePersistenceManager implements PersistenceManager {

	private BufferedReader reader = null;
	private PrintWriter writer = null;
	
	/**
	 * erzeugt einen Buffered Reder der etwas einlesen kann aus einer Datei
	 */
	@Override
	public void openForReading(String datei) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(datei));
	}
	/**
	 * erzeugt einen BufferedWritter der etwas in eine Datei schreiben kann
	 */
	@Override
	public void openForWriting(String datei)  throws IOException {
		writer = new PrintWriter(new BufferedWriter(new FileWriter(datei)));
	}
	/**
	 * schließt den buffered Reader und writer
	 */
	@Override
	public boolean close() {
		if (writer != null) {
			writer.close();
		}
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
}
	
	
	/**
	 * funktion zum laden der Artikel
	 */
	@Override
	public Artikel ladeArtikel() throws IOException {
		//einlesen des Namens
		String name = liesZeile();
		if(name == null) {
			return null;
		}
			//einlesen der Artikelnummer
		String nummerString = "";
		try {
			nummerString = liesZeile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int nummer = Integer.parseInt(nummerString);
	
		//Einlesen des Artikelpreises
		String preisString = "";
		try {
			preisString = liesZeile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double preis = Double.parseDouble(preisString);
	
		//Einlesen vom Bestand
		String bestandString = "";
		try {
			bestandString = liesZeile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int bestand = Integer.parseInt(bestandString);
	
		//Einlesen vom mindestBestand
		String mindestbestandString = "";
		try {
			mindestbestandString = liesZeile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int mindestbestand = Integer.parseInt(mindestbestandString);
		
		//einlesen von Massengut
		String massengutString = "";
		try {
			massengutString = liesZeile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int massengut = Integer.parseInt(massengutString);
	
	
		return new Artikel(name, nummer, preis, bestand, mindestbestand, massengut);
	
	}
	
	
	
	/**
	 * funktion zum laden der Mitarbeiter
	 */
	@Override
	public Mitarbeiter ladeMitarbeiter() throws IOException {
		//einlesen des Usernamens
		String username = liesZeile();
		if(username == null) {
			return null;
		}
		
		//einlesen des passworts
		String passwort = liesZeile();
		if(passwort == null) {
			return null;
		}
		
		//einlesen des vornamens
		String vorname = liesZeile();
		if(vorname == null) {
			return null;
		}
		 //einlesen des nachnamen
		String nachname = liesZeile();
		if(nachname == null) {
			return null;
		}
		
		//einelsen des wohnorts
		String wohnort = liesZeile();
		if(wohnort == null) {
			return null;
		}
		
		//einlesen der plz
		String plz = liesZeile();
		if(plz == null) {
			return null;
		}
		
		//einlesen der strasse
		String strasse = liesZeile();
		if(strasse == null) {
			return null;
		}
		
		//einlesen der MitarbeiterNr
				String mitarbeiterNrString = "";
				try {
					mitarbeiterNrString = liesZeile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int mitarbeiternr = Integer.parseInt(mitarbeiterNrString);
		
		return new Mitarbeiter(username, passwort, vorname, nachname, wohnort, plz, strasse, mitarbeiternr);
	
	}
	
	
	
	/**
	 * funktion zum laden der Kunden
	 */
	@Override
	public Kunde ladeKunde() throws IOException {
		//einlesen des Usernamens
		String username = liesZeile();
		if(username == null) {
			return null;
		}
		
		//einlesen des passworts
		String passwort = liesZeile();
		if(passwort == null) {
			return null;
		}
		
		//einlesen des vornamens
		String vorname = liesZeile();
		if(vorname == null) {
			return null;
		}
		 //einlesen des nachnamen
		String nachname = liesZeile();
		if(nachname == null) {
			return null;
		}
		
		//einelsen des wohnorts
		String wohnort = liesZeile();
		if(wohnort == null) {
			return null;
		}
		
		//einlesen der plz
		String plz = liesZeile();
		if(plz == null) {
			return null;
		}
		
		//einlesen der strasse
		String strasse = liesZeile();
		if(strasse == null) {
			return null;
		}
		
		//einlesen der MitarbeiterNr
				String kundennrString = "";
				try {
					kundennrString = liesZeile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int kundennr = Integer.parseInt(kundennrString);
		
		return new Kunde(username, passwort, vorname, nachname, wohnort, plz, strasse, kundennr);
	
	}
	
	
	/**
	 * funktion zum speichern der Artikel
	 */
	@Override
	public boolean speichereArtikel(Artikel a)  throws IOException {
		schreibeZeile(a.getName());
		schreibeZeile(a.getNummer()+ "");
		schreibeZeile(a.getPreis()+ "");
		schreibeZeile(a.getBestand()+"");
		schreibeZeile(a.getMindestbestand()+"");
		schreibeZeile(a.getMassengut()+"");
		
		return true;
	}
	/**
	 * funktionb zum speichern der Mitarbeiter
	 */
	@Override
	public boolean speichereMitarbeiter(Mitarbeiter m)  throws IOException {
		schreibeZeile(m.getUsername());
		schreibeZeile(m.getPasswort());
		schreibeZeile(m.getVorname());
		schreibeZeile(m.getNachname());
		schreibeZeile(m.getWohnort());
		schreibeZeile(m.getPlz());
		schreibeZeile(m.getStrasse());
		schreibeZeile(m.getMitarbeiterNr()+"");
		
		return true;
	}
	
	/**
	 * funktion zum speichern der Kunden
	 */
	@Override
	public boolean speichereKunde(Kunde k)  throws IOException {
		schreibeZeile(k.getUsername());
		schreibeZeile(k.getPasswort());
		schreibeZeile(k.getVorname());
		schreibeZeile(k.getNachname());
		schreibeZeile(k.getWohnort());
		schreibeZeile(k.getPlz());
		schreibeZeile(k.getStrasse());
		schreibeZeile(k.getKundenNr()+"");
		
		return true;
	}
	
	/**
	 * funktion zum speichern vom Log
	 */
	@Override
	public boolean speichereLog(String log) throws IOException {
		//hier fehlt noch der inhalt
		schreibeZeile(log);
		return true;
	}
	
	/**
	 * funktion zum einelsen des Logs
	 */
	@Override
	public String liesLog(){

		String input = "";

		try {
			input = liesZeile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return input;
	}
	
	/**
	 * ließt eine Zeile in einer Text Datei und gibt diese Zurück
	 * @return
	 * @throws IOException
	 */
	private String liesZeile() throws IOException {
		if(reader != null) {
			return reader.readLine();
		} else {
			return "";
		}
	}
	/**
	 * schreibt eine Zeile in einer TextDatei
	 * @param daten
	 */
	private void schreibeZeile(String daten) {
		if(writer != null) {
			writer.println(daten);
		}
	}
	

	
	
}
