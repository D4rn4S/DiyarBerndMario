package Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Datenstrukturen.ChangelogNeu;
import Persistenz.FilePersistenceManager;
import Persistenz.PersistenceManager;

public class ChangelogManagerNeu {
		
	private List<ChangelogNeu> changelog = new ArrayList<ChangelogNeu>();
	private PersistenceManager pm = new FilePersistenceManager();
		
	public void liesDaten(String datei) throws IOException {
			
		pm.openForReading(datei+"_S.txt");
		ChangelogNeu c;
			
		do {
			c = pm.ladeChangelogNeu();
			if(c != null) {
				einfuegen(c);
			}
		} while(c != null);
			
	}
		
	public void schreibeDaten(String datei) throws IOException {
		
		pm.openForWriting(datei+"_S.txt");
		
		for(ChangelogNeu c : changelog) {
			pm.speichereChangelog(c);
		}
	
			pm.close();
	}

	public void einfuegen(ChangelogNeu c) {changelog.add(c); System.out.println(c);}


	public List<ChangelogNeu> getChangelog() {
		return new ArrayList<ChangelogNeu>(changelog);
	}	
		
	public void gibLogAus() {
		System.out.println(changelog);
	}
		
		
}

	
	
	

