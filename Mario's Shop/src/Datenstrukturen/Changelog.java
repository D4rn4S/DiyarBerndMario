package Datenstrukturen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Changelog {

		private Mitarbeiter m;
		private Kunde k;
		private String message;
		private String strDate;
		private boolean typ; //true: Mitarbeiter | false: Kunde
		private String Zeit;
		
		/***
		 * Konstruktor um einen neuen Changelog als MItarbeiter zu erzeugen
		 * @param m
		 * @param message
		 * @param typ
		 */
		public Changelog(Mitarbeiter m, String message, boolean typ) {
			this.m = m;
			this.message = message;
			this.typ = typ;
			
			Date date = Calendar.getInstance().getTime();  
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
	        String Zeit = dateFormat.format(date);  
	        this.Zeit = Zeit;
		}
		
		/**
		 * Konstruktor um einen neuen Changelog als Kunde zu erzeugen
		 * @param k
		 * @param message
		 * @param typ
		 */
		public Changelog(Kunde k, String message, boolean typ) {
			this.k = k;
			this.message = message;
			this.typ = typ;
			Date date = Calendar.getInstance().getTime();  
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
	        String Zeit = dateFormat.format(date);  
	        this.Zeit = Zeit;
		}
		
		/**
		 * Konstruktor wenn der Changelog aus der Datei geladen wird
		 * @param m
		 * @param message
		 * @param typ
		 * @param Zeit
		 */
		public Changelog(Mitarbeiter m, String message, boolean typ, String Zeit) {
			this.m = m;
			this.message = message;
			this.typ = typ;
			this.Zeit = Zeit;
		}
		
		/**
		 * KOnstrukotr wenn der Changelog aus der Datei geladen wird
		 * @param k
		 * @param message
		 * @param typ
		 * @param Zeit
		 */
		public Changelog(Kunde k, String message, boolean typ, String Zeit) {
			this.k = k;
			this.message = message;
			this.typ = typ;
			this.Zeit = Zeit;
		}
		
		/**
		 * toString für das ausgeben von einen Log in der Console
		 */
		public String toString() {	
			return("Nachricht: " + message);
		}
		
		//getter Methoden
		
		public Mitarbeiter getMitarbeiter() { return this.m; }
		
		public Kunde getKunde() {return this.k;}
		
		public String getMessage() { return message;}
		
		public String getZeit() {return this.Zeit;}
		
		public boolean getTyp() { return this.typ;}
		
			
}