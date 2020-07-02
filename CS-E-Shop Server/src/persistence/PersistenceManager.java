package persistence;


import java.io.IOException;



public interface PersistenceManager {


public void openForReading(String datenquelle) throws IOException;

public void openForWriting(String datenquelle) throws IOException; 

public boolean close();


public valueobjects.Artikel ladeArtikel() throws IOException;

public boolean speichereArtikel(valueobjects.Artikel a) throws IOException ;

public valueobjects.Mitarbeiter ladeMitarbeiter() throws IOException;

public boolean speichereMitarbeiter(valueobjects.Mitarbeiter m) throws IOException ;

public valueobjects.Kunde ladeKunde() throws IOException;

public boolean speichereKunde(valueobjects.Kunde k) throws IOException ;

public String liesLog() throws IOException;

public boolean speichereLog(String log) throws IOException ;

public valueobjects.Changelog ladeChangelogNeu() throws IOException;

public boolean speichereChangelog(valueobjects.Changelog c) throws IOException;

}
