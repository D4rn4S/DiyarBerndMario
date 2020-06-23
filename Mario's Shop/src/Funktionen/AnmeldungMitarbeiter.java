package Funktionen;

import java.util.List;

import Datenstrukturen.Mitarbeiter;
import Exceptions.FlascheAnmeldedatenException;

public class AnmeldungMitarbeiter {
	public AnmeldungMitarbeiter() {}
	
	public boolean anmeldung(List<Mitarbeiter> liste, String username, String passwort) throws FlascheAnmeldedatenException {
		for(Mitarbeiter m : liste) {
			if(!(m.getUsername().equals(username) && m.getPasswort().equals(passwort))) {
				throw new FlascheAnmeldedatenException("Benutzername oder Passwort sind falsch!");	
			} else {
				return true;
			}
		}
		return false;
	}
	
	
}
