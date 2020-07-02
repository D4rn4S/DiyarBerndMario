package exceptions;
/**
 * Exception für Fehelrhafte Mitarbeiternummern
 * @author Mario
 *
 */
public class InvalidMitarbeiterNummerException extends Exception {

	public InvalidMitarbeiterNummerException() {
		super("Fehlerhafter MitarbeiterNr!");
	}
	public InvalidMitarbeiterNummerException(String s) {
		super(s);
	}
	
}
