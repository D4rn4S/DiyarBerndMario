package exceptions;
/**
 * Exception f�r Fehlerhafte Artikelnummern
 * @author Mario
 *
 */
public class InvalidArtikelNummerException extends Exception {
	
	public InvalidArtikelNummerException() {
		super("Fehlerhafte Artikelnummer");
	}
	public InvalidArtikelNummerException(String s) {
		super(s);
	}
	
	
}
