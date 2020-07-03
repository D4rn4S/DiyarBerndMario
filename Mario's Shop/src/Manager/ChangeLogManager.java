package Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Datenstrukturen.Artikel;
import Datenstrukturen.Changelog;
import Exceptions.InvalidNameChangelogException;
import Persistenz.FilePersistenceManager;
import Persistenz.PersistenceManager;

public class ChangelogManager {
		
	private List<Changelog> changelog = new ArrayList<Changelog>();
	private PersistenceManager pm = new FilePersistenceManager();
		
	public void liesDaten(String datei) throws IOException {
			
		pm.openForReading(datei+"_S.txt");
		Changelog c;
			
		do {
			c = pm.ladeChangelogNeu();
			if(c != null) {
				einfuegen(c);
			}
		} while(c != null);
			
	}
		
	public void schreibeDaten(String datei) throws IOException {
		
		pm.openForWriting(datei+"_S.txt");
		
		for(Changelog c : changelog) {
			pm.speichereChangelog(c);
		}
	
			pm.close();
	}

	public void einfuegen(Changelog c) {changelog.add(c); System.out.println(c);}


	public List<Changelog> getChangelog() {
		return new ArrayList<Changelog>(changelog);
	}	
		
	public void gibLogAus() {
		System.out.println(changelog);
	}
	
public List<Changelog> suchChangeloglName(String name) throws InvalidNameChangelogException{
		
		List<Changelog> suchErg = new ArrayList<Changelog>();
		Iterator<Changelog> iter = changelog.iterator();
		
		while(iter.hasNext()) {
			Changelog a = iter.next();
			if(a.getTyp()) {
				if(a.getMitarbeiter().getVorname().equals(name)) {
					suchErg.add(a);
					
				}
			} else {
				if(a.getKunde().getVorname().equals(name)) {
					suchErg.add(a);
				}
			}
		}
		
		if(suchErg.isEmpty()) {
			throw new InvalidNameChangelogException();
		} 
		return suchErg;
	}
		
}

	
	
	

