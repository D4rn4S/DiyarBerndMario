package Datenstrukturen;

import java.io.IOException;

import java.util.List;

import Manager.PersonenManager;

public class Verkaufsstand { //klasse f�r die kunden

	private String datei = "";
	private PersonenManager personenManager;
	
	/**
	 * Verkaufstand ist die Schnittstelle zwischen Personenmanager und der GUI. Er k�mmert sich um die Kunden
	 * @param datei
	 * @throws IOException
	 */
	public Verkaufsstand(String datei) throws IOException{
		this.datei = datei;
		personenManager = new PersonenManager();
		personenManager.liesKunden(datei+"_S.txt");
	}
	
	/**
	 * ruft den Personenmanager auf und l�sst sich den aktuellen Kundenbestand geben
	 * @return gibt den aktuellen Kundenstand zur�ck
	 */
	public List<Kunde> gibAlleKunden(){
		return personenManager.getKundenBestand();
	}
	
	
	/**
	 * �bergibt den Personenmanger die kundennummer, diese gibt eine Liste zur�ck mit der Person mit der Nummer
	 * @param nr
	 * @return gibt die personen zur�ck, mit der angebenen Kunden Nr
	 */
	public List<Kunde> sucheNachNummer(int nr) {
		return personenManager.suchKundenNr(nr); 
	}
	
	/**
	 * Erstellt einen Kunden und �bergibt diesen zum Personenmanager. Dieser f�gt den kunden zum Bestand hinzu.
	 * @param username
	 * @param passwort
	 * @param vorname
	 * @param nachname
	 * @param wohnort
	 * @param plz
	 * @param strasse
	 * @param kundenNr
	 * @return
	 */
	public Kunde fuegeKundeEin(String username, String passwort, String vorname, String nachname, String wohnort, String plz, String strasse, int kundenNr){
		Kunde k = new Kunde(username, passwort, vorname, nachname, wohnort, plz, strasse, kundenNr);
		personenManager.einfuegen(k);
		return k;
	}
	
	/**
	 * �bergibt den personenmanager die nummer. Dieser l�scht den Kunden mit der Nummer
	 * @param nummer
	 */
	public void loescheKunde(int nummer) {
		personenManager.kloeschen(nummer);
	}
	
	/**
	 * L�sst den personenmanager den Kundenbestand speichern
	 * @throws IOException
	 */
	public void schreibeKunden() throws IOException{
		personenManager.schreibeKunden(datei+"_S.txt");
	}
	
	
	
	
}
