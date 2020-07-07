import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Hashtable;



/**
 * Klasse zur Verarbeitung der Kommunikation zwischen EINEM Client und dem
 * Server. Die Kommunikation folgt dabei dem "Protokoll" der Anwendung. Das
 * ClientAdressRequestProcessor-Objekt führt folgende Schritte aus: 
 * 0. Begrüßungszeile an den Client senden
 * Danach in einer Schleife:
 * 1. Empfang einer Zeile vom Client (z.B. Aktionsauswahl, hier eingeschränkt); 
 *    wenn der Client die Abbruchaktion sendet ('q'), wird die Schleife verlassen
 * 2. abhängig von ausgewählter Aktion Empfang weiterer Zeilen 
 *    (Parameter für ausgewählte Aktion)
 * 3. Senden der Antwort an den Client; die Antwort besteht je nach Aktion 
 *    aus einer oder mehr Zeilen
 * 
 * @author teschke
 */
class ClientEshopRequestProcessor {

	// Referenz auf das serverseitige Adressbuch
	private Hashtable<String, Artikels> artikels;

	// Datenstrukturen für die Kommunikation
	private Socket clientSocket;
	private BufferedReader in;
	private PrintStream out;	// nicht Writer, damit auch telnet-Client mit Server kommunizieren kann


	/**
	 * @param socket Referenz auf Socket-Objekt, über das mit dem Client kommuniziert werden soll
	 * @param adressdaten Referenz auf die Adressdaten (statt Datenbank o.ä.)
	 */
	public ClientEshopRequestProcessor
		(Socket socket, Hashtable<String, Artikels> artikelsdaten) {

		// Verbindungsdaten übernehmen
		clientSocket = socket;

		// Referenz auf Server-Adressbuch merken
		this.artikels = artikelsdaten;

		// I/O-Streams initialisieren:
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			try {
				clientSocket.close();
			} catch (IOException e2) {
			}
			System.err.println("Ausnahme bei Bereitstellung des Streams: " + e);
			return;
		}

		System.out.println("Verbunden mit Client " 
				+ clientSocket.getInetAddress() + ":" + clientSocket.getPort());
	}

	/**
	 * Methode zur Abwicklung der Kommunikation mit dem Client gemäß dem
	 * vorgebenen Kommunikationsprotokoll.
	 */
	public void verarbeiteAnfragen() {

		String input = "";

		// Begrüßungsnachricht an den Client senden
		out.println("Server bereit");

		// Hauptschleife zur wiederholten Abwicklung der Kommunikation
		do {
			// Beginn der Benutzerinteraktion:
			// Aktion vom Client einlesen [dann ggf. weitere Daten einlesen ...]
			try {
				input = in.readLine();
			} catch (Exception e) {
				System.out.println("--->Fehler beim Lesen vom Client (Aktion): ");
				System.out.println(e.getMessage());
				continue;
			}

			// Eingabe bearbeiten:
			if (input == null) {
				// input wird von readLine() auf null gesetzt, wenn Client Verbindung abbricht
				// Einfach behandeln wie ein "quit"
				input = "quit";
			} else if (input.equals("suchen")){
				suchen();
			} else if (input.equals("quit")) {
				// nichts tun, Schleifenende
			}
		} while (!(input.equals("quit")));
		
		System.out.println("Verbindung zu " + clientSocket.getInetAddress()
				+ ":" + clientSocket.getPort() + " durch Client abgebrochen");

		// Verbindung beenden
		try {
			clientSocket.close();
		} catch (IOException e2) {
		}
	}

	private void suchen() {
		String aname = "";
		// lies den Namen ein, zu dem die Adressdaten ermittelt werden sollen
		try {
			aname = in.readLine();
		} catch (Exception e) {
			System.out.println("--->Fehler beim Lesen vom Client (Name): ");
			System.out.println(e.getMessage());
		}

//		// Suche nach Adresse-Objekt in Hashtable
//		if (artikels.containsKey(aname)) {
//			Artikels artikels = artikels.getaName();
//			// Straße senden
//			out.println(adresse.getStrasse());
//			// PLZ senden
//			out.println(adresse.getPlz());
//			// Wohnort senden
//			out.println(adresse.getWohnort());
//		} else {
//			out.println("Fehler");
//		}
	}
}
