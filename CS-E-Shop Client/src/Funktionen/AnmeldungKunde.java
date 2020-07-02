package Funktionen;

import java.util.List;

import valueobjects.Kunde;
import exceptions.FlascheAnmeldedatenException;

public class AnmeldungKunde {
	public AnmeldungKunde() {}
	
	private int aktuelleNummer;
	
	public boolean anmeldung(List<Kunde> liste, String username, String passwort) throws FlascheAnmeldedatenException {
		for(Kunde k : liste) {
			if(!(k.getUsername().equals(username) && k.getPasswort().equals(passwort))) {
				throw new FlascheAnmeldedatenException("Benutzername oder Passwort sind falsch!");	
			} else {
				aktuelleNummer = k.getKundenNr();
				return true;
				
			}
		}
		return false;
	}
	
	public int getNummer() {return aktuelleNummer;} //gibt die Kundennummer zurück;
	
}
