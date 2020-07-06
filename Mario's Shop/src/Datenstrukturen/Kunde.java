package Datenstrukturen;

public class Kunde {
	
	private int KundenNr;
	private String username;
	private String passwort;
	private String vorname;
	private String nachname;
	private String wohnort;
	private String plz;
	private String strasse;
	
	/**
	 * Konstruktor um einen Kunden zu erstellen.
	 * @param username
	 * @param passwort
	 * @param vorname
	 * @param nachname
	 * @param wohnort
	 * @param plz
	 * @param strasse
	 * @param KundenNr
	 */
	public Kunde(String username, String passwort, String vorname, String nachname, String wohnort, String plz, String strasse, int KundenNr) {
		//super(username, passwort, vorname, nachname, wohnort, plz, strasse);
		this.KundenNr = KundenNr;
		this.username = username;
		this.passwort = passwort;
		this.vorname = vorname;
		this.nachname = nachname;
		this.wohnort = wohnort;
		this.plz = plz;
		this.strasse = strasse;
	}
	public int getKundenNr() { return KundenNr;}
	
	public void setKundenNr(int KundenNr) { this.KundenNr = KundenNr;}
	
	public String getVorname() {return vorname;}
	
	public String getNachname() {return nachname;}
	
	public String getStrasse() {return strasse;}
	
	public String getPlz() {return plz;}
	
	public String getWohnort() {return wohnort;}
	
	public String getUsername() {return username;}
	
	public String getPasswort() {return passwort;}
	
	public void setVorname(String vorname) {this.vorname = vorname;}
	
	public void setNachname(String nachname) {this.nachname = nachname;}
	
	public void setStrasse(String strasse) {this.strasse = strasse;}
	
	public void setPlz(String plz) {this.plz = plz;}
	
	public void setWohnort(String wohnort) {this.wohnort = wohnort;}
	
	public void setUsername(String username) {this.username = username;}
	
	public void setPasswort(String passwort) {this.passwort = passwort;}
	
	/**
	 * toString Methode um einen Kunden in der Console aus zu geben
	 */
	public String toString() {
		return ("Kürzel: " + username + " | Passwort: " + passwort + " | Vorname: " + vorname + " | Nachname: " + nachname + " | Wohnort: " + wohnort + " | Postleitzahl: " + plz + " | Strasse: " + strasse + " | KundenNr: "+ KundenNr);
	}
		
}
