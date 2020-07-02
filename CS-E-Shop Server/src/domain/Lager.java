package domain;

import java.io.IOException;

import java.util.List;

import domain.LagerManager;
import valueobjects.Artikel;

public class Lager {

	private String datei = "";
	private LagerManager lagerManager;
	
	public Lager(String datei) throws IOException{
		this.datei = datei;
		lagerManager = new LagerManager();
		lagerManager.liesDaten(datei+"_S.txt");
	}
	
	
	public List<Artikel> gibAlleArtikel(){
		return lagerManager.getArtikelBestand();
	}
	
	
	public List<Artikel> sucheNachName(String name) {
		return lagerManager.suchArtikelName(name); 
	}
	
	public List<Artikel> sucheNachNummer(int nr) {
		return lagerManager.suchArtikelNr(nr); 
	}
	
	
	public Artikel fuegeArtikelEin(String name, int nummer, double preis, int bestand, int mindestbestand, int massengut){
		Artikel a = new Artikel(name, nummer, preis, bestand, mindestbestand, massengut);
		lagerManager.einfuegen(a);
		return a;
	}
	
	
	public void loescheArtikel(int nummer) {
		lagerManager.loeschen(nummer);
	}
	
	public void schreibeArtikel() throws IOException{
		lagerManager.schreibeDaten(datei+"_S.txt");
	}
	
	
	//muss noch ergänzt werden
	public void erhoeheArtikelbestand() {}
	
	
	
}
