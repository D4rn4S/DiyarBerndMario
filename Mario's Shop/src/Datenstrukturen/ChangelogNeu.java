package Datenstrukturen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class ChangelogNeu {

		private Mitarbeiter m;
		private Kunde k;
		private String message;
		private String strDate;
		private boolean typ; //true: Mitarbeiter | false: Kunde
		private String Zeit;
		
		public ChangelogNeu(Mitarbeiter m, String message, boolean typ) {
			this.m = m;
			this.message = message;
			this.typ = typ;
			
			Date date = Calendar.getInstance().getTime();  
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
	        String Zeit = dateFormat.format(date);  
	        this.Zeit = Zeit;
		}
		
		public ChangelogNeu(Kunde k, String nachricht, boolean typ) {
			this.k = k;
			this.message = message;
			this.typ = typ;
			Date date = Calendar.getInstance().getTime();  
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
	        String Zeit = dateFormat.format(date);  
	        this.Zeit = Zeit;
		}
		
		public ChangelogNeu(Mitarbeiter m, String message, boolean typ, String Zeit) {
			this.m = m;
			this.message = message;
			this.typ = typ;
			this.Zeit = Zeit;
		}
		
		public ChangelogNeu(Kunde k, String nachricht, boolean typ, String Zeit) {
			this.k = k;
			this.message = message;
			this.typ = typ;
			this.Zeit = Zeit;
		}
		
		/*
		public String toString() {	
			return("" + this.Zeit + " | Mitarbeiter: " + m.getMitarbeiterNr() + "|" + m.getVorname() + "|" + m.getNachname() + "| Nachricht: " + message);
		}
		
		public String toStrting() {
			return("" + this.Zeit + " | Kunde: " + k.getKundenNr() + "|" + k.getVorname() + "|" + k.getNachname() + "| Nachricht: " + message);
		} */
		
		//getter Methoden
		
		public Mitarbeiter getMitarbeiter() { return this.m; }
		
		public Kunde getKunde() {return this.k;}
		
		public String getMessage() { return message;}
		
		public String getZeit() {return this.Zeit;}
		
		public boolean getTyp() { return this.typ;}
		
			
}