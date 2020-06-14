package Manager;


import java.io.IOException;

import java.util.*;

import Datenstrukturen.Artikel;
import Datenstrukturen.Kunde;
import Datenstrukturen.Mitarbeiter;
import Persistenz.FilePersistenceManager;
import Persistenz.PersistenceManager;
/**
 * 
 * @author Mario
 *
 */
public class PersonenManager {
	
	private List<Mitarbeiter> mitarbeiterBestand = new ArrayList<Mitarbeiter>();
	private List<Kunde> kundenBestand = new ArrayList<Kunde>();
	private PersistenceManager pm = new FilePersistenceManager();
	
	/**
	 * list die Datei aus in der die Mitarbeiter stehen
	 * @param datei
	 * @throws IOException
	 */
	public void liesMitarbeiter(String datei) throws IOException {
		
		pm.openForReading(datei);
		Mitarbeiter m;
		
		do {
			m = pm.ladeMitarbeiter();
			if(m != null) {
				einfuegen(m);
			}
		} while(m != null);
		
	}
	
	/**
	 * liest die Datei aus in der die Kunden stehen
	 * @param datei
	 * @throws IOException
	 */
public void liesKunden(String datei) throws IOException {
		
		pm.openForReading(datei);
		Kunde k;
		
		do {
			k = pm.ladeKunde();
			if(k != null) {
				einfuegen(k);
			}
		} while(k != null);
		
	}
	
	
	/**
	 * schriebt die Mitarbeiter in die Datei
	 * @param datei
	 * @throws IOException
	 */
	public void schreibeMitarbeiter(String datei) throws IOException {
		
		pm.openForWriting(datei);
		
		for(Mitarbeiter m : mitarbeiterBestand) {
			pm.speichereMitarbeiter(m);
		}
		
		pm.close();
		
	}
	/**
	 * schreibt die Kunden in die Datei
	 * @param datei
	 * @throws IOException
	 */
	public void schreibeKunden(String datei) throws IOException {
		
		pm.openForWriting(datei);
		
		for(Kunde k : kundenBestand) {
			pm.speichereKunde(k);
		}
		
		pm.close();
		
	}
	
	/**
	 * fügt einen Mitarbeiter hinzu
	 * @param m
	 */
	public void einfuegen(Mitarbeiter m) {mitarbeiterBestand.add(m);}
	/**
	 * fügt einen Kunden hinzu
	 * @param k
	 */
	public void einfuegen(Kunde k) {kundenBestand.add(k);}
	
	/**
	 * löscht einen Mitarbeiter
	 * @param mNummer
	 */
	public void mloeschen(int mNummer) {
		Iterator<Mitarbeiter> iter = mitarbeiterBestand.iterator();
		while(iter.hasNext()) {
			Mitarbeiter m = iter.next();
			if(m.getMitarbeiterNr()==mNummer) {
				iter.remove();
			}
		}
	}
	/**
	 * löscht einen Kunden
	 * @param kNummer
	 */
	public void kloeschen(int kNummer) {
		Iterator<Kunde> iter = kundenBestand.iterator();
		while(iter.hasNext()) {
			Kunde k = iter.next();
			if(k.getKundenNr()==kNummer) {
				iter.remove();
			}
		}
	}
	
	/**
	 * durchsucht die Mitarbeiterliste nach der NR
	 * @param nr
	 * @return
	 */
public List<Mitarbeiter> suchMitarbeiterNr(int nr){
		
		List<Mitarbeiter> suchErg = new ArrayList<Mitarbeiter>();
		Iterator<Mitarbeiter> iter = mitarbeiterBestand.iterator();
		
		while(iter.hasNext()) {
			Mitarbeiter m = iter.next();
			if(m.getMitarbeiterNr() == nr) {
				suchErg.add(m);
			}
		}
		return suchErg;
	}
	/**
	 * durchsucht die Kundenliste nach einer NR
	 * @param nr
	 * @return
	 */
public List<Kunde> suchKundenNr(int nr){
	
	List<Kunde> suchErg = new ArrayList<Kunde>();
	Iterator<Kunde> iter = kundenBestand.iterator();
	
	while(iter.hasNext()) {
		Kunde k = iter.next();
		if(k.getKundenNr() == nr) {
			suchErg.add(k);
		}
	}
	return suchErg;
}

	/**
	 * gibt den Mitarbeiterbestand aus als Liste
	 * @return
	 */
public List<Mitarbeiter> getMitarbeiterBestand() {
	return new ArrayList<Mitarbeiter>(mitarbeiterBestand);
}	
	/**
	 * gibt den Kundenbestand als liste aus
	 * @return
	 */
public List<Kunde> getKundenBestand() {
	return new ArrayList<Kunde>(kundenBestand);
}	
	
	
	
}
