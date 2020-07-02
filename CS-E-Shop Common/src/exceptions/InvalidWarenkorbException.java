package exceptions;

/**
 * Exception für Fehlerhafte eingaben im Warenkorb
 * @author Mario
 *
 */
public class InvalidWarenkorbException extends Exception {

	public InvalidWarenkorbException() {
		super("Fehlerhafter Eingabe!");
	}
	public InvalidWarenkorbException(String s) {
		super(s);
	}
	
	
	
}
