package Datenstrukturen;

import java.io.IOException;

import java.util.List;

import Manager.PersonenManager;

/**
 * 
 * @author Mario
 *
 */
public class Buero { //klasse für die Mitarbeiter

	private String datei = "";
	private PersonenManager personenManager;
	
	/**
	 * Beschreibung: Ist die Schnittstelle zwischen der GUI und dem PersonenManger. Übergibt die Datei in der Mitarbeiter stehen.
	 * @param datei
	 * @throws IOException
	 */
	public Buero(String datei) throws IOException{
		this.datei = datei;
		personenManager = new PersonenManager();
		personenManager.liesMitarbeiter(datei+"_S.txt");
	}
	
	/**
	 * Beschreibung: gibt eine Liste mit allen Mitarbeitern zurück
	 * @return die Mitarbeiterliste
	 */
	public List<Mitarbeiter> gibAlleMitarbeiter(){
		return personenManager.getMitarbeiterBestand();
	}
	
	
	/**
	 * Beschriebung: übergibt die Nummer nach der ein MItarbeiter gesucht werden soll
	 * @param nr
	 * @return gibt die Liste ´zurück in der die Mitarbeiter mit der gesuchten NR stehen.
	 */
	public List<Mitarbeiter> sucheNachNummer(int nr) {
		return personenManager.suchMitarbeiterNr(nr); 
	}
	
	/**
	 * Beschriebung: fügt einen neuen Mitarbeiter ein, gibt den Mitarbeiter an den PersonenManager weiter
	 * @param username
	 * @param passwort
	 * @param vorname
	 * @param nachname
	 * @param wohnort
	 * @param plz
	 * @param strasse
	 * @param mitarbeiterNr
	 * @return
	 */
	public Mitarbeiter fuegeMitarbeiterEin(String username, String passwort, String vorname, String nachname, String wohnort, String plz, String strasse, int mitarbeiterNr){
		Mitarbeiter m = new Mitarbeiter(username, passwort, vorname, nachname, wohnort, plz, strasse, mitarbeiterNr);
		personenManager.einfuegen(m);
		return m;
	}
	
	/**
	 * Beschreibung: löscht einen Mitarbeiter nach der MitarbeiterNummer
	 * @param mitarbeiterNr
	 */
	public void loescheMitarbeiter(int mitarbeiterNr) {
		personenManager.mloeschen(mitarbeiterNr);
	}
	
	/**
	 * Beschriebung: lässt den personenManger die MitarbeiterListe speichern.
	 * @throws IOException
	 */
	public void schreibeMitarbeiter() throws IOException{
		personenManager.schreibeMitarbeiter(datei+"_S.txt");
	}
	
	
	
	
}
