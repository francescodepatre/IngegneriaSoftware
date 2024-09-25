package Main;

import java.net.*;
import java.io.*;
import Operations.*;
import Interfaces.*;

public class Client {
	private static final int SPORT = 2222;
	private static final String SHOST = "localhost";
	
	public void run() {
		
		//new Main_interface().start(null);
		
		int uid = new Login().Login_mechanism();
		
		
		try {
			System.out.println("Uid: "+ uid);
			System.out.println("CLIENT: Creating a socket.");
			
			Socket server = new Socket(SHOST,SPORT);
			
			System.out.println("CLIENT: Requesting interface.");
			System.out.println("CLIENT: uid = "+ uid);
			
			DataOutputStream dos = new DataOutputStream(server.getOutputStream());
			dos.writeInt(uid);
			dos.close();
        		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Client().run();
	}

}
