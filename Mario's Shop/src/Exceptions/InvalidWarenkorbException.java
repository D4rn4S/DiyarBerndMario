package Exceptions;

public class InvalidWarenkorbException extends Exception {

	public InvalidWarenkorbException() {
		super("Fehlerhafter Eingabe!");
	}
	public InvalidWarenkorbException(String s) {
		super(s);
	}
	
	
	
}
