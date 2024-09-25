package Main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Client_winery {
	
	private static final int SPORT = 4444;
	private static final String SHOST = "localhost";
	private static final int MAX = 100;
	
	public void run(final String TypeAccount) {
		
		try {
			Socket client = new Socket(SHOST, SPORT);
			
			ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream is = null;
			
			Random r = new Random();
			
			
			/* valutare l'utilizzo di un ciclo while.
			while (true) {
				//istruzioni a seconda dell'account che effettua il login.
				Request req = new Request(r.nextInt(MAX));
				
				
			}
			*/
			client.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// esegui meccanismo di autenticazione o registrazione.
		
		
		//esegui client (il client prende come argomento la tipologia di account per richiedere una determinata interfaccia al server.
		
		
		String TypeAccount = "ciao";
		new Client_winery().run(TypeAccount);
	}

}
