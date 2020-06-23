package Funktionen;

import java.util.List;

import Datenstrukturen.Kunde;
import Datenstrukturen.Mitarbeiter;
import Exceptions.FlascheAnmeldedatenException;

public class AnmeldungKunde {
	public AnmeldungKunde() {}
	
	public boolean anmeldung(List<Kunde> liste, String username, String passwort) throws FlascheAnmeldedatenException {
		for(Kunde k : liste) {
			if(!(k.getUsername().equals(username) && k.getPasswort().equals(passwort))) {
				throw new FlascheAnmeldedatenException("Benutzername oder Passwort sind falsch!");	
			} else {
				return true;
			}
		}
		return false;
	}
	
	
}
