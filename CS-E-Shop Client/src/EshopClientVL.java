import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;




public class EshopClientVL {

	// Datenstrukturen für die Kommunikation
	private Socket socket = null;
	private BufferedReader in;
	private PrintStream out;

	
	public EshopClientVL(String host, int port) throws IOException {
		// Verbindung zum Server aufnehmen und Streams initialisieren
		socket = new Socket(host, port);

		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintStream(socket.getOutputStream());

		// Erste Kommunikation mit dem Server...
		String welcome = in.readLine();
		System.out.println("Server sent welcome message: " + welcome);
	}

	private void suchen(String name) {
		// Such-Kommando abschicken und Resultat ausgeben
		out.println("suchen");
		out.println(name);

		try {
			String aname = in.readLine();
			if (!aname.equals("Fehler")) {
				int anummer = Integer.parseInt(in.readLine());
				String akategorie = in.readLine();
				Artikels artikel = new Artikels(aname, anummer, akategorie);

				System.out.println(name + " gehört zur Kategorie " + artikel);
			} else {
				System.out.println("Es gibt kein " + name + "artikel");
			}
		} catch (IOException ioe) {
			System.out.println("Das hat nicht geklappt.");
		}
	}

	private void quit() {
		// Quit-Kommando abschicken und Sockets schließen
		out.println("quit");

		try {
			socket.close();
		} catch (IOException ioe) {
			// Fehlerbehandlung
		}
	}

	/**
	 * main()-Methode zum Starten des Clients
	 * 
	 * @param args kann optional Host und Portnummer enthalten, auf der Verbindungen entgegengenommen werden sollen
	 */
	public static void main(String[] args) {
		String host = "localhost";
		int port = 6666;
		if (args.length == 2) {
			host = args[0];
			try {
				port = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				port = 0;
			}
		}

		// Client starten und mit Server verbinden
		try {
			EshopClientVL client = new EshopClientVL(host, port);

			// TODO: Testaufrufe über Client an Server schicken
			client.suchen("waschgel");
			client.suchen("bmx");
			client.suchen("electronics");
			client.quit();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
