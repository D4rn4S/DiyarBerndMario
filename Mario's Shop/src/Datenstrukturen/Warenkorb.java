package Datenstrukturen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warenkorb {


	private List<tempArtikel> warenkorbListe = new ArrayList<tempArtikel>();
	private List<Artikel> aListe;
	
	
	public Warenkorb (List<Artikel> aListe) {
		this.aListe = aListe;
	}
	
	public void addArtikel(int aNummer, int aAnz) { //artikel dem Warenkorb hinzufügen
		Iterator<Artikel> iter = this.aListe.iterator();
		tempArtikel t;
		
		while(iter.hasNext()) {
			Artikel a = iter.next();
			if(a.getNummer()==aNummer) {
				System.out.println(a);
				if(warenkorbListe.contains(new tempArtikel(a, aAnz))) { //prüfen ob der Artikel bereits im Warenkorb ist (fehlerhaft)
					t = warenkorbListe.get(warenkorbListe.indexOf(a)); //get gibt ein objekt aus einer Liste zurück, indexof liefert dir die stelle in einer Liste von einen Objekt
					System.out.println("bereits vorhanden"); //nur zum testen
					
				} else {
					if(a.getBestand()>=aAnz) {
						warenkorbListe.add(new tempArtikel(a, aAnz));
						System.out.println("noch nicht vorhanden"); //nur zum testen
					} else {
						System.out.println("Es sind nicht genügend Artikel im Lager..");
					}
				}
				
			}
		}
	} 
	
	public void delArtikel(int aNummer, int aAnz) { //artikel aus dem Warenkorb entfernen
		Iterator<tempArtikel> iter = this.warenkorbListe.iterator();
		while(iter.hasNext()) {
			tempArtikel t = iter.next();
			if(t.getArtikel().getNummer()==aNummer) { //Artikel ist im Warenkorb vorhanden
				if(t.getAnzahl()==aAnz) { //Artikel soll komplett gelöscht werden
					warenkorbListe.remove(t);
				} else if(t.getAnzahl()>aAnz){ //Die Anzahl im Warenkorb soll veringert werden
					t.setAnzahl(t.getAnzahl()-aAnz);
				} else {
					System.out.println("Es können nicht mehr Artikel gelöscht werden, als vorhanden sind.");
				}
			} else { //Artikel war gar nicht im Warenkorb
				System.out.println("Dieser Artikel ist nicht im Warenkorb.");
			}
		}
		
	} 
	
	public void anzeigen() {  //warenkorb ausgeben
		for( tempArtikel a : warenkorbListe) {
			System.out.println(a);
		}
	}

	
	
	public void leeren() {  //warenkorb leeren
		warenkorbListe.removeAll(warenkorbListe);		
	}
	
	public void kaufen() {  //artikel aus dem Warenkorb kaufen
		
		for(tempArtikel a : warenkorbListe) { //jeden Artikel aus dem Warenkorb durchgehen
			if(aListe.contains(a.getArtikel())){ //nachschauen ob die Artikel aus dem Warenkorb auch in der Artikelliste sind
				Iterator<Artikel> iter = this.aListe.iterator(); //in der Artikelliste nach dem Artikel suchen der in der for schleife ausgewählt ist
				while(iter.hasNext()) { 
					Artikel t = iter.next();
					if(t.getNummer()==a.getArtikel().getNummer()) { //abgleich der Listen ob beide das gleiche objekt ausgewählt haben
						t.setBestand(t.getBestand() - a.getAnzahl()); //den bestand im Lager verringern
						System.out.println(t);
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
