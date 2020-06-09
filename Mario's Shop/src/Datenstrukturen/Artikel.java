package Datenstrukturen;

public class Artikel {

	private String name;
	private int nummer;
	private double preis;
	private int bestand;
	private int mindestbestand;
	
	
	public Artikel(String name, int nummer, double preis, int bestand, int mindestbestand) {
		this.nummer = nummer;
		this.name = name;
		this.preis = preis;
		this.bestand = bestand;
		this.mindestbestand = mindestbestand;
	}
	
	/*public Artikel(String name, int nummer, double preis, int bestand, int mindestbestand) {
		this(name, nummer, preis, mindestbestand);
	}*/
	
	public String toString() {
		return ("Name: " + name + " | Nummer: " + nummer + " | Preis: " + preis + " | Bestand: " + bestand);
	}
	

	
	
	public boolean euqals(Object andereArtikel) {
		if (andereArtikel instanceof Artikel) {
			return (this.nummer == ((Artikel) andereArtikel).nummer) 
					&& (this.name.equals(((Artikel) andereArtikel).name));
		} else {
			return false;
		}
		
	}
	
	
	public boolean verfuegbar(Artikel a) {
		if (a.getBestand() < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//getter Methoden
	
	public String getName() {return name;}
	
	public int getNummer() {return nummer;}
	
	public double getPreis() {return preis;}
	
	public int getBestand() {return bestand;}
	
	public int getMindestbestand() { return mindestbestand;}
	
	//setter Methoden
	
	public void setBestand(int neuBestand) { this.bestand = neuBestand;} 
	
	
}
