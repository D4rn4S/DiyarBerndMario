package Datenstrukturen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author Mario
 *
 */
public class Warenkorb {


	private List<tempArtikel> warenkorbListe = new ArrayList<tempArtikel>();
	private List<Artikel> aListe;
	
	
	public Warenkorb (List<Artikel> aListe) {
		this.aListe = aListe;
	}
	/**
	 * F�gt einen Artikel den WArenkorb hinzu. Es wird gepr�ft ob ein Artikel bereits im Warenkorb ist, ist jedoch noch fehlerhaft.
	 * @param aNummer
	 * @param aAnz
	 */
	public void addArtikel(int aNummer, int aAnz) { //artikel dem Warenkorb hinzuf�gen
		Iterator<Artikel> iter = this.aListe.iterator();
		tempArtikel t;
		
		while(iter.hasNext()) {
			Artikel a = iter.next();
			if(a.getNummer()==aNummer) {
				if(warenkorbListe.contains(new tempArtikel(a, aAnz))) { //pr�fen ob der Artikel bereits im Warenkorb ist (fehlerhaft)
					t = warenkorbListe.get(warenkorbListe.indexOf(a)); //get gibt ein objekt aus einer Liste zur�ck, indexof liefert dir die stelle in einer Liste von einen Objekt
					System.out.println("bereits vorhanden"); //nur zum testen
					
				} else {
					if(a.getBestand()>=aAnz) {
						warenkorbListe.add(new tempArtikel(a, aAnz));
						System.out.println("noch nicht vorhanden"); //nur zum testen
					} else {
						System.out.println("Es sind nicht gen�gend Artikel im Lager..");
					}
				}
				
			}
		}
	} 
	
	/**
	 * l�scht einen Artikel aus dem Warenkorb, je nach dem wie gro� die ANzahl ist.
	 * @param aNummer
	 * @param aAnz
	 */
	public void delArtikel(int aNummer, int aAnz) { //artikel aus dem Warenkorb entfernen
		Iterator<tempArtikel> iter = this.warenkorbListe.iterator();
		while(iter.hasNext()) {
			tempArtikel t = iter.next();
			if(t.getArtikel().getNummer()==aNummer) { //Artikel ist im Warenkorb vorhanden
				if(t.getAnzahl()==aAnz) { //Artikel soll komplett gel�scht werden
					warenkorbListe.remove(t);
				} else if(t.getAnzahl()>aAnz){ //Die Anzahl im Warenkorb soll veringert werden
					t.setAnzahl(t.getAnzahl()-aAnz);
				} else {
					System.out.println("Es k�nnen nicht mehr Artikel gel�scht werden, als vorhanden sind.");
				}
			} else { //Artikel war gar nicht im Warenkorb
				System.out.println("Dieser Artikel ist nicht im Warenkorb.");
			}
		}
		
	} 
	
	/**
	 * gibt den Warenkorb in der Console aus.
	 */
	public void anzeigen() {  //warenkorb ausgeben
		for( tempArtikel a : warenkorbListe) {
			System.out.println(a);
		}
	}

	/**
	 * gibt die aktuelle Warenkobliste aus
	 * @return
	 */
	public List<tempArtikel> getWarenkorb(){
		return warenkorbListe;
	}
	
	/**
	 * durchsucht den Warenkorb nach einen Namen
	 * @param name
	 * @return
	 */
	public List<tempArtikel> sucheNachName(String name) {
		
		List<tempArtikel> suchErg = new ArrayList<tempArtikel>();
		Iterator<tempArtikel> iter = warenkorbListe.iterator();
		
		while(iter.hasNext()) {
			tempArtikel a = iter.next();
			if(a.getArtikel().getName().equals(name)) {
				suchErg.add(a);
			}
		}
		
		
		return suchErg; 
	}
	
	/**
	 * leer den Warenkorb
	 */
	public void leeren() {  //warenkorb leeren
		warenkorbListe.removeAll(warenkorbListe);		
	}
	
	/**
	 * um den Warenkorb zu kaufen
	 */
	public void kaufen() {  //artikel aus dem Warenkorb kaufen
		
		for(tempArtikel a : warenkorbListe) { //jeden Artikel aus dem Warenkorb durchgehen
			if(aListe.contains(a.getArtikel())){ //nachschauen ob die Artikel aus dem Warenkorb auch in der Artikelliste sind
				Iterator<Artikel> iter = this.aListe.iterator(); //in der Artikelliste nach dem Artikel suchen der in der for schleife ausgew�hlt ist
				while(iter.hasNext()) { 
					Artikel t = iter.next();
					if(t.getNummer()==a.getArtikel().getNummer()) { //abgleich der Listen ob beide das gleiche objekt ausgew�hlt haben
						t.setBestand(t.getBestand() - a.getAnzahl()); //den bestand im Lager verringern
						System.out.println(t);
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
