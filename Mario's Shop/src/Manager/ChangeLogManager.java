package Manager;

import java.io.IOException;

import java.util.*;

import Datenstrukturen.Artikel;
import Datenstrukturen.Changelog;
import Persistenz.FilePersistenceManager;
import Persistenz.PersistenceManager;
/**
 * 
 * @author Mario
 *	der changelogManager schriebt die Datei vom Changelog und kann diese Auch auslesen
 */
public class ChangeLogManager {

	List<String> log = new ArrayList<String>();
	String input = "";
	private PersistenceManager pm = new FilePersistenceManager();
	
	public ChangeLogManager() {}
	
	
	public List<String> liesLog(String datei) throws IOException {
		pm.openForReading(datei+"_S.txt");
		String input = "";
		
		do {
			input = pm.liesLog();
			if(input != null) {
				log.add(input);
			}
		} while (input != null);
	
	return log;
	}
	
	public void schreibeDaten(String datei) throws IOException {
		
		pm.openForWriting(datei+"_S.txt");
		
		for(String l : log) {
			pm.speichereLog(l);
		}
		
		pm.close();
		
	}
	
	
	
	
	
	
	
	
}
