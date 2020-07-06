package Funktionen;

import java.util.List;

import Datenstrukturen.Kunde;
import Datenstrukturen.Mitarbeiter;
import Exceptions.FlascheAnmeldedatenException;

public class AnmeldungKunde {
	public AnmeldungKunde() {}
	
	private int aktuelleNummer;
	
	public boolean anmeldung(List<Kunde> liste, String username, String passwort) throws FlascheAnmeldedatenException {
		boolean x = false;
		for(Kunde k : liste) {
			if(!(k.getUsername().equals(username) && k.getPasswort().equals(passwort))) {
				x = false;
			} else {
				aktuelleNummer = k.getKundenNr();
				x = true;
				return true;
				
			}
		}
		if(!x) {
			throw new FlascheAnmeldedatenException("Benutzername oder Passwort sind falsch!");	
		}
		return false;
	}
	
	public int getNummer() {return aktuelleNummer;} //gibt die Kundennummer zurück;
	
}
