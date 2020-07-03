package Exceptions;
/**
 * Exception f�r Fehlerhafte Artikelnummern
 * @author Mario
 *
 */
public class InvalidNameChangelogException extends Exception {
	
	public InvalidNameChangelogException() {
		super("Falscher Name!");
	}
	public InvalidNameChangelogException(String s) {
		super(s);
	}
	
	
}
