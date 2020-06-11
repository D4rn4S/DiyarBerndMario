package Manager;


import java.io.IOException;

import java.util.*;

import Datenstrukturen.Artikel;
import Persistenz.FilePersistenceManager;
import Persistenz.PersistenceManager;

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
	 * Methodenbeschriebung:
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
	
	public void einfuegen(Artikel a) {artikelBestand.add(a);}
	
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
	 * 
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
	
public List<Artikel> getArtikelBestand() {
	return new ArrayList<Artikel>(artikelBestand);
}	
	
	
	
	
}
