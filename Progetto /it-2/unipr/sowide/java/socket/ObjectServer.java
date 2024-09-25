package it.unipr.sowide.java.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * The class {@code ObjectServer} defines a server that waits
 * for an object message and then sends an answer.
 *
**/
public class ObjectServer
{
  private static final int SPORT  = 4444;
  private static final double MIN = 0.1;

  /**
   * Sends the answer.
   *
  **/
  public void reply()
  {
    try
    {
      ServerSocket server = new ServerSocket(SPORT);

      Socket client = server.accept();

      ObjectInputStream  is = new ObjectInputStream(client.getInputStream());
      ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
      Random             r  = new Random();

      while (true)
      {
        // Reads until there are messages or
        // until it sends an �end� message

        Object o = is.readObject();

        if ((o != null) && (o instanceof Message))
        {
          Message m = (Message) o;

          System.out.format(" Server received: %s from Client\n",
              m.getContent());

          if (r.nextDouble() > MIN)
          {
            os.writeObject(new Message(m.getUser(), "done"));
            os.flush();
          }
          else
          {
            os.writeObject(new Message(m.getUser(), "end"));
            os.flush();
            break;
          }
        }
        else
        {
          break;
        }
      }

      client.close();
      server.close();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
    new ObjectServer().reply();
  }
}
