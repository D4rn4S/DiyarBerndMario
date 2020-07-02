package exceptions;
/**
 * Exception für Fehlerhafte Artikelnamen
 * @author Mario
 *
 */
public class InvalidArtikelNameException extends Exception {

	public InvalidArtikelNameException() {
		super("Fehlerhafter ArtikelName");
	}
	public InvalidArtikelNameException(String s) {
		super(s);
	}
	
	
}
