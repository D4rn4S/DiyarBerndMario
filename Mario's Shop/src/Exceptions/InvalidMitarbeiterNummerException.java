package Exceptions;

public class InvalidMitarbeiterNummerException extends Exception {

	public InvalidMitarbeiterNummerException() {
		super("Fehlerhafter MitarbeiterNr!");
	}
	public InvalidMitarbeiterNummerException(String s) {
		super(s);
	}
	
}
