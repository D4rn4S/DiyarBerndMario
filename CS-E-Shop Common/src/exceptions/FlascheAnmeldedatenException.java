package exceptions;

/**
 * Exception für falsche Anmeldedaten
 * @author Mario
 *
 */
public class FlascheAnmeldedatenException extends Exception {
	public FlascheAnmeldedatenException(String s) {
		super(s);
	}
}
