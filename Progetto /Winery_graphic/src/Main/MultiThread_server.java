package Main;

import java.io.*;
import java.net.*;
import Interfaces.*;
import Operations.*;

public class MultiThread_server {
	private static final int SPORT = 2222;
	
	public void run() {
		System.out.println("SERVER: Creating server.");
		try {
			ServerSocket ss = new ServerSocket(SPORT);
			ss.setReuseAddress(true);
			
			if(ss != null) {
				System.out.println("SERVER: Server running.");
			}
			
			while(true) {
				Socket client = ss.accept();
				
				System.out.println("SERVER: Connection with "+ client.toString());
					
				
				//inizio tread
				ClientHandler client_sock = new ClientHandler(client);
				
				new Thread(client_sock).start();
				
			}
			
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static class ClientHandler implements Runnable {
		private final Socket clientSocket;

		public ClientHandler(Socket socket){
			this.clientSocket = socket;
			}

		public void run(){
			
			try {
				
				DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
				
				int uid = dis.readInt();
				
				String type_int = new type_account().get_type(uid);
				
				new Server_Interface().interface_selector(type_int, uid);
				
				if(clientSocket == null) {
					clientSocket.close();
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new MultiThread_server().run();
	}
}
