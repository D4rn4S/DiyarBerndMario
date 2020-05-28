package Datenstrukturen;


import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Changelog {

Logger logger;
FileHandler fh;

	
	public Changelog() {
		schreibeLog("Das Programm wird gestartet.");
	}
		

	
	public void gibChangelogAus(List<String> changes) {
		System.out.println(changes);
	}
	
	public void schreibeLog(String inhalt) {
		Logger logger = Logger.getLogger("Shop-Log");
		
		try {  
	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:/Users/Mario/eclipse-workspace/Mario's Shop/Log_S.txt");  
	        logger.addHandler(fh); //Dem Logger dem Dateihandler zuweisen
	        logger.setUseParentHandlers(false); //verhindern das der Log in der Console erscheint
	        SimpleFormatter formatter = new SimpleFormatter();   //das Datumsformat festlegen
	        fh.setFormatter(formatter);  //das Datumsformat festlegen

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
		logger.info(inhalt);
	}
}