package valueobjects;
/**
 * 
 * @author Mario
 *
 */
public class tempArtikel {

	//private double preis;
	//private double zwischenpreis;
	private int anzahl;
	private Artikel a;
	/**
	 * Beschriebung: ein TempArtikel beinhaltet einen Artikel und eine Anzahl. Die Anzahl gibt an wie oft sich dieser im Warenkorb befindet.
	 * @param a
	 * @param anzahl
	 */
	public tempArtikel(Artikel a, int anzahl) {
		this.anzahl = anzahl;
		this.a = a;
	}
	
	public boolean euqals(Object o) {
		System.out.println("call");
		if (o instanceof tempArtikel) {
			System.out.println("equals");
			return (this.a.getNummer() == ((tempArtikel) o).getArtikel().getNummer()); 
		} else {
			return false;
		}
		
	}
	
	/**
	 * gibt an wie ein Temp artikel ausgegeben werden soll (als String)
	 */
	public String toString() {
		double gPreis;
		gPreis = (this.a.getPreis()*this.anzahl);
		return (this.a.toString() + " | Anzahl: " + anzahl + " | Stückpreis: " + this.a.getPreis() + "€ | Preis: " + gPreis + "€");
	}
	
	//getter Methoden
	public Artikel getArtikel() {return this.a;}
	
	public int getAnzahl() {return this.anzahl;}
	
	//setter Methoden
	
	public void setAnzahl(int zahl) {this.anzahl = zahl;}
	
}
