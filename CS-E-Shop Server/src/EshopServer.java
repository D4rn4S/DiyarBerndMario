import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;



public class EshopServer { 					
	
	public final static int DEFAULT_PORT = 6666;

	private int port;
	private ServerSocket serverSocket;

	// Datenstruktur für  Eshop Artikels
	private Hashtable<String, Artikels> artikels;

	
	
	public EshopServer(int optPort) {

		this.port = (optPort == 0) ? DEFAULT_PORT : optPort;
		
		try {
			// Server-Socket anlegen
			serverSocket = new ServerSocket(port);
			
			// Serverdaten ausgeben
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println("Host: " + ia.getHostName());
			System.out.println("Server *" + ia.getHostAddress()	+ "* lauscht auf Port " + port);
		} catch (IOException e) {
			System.err.println("Eine Ausnahme trat beim Anlegen des Server-Sockets auf: " + e);
			System.exit(1);
		}

		// Interne Adress(test)daten erzeugen
		artikels = new Hashtable<String, Artikels>();
		artikels.put("Meier", new Artikels("Computer", 19, "Electronic"));
		artikels.put("Schmidt", new Artikels("Waschgel ", 31, "Reinigung"));
		artikels.put("Hinz", new Artikels("Pipe", 420, "Tabak"));
		artikels.put("Kunz", new Artikels("Skateboard", 33, "Extremesports"));
	}

	
public void acceptClientConnectRequests() {

try {
while (true) {
// socket wartet auf Verbindungen
Socket clientSocket = serverSocket.accept();
ClientEshopRequestProcessor c 
= new ClientEshopRequestProcessor(clientSocket, artikels);
c.verarbeiteAnfragen();

}
} catch (IOException e) {
System.err.println("Fehler während des Wartens auf Verbindungen: " + e);
System.exit(1);
}
}



public static void main(String[] args) {
		int port = 0;
		if (args.length == 1) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				port = 0 ;
			}
		}
		EshopServer server = new EshopServer(port);
		// Ab jetzt auf eingehende Verbindungswünsche von Clients warten
		server.acceptClientConnectRequests();
	}
}

