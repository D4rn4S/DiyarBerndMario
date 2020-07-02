package domain;


import java.io.IOException;

import java.util.*;

import valueobjects.Artikel;
import persistence.FilePersistenceManager;
import persistence.PersistenceManager;

public class LagerManager {
	
	private List<Artikel> artikelBestand = new ArrayList<Artikel>();
	private PersistenceManager pm = new FilePersistenceManager();
	
	public void liesDaten(String datei) throws IOException {
		
		pm.openForReading(datei);
		Artikel a;
		
		do {
			a = pm.ladeArtikel();
			if(a != null) {
				einfuegen(a);
			}
		} while(a != null);
		
	}
	
	/**
	 * Verwendet von:
	 * Methodenbeschriebung: schreibt den aktuellen bestand vom Lager in die Lager Datei
	 * @param String datei
	 * @throws IOException
	 */
	public void schreibeDaten(String datei) throws IOException {
		
		pm.openForWriting(datei);
		
		for(Artikel a : artikelBestand) {
			pm.speichereArtikel(a);
		}
		
		pm.close();
		
	}
	/**
	 * fügt einen Artikel dem Bestand hinzu
	 * @param a
	 */
	public void einfuegen(Artikel a) {artikelBestand.add(a);}
	
	/**
	 * loescht eine Artiel aus dem Aktuellen bestand
	 * @param nummer
	 */
	public void loeschen(int nummer) {
		Iterator<Artikel> iter = artikelBestand.iterator();
		while(iter.hasNext()) {
			Artikel a = iter.next();
			if(a.getNummer()==nummer) {
				iter.remove();
			}
		}
		}
	
	/**
	 * Durchsucht den Artikelbestand nach einen namen
	 * @param name
	 * @return eine Liste mit den Suchergebnissen
	 */
	public List<Artikel> suchArtikelName(String name){
		
		List<Artikel> suchErg = new ArrayList<Artikel>();
		Iterator<Artikel> iter = artikelBestand.iterator();
		
		while(iter.hasNext()) {
			Artikel a = iter.next();
			if(a.getName().equals(name)) {
				suchErg.add(a);
			}
		}
		return suchErg;
	}
	/**
	 * durchsucht die Liste nach der Artikelnummer
	 * @param nr
	 * @return
	 */
	public List<Artikel> suchArtikelNr(int nr){
		
		List<Artikel> suchErg = new ArrayList<Artikel>();
		Iterator<Artikel> iter = artikelBestand.iterator();
		
		while(iter.hasNext()) {
			Artikel a = iter.next();
			if(a.getNummer() == nr) {
				suchErg.add(a);
			}
		}
		return suchErg;
	}
	
/**
 * gibt eine Liste mit dem Artikelbestand zurück
 * @return
 */
	public List<Artikel> getArtikelBestand() {
		return new ArrayList<Artikel>(artikelBestand);
	}	
	
	
	
	
}
