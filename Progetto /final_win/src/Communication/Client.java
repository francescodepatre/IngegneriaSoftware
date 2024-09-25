package Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Actors.request_operation;

public class Client {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Client() throws IOException, ClassNotFoundException {
        socket = new Socket("localhost", 4444);
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    public void sendData(request_operation data) throws IOException {
    	Object obj = data;
        out.writeObject(obj);
        out.flush();
    }
    
    public Object receiveData() throws ClassNotFoundException, IOException {
    	in = new ObjectInputStream(socket.getInputStream());
    	Object obj = in.readObject();
    	return obj;
    }

    public void close() throws IOException {
        out.close();
        socket.close();
    }
    
}
