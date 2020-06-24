package Exceptions;

public class InvalidWarenkorbNameException extends Exception{

	
	public InvalidWarenkorbNameException() {
		super("Fehlerhafter Eingabe!");
	}
	public InvalidWarenkorbNameException(String s) {
		super(s);
	}
	
}
