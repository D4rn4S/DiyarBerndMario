package exceptions;
/**
 * Exception für Fehlerhafte KundenNummern
 * @author Mario
 *
 */
public class InvalidKundenNummerException extends Exception{

	public InvalidKundenNummerException() {
		super("Fehlerhafter KundenNr!");
	}
	public InvalidKundenNummerException(String s) {
		super(s);
	}
	
}
