package Persistenz;


import java.io.IOException;

import Datenstrukturen.Changelog;
import Datenstrukturen.Mitarbeiter;



public interface PersistenceManager {


public void openForReading(String datenquelle) throws IOException;

public void openForWriting(String datenquelle) throws IOException; 

public boolean close();


public Datenstrukturen.Artikel ladeArtikel() throws IOException;

public boolean speichereArtikel(Datenstrukturen.Artikel a) throws IOException ;

public Datenstrukturen.Mitarbeiter ladeMitarbeiter() throws IOException;

public boolean speichereMitarbeiter(Datenstrukturen.Mitarbeiter m) throws IOException ;

public Datenstrukturen.Kunde ladeKunde() throws IOException;

public boolean speichereKunde(Datenstrukturen.Kunde k) throws IOException ;

public String liesLog() throws IOException;

public boolean speichereLog(String log) throws IOException ;

public Changelog ladeChangelogNeu() throws IOException;

public boolean speichereChangelog(Changelog c) throws IOException;

}
