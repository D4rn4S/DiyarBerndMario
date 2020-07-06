package Datenstrukturen;

import java.io.IOException;

import java.util.List;

import Manager.LagerManager;

public class Lager {

	private String datei = "";
	private LagerManager lagerManager;
	
	/**
	 * Konstruktor f�r das Lager. Das Lager dient als Schnittstelle zwischen dem LagerManager und GUI
	 * @param datei
	 * @throws IOException
	 */
	public Lager(String datei) throws IOException{
		this.datei = datei;
		lagerManager = new LagerManager();
		lagerManager.liesDaten(datei+"_S.txt");
	}
	
	/**
	 * ruft den Lagermanager auf, welcher den Artikelbestand zur�ckgibt
	 * @return gibt den Aktuellen Artikelbestand zur�ck
	 */
	public List<Artikel> gibAlleArtikel(){
		return lagerManager.getArtikelBestand();
	}
	
	/**
	 * �bergibt dem lagermanager einen Namen, dieser gibt eine Liste mit dem Ergebnis zur�ck
	 * @param name
	 * @return
	 */
	public List<Artikel> sucheNachName(String name) {
		return lagerManager.suchArtikelName(name); 
	}
	
	/**
	 * �bergibt dem Lagermanager eine nr, dieser gibt eine Liste mit dem Ergebnis zur�ck
	 * @param nr
	 * @return
	 */
	public List<Artikel> sucheNachNummer(int nr) {
		return lagerManager.suchArtikelNr(nr); 
	}
	
	/**
	 * erstellt einen neuen Artikel und l�sst diesen vom lagermanager in den Artikelbestand einf�gen
	 * @param name
	 * @param nummer
	 * @param preis
	 * @param bestand
	 * @param mindestbestand
	 * @param massengut
	 * @return
	 */
	public Artikel fuegeArtikelEin(String name, int nummer, double preis, int bestand, int mindestbestand, int massengut){
		Artikel a = new Artikel(name, nummer, preis, bestand, mindestbestand, massengut);
		lagerManager.einfuegen(a);
		return a;
	}
	
	/**
	 * �bergibt dem Lagermanager eine NUmmer, dieser sucht nach dem Artikel mit der Nummer und l�scht diesen
	 * @param nummer
	 */
	public void loescheArtikel(int nummer) {
		lagerManager.loeschen(nummer);
	}
	
	/**
	 * der lagermanager schreibt alle Daten in die TXT datei
	 * @throws IOException
	 */
	public void schreibeArtikel() throws IOException{
		lagerManager.schreibeDaten(datei+"_S.txt");
	}
	
	
}
