package Exceptions;

/**
 * Exception für die Suche im Warenkorb fals ein falscher Name eingeben wird.
 * @author Mario
 *
 */
public class InvalidWarenkorbNameException extends Exception{

	
	public InvalidWarenkorbNameException() {
		super("Fehlerhafter Eingabe!");
	}
	public InvalidWarenkorbNameException(String s) {
		super(s);
	}
	
}
