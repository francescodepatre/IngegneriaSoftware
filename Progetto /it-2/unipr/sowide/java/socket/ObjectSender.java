package it.unipr.sowide.java.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 *
 * The class {@code ObjectSender} sends an object to a receiver object.
 *
**/

public class ObjectSender
{
  private static final String ADDRESS = "230.0.0.1";
  private static final int DPORT = 4446;

  /**
   * Sends a message.
   *
  **/
  public void send()
  {
    try
    {
      InetAddress inetA       = InetAddress.getByName(ADDRESS);
      InetSocketAddress group = new InetSocketAddress(inetA, DPORT);
      NetworkInterface netI   = NetworkInterface.getByInetAddress(inetA);
      MulticastSocket s       = new MulticastSocket(DPORT);

      s.joinGroup(group, netI);

      Message m = new Message(new User("Agostino", "Poggi",
          "agostino.poggi@unipr.it", "agostino"), "hello");

      System.out.format("Sender sends %s for user with password %s\n",
          m.getContent(), m.getUser().getPassword());

      byte[] b = toByteArray(m);

      DatagramPacket packet = new DatagramPacket(b, b.length, inetA, DPORT);

      s.send(packet);
      s.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private byte[] toByteArray(final Object o) throws IOException
  {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    ObjectOutputStream    s = new ObjectOutputStream(b);

    s.writeObject(o);
    s.flush();
    s.close();
    b.close();

    return b.toByteArray();
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
    new ObjectSender().send();
  }
}
