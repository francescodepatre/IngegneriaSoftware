package Communication;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.NonReadableChannelException;

import Actors.request_operation;
import Operations.Wine_searchname;

public class ServerThread implements Runnable{
	
	private Server server;
	private Socket socket;
	
	public ServerThread(final Server s, final Socket c) {
		this.server = s;
		this.socket = c;
	}
	
	public void run() {
		ObjectInputStream is = null;
		ObjectOutputStream os = null;
		int iduser = 0;
		
		try {
			is = new ObjectInputStream(new BufferedInputStream(this.socket.getInputStream()));
			os = new ObjectOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
			System.out.println("Reading user ID...");
			Object n = is.readObject();
			request_operation r = (request_operation) n;
			iduser = (int) r.getData(0);
			System.out.println("ID USER: " + iduser);
			if(iduser == 0) {
				System.exit(0);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			return;
		}
	
		while(true) {
			
			try {
				Object i = is.readObject();
				
				if(i instanceof request_operation) {
					request_operation rq = (request_operation) i;
					
					new logic_interface().execute(iduser, rq, this.socket);
					
				}
			}catch(Exception e) {
				//System.exit(0);
				return;
			}
		}
	}
}
