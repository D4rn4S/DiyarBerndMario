

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;




public class EshopClient {

	// Datenstrukturen für die Kommunikation
	private Socket socket = null;
	private BufferedReader in;
	private PrintStream out;

	/**
	 * KonstruktorVerbindung zum Server aufbaut (Socket) und dieser
	
	 */
	
	
	public EshopClient(String host, int port) {
		try {
			// Socket-Objekt fuer die Kommunikation mit Host/Port erstellen
			socket = new Socket(host, port);
			
			// Stream-Objekt fuer Text-I/O ueber Socket erzeugen
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			System.err.println("Fehler beim Öffnen des Sockets/Streams: " + e);
			// Wenn im "try"-Block Fehler auftreten, dann Socket schließen:
			if (socket != null) {
				try {
					socket.close();
					System.err.println("Socket geschlossen");
				} catch (IOException ioe) { /* Fehlerbehandlung */ }
			}
			System.exit(1);
		}
		
		// Verbindung erfolgreich hergestellt: IP-Adresse und Port ausgeben
		System.err.println("Verbunden mit Server " 
				+ socket.getInetAddress() + ":" + socket.getPort());	

		// Begrüßungsmeldung vom Server lesen
		try {
			String message = in.readLine();
			System.out.println(message);
		} catch (IOException e) { /* Fehlerbehandlung */ }
	}

	
	private void suchen(String name) {
		out.println("suchen");
		out.println(name);
		
		try {
			String aname = in.readLine();
			if (!aname.equals("Fehler")) {
				int anummer = Integer.parseInt(in.readLine());
				String akategorie = in.readLine();
				
				Artikels a = new Artikels(aname, anummer,akategorie);
				System.out.println("Die Adresse von " + name + " lautet: " + a);
			}
			else {
				System.out.println("Kein Eintrag unter diesem Namen.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void quit() {
		out.println("quit");
		
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		// Client starten und mit Server verbinden:
		EshopClient client = new EshopClient(host, port);
		// Ein paar Aufrufe von Diensten zum Testen:
		client.suchen("Skateboard");
		client.suchen("Waschgel");
		client.suchen("Auto");
		client.suchen("PC");
		client.quit();
	}
}

