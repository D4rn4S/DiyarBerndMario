package Datenstrukturen;

import java.io.IOException;

import java.util.List;

import Manager.PersonenManager;

public class Buero { //klasse für die Mitarbeiter

	private String datei = "";
	private PersonenManager personenManager;
	
	public Buero(String datei) throws IOException{
		this.datei = datei;
		personenManager = new PersonenManager();
		personenManager.liesMitarbeiter(datei+"_S.txt");
	}
	
	
	public List<Mitarbeiter> gibAlleMitarbeiter(){
		return personenManager.getMitarbeiterBestand();
	}
	
	
	
	public List<Mitarbeiter> sucheNachNummer(int nr) {
		return personenManager.suchMitarbeiterNr(nr); 
	}
	
	
	public Mitarbeiter fuegeMitarbeiterEin(String username, String passwort, String vorname, String nachname, String wohnort, String plz, String strasse, int mitarbeiterNr){
		Mitarbeiter m = new Mitarbeiter(username, passwort, vorname, nachname, wohnort, plz, strasse, mitarbeiterNr);
		personenManager.einfuegen(m);
		return m;
	}
	
	
	public void loescheMitarbeiter(int mitarbeiterNr) {
		personenManager.mloeschen(mitarbeiterNr);
	}
	
	public void schreibeMitarbeiter() throws IOException{
		personenManager.schreibeMitarbeiter(datei+"_S.txt");
	}
	
	
	
	
}
