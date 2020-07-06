package Funktionen;

import java.util.List;

import Datenstrukturen.Mitarbeiter;
import Exceptions.FlascheAnmeldedatenException;

public class AnmeldungMitarbeiter {
	public AnmeldungMitarbeiter() {}
	
	private int aktuelleNummer;
	
	/**
	 * Überprüft die Benutzerdaten, falls diese stimmen wird true zurückgegeben, falls nicht wird eine exception geworfen
	 * @param liste
	 * @param username
	 * @param passwort
	 * @return
	 * @throws FlascheAnmeldedatenException
	 */
	public boolean anmeldung(List<Mitarbeiter> liste, String username, String passwort) throws FlascheAnmeldedatenException {
		boolean x = false;
		for(Mitarbeiter m : liste) {
			if(!(m.getUsername().equals(username) && m.getPasswort().equals(passwort))) {
				x = false;
			} else {
				aktuelleNummer = m.getMitarbeiterNr();
				x = true;
				return true;
			}
		}
		if(!x) {
			throw new FlascheAnmeldedatenException("Benutzername oder Passwort sind falsch!");	
		}
		return false;
	}
	
	public int getNummer() {return aktuelleNummer;} //gibt die Aktuelle Mitarbeiternummer zurück
	
}
