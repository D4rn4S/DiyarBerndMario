package Manager;


import java.io.IOException;

import java.util.*;

import Datenstrukturen.Artikel;
import Datenstrukturen.Kunde;
import Datenstrukturen.Mitarbeiter;
import Persistenz.FilePersistenceManager;
import Persistenz.PersistenceManager;

public class PersonenManager {
	
	private List<Mitarbeiter> mitarbeiterBestand = new ArrayList<Mitarbeiter>();
	private List<Kunde> kundenBestand = new ArrayList<Kunde>();
	private PersistenceManager pm = new FilePersistenceManager();
	
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
	
	
	
	public void schreibeMitarbeiter(String datei) throws IOException {
		
		pm.openForWriting(datei);
		
		for(Mitarbeiter m : mitarbeiterBestand) {
			pm.speichereMitarbeiter(m);
		}
		
		pm.close();
		
	}
	
	public void schreibeKunden(String datei) throws IOException {
		
		pm.openForWriting(datei);
		
		for(Kunde k : kundenBestand) {
			pm.speichereKunde(k);
		}
		
		pm.close();
		
	}
	
	
	public void einfuegen(Mitarbeiter m) {mitarbeiterBestand.add(m);}
	public void einfuegen(Kunde k) {kundenBestand.add(k);}
	
	public void mloeschen(int mNummer) {
		Iterator<Mitarbeiter> iter = mitarbeiterBestand.iterator();
		while(iter.hasNext()) {
			Mitarbeiter m = iter.next();
			if(m.getMitarbeiterNr()==mNummer) {
				iter.remove();
			}
		}
	}
	public void kloeschen(int kNummer) {
		Iterator<Kunde> iter = kundenBestand.iterator();
		while(iter.hasNext()) {
			Kunde k = iter.next();
			if(k.getKundenNr()==kNummer) {
				iter.remove();
			}
		}
	}
	
	
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

	
public List<Mitarbeiter> getMitarbeiterBestand() {
	return new ArrayList<Mitarbeiter>(mitarbeiterBestand);
}	

public List<Kunde> getKundenBestand() {
	return new ArrayList<Kunde>(kundenBestand);
}	
	
	
	
}
