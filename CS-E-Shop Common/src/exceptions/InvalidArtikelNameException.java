package exceptions;
/**
 * Exception f�r Fehlerhafte Artikelnamen
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
