package Exceptions;

public class InvalidArtikelNameException extends Exception {

	public InvalidArtikelNameException() {
		super("Fehlerhafter ArtikelName");
	}
	public InvalidArtikelNameException(String s) {
		super(s);
	}
	
	
}
