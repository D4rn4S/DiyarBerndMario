package Datenstrukturen;

public class Person {
	private String vorname;
	private String strasse;
	private String plz;
	private String wohnort;
	private String nachname;
	private String username;
	private String passwort;
	
	
	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------- DIESE KLASSE WIRD NICHT MEHR BENÖTIGT------------------------------------------------------
	 * -------------------------------------------------------------------------------------------------------------------------------------------
	*/
	public Person(String username, String passwort, String vorname, String nachname, String wohnort, String plz, String strasse) {
		this.username = username;
		this.passwort = passwort;
		this.vorname = vorname;
		this.nachname = nachname;
		this.wohnort = wohnort;
		this.plz = plz;
		this.strasse = strasse;
	}
	
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


	
}
