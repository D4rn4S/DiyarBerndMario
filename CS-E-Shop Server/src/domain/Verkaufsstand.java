package domain;

import java.io.IOException;

import java.util.List;

import domain.PersonenManager;
import valueobjects.Kunde;

public class Verkaufsstand { //klasse für die kunden

	private String datei = "";
	private PersonenManager personenManager;
	
	public Verkaufsstand(String datei) throws IOException{
		this.datei = datei;
		personenManager = new PersonenManager();
		personenManager.liesKunden(datei+"_S.txt");
	}
	
	
	public List<Kunde> gibAlleKunden(){
		return personenManager.getKundenBestand();
	}
	
	
	
	public List<Kunde> sucheNachNummer(int nr) {
		return personenManager.suchKundenNr(nr); 
	}
	
	
	public Kunde fuegeKundeEin(String username, String passwort, String vorname, String nachname, String wohnort, String plz, String strasse, int kundenNr){
		Kunde k = new Kunde(username, passwort, vorname, nachname, wohnort, plz, strasse, kundenNr);
		personenManager.einfuegen(k);
		return k;
	}
	
	
	public void loescheKunde(int nummer) {
		personenManager.kloeschen(nummer);
	}
	
	public void schreibeKunden() throws IOException{
		personenManager.schreibeKunden(datei+"_S.txt");
	}
	
	
	
	
}
