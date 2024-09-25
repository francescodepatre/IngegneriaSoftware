package it.unipr.sowide.java.socket;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 *
 * The class {@code ObjectReceiver} receives an object from a sender object.
 *
**/

public class ObjectReceiver
{
  private static final String ADDRESS = "230.0.0.1";
  private static final int DPORT = 4446;
  private static final int SIZE = 1024;

  /**
   * Receives a message.
   *
  **/
  public void receive()
  {
    try
    {
      InetAddress inetA       = InetAddress.getByName(ADDRESS);
      InetSocketAddress group = new InetSocketAddress(inetA, DPORT);
      NetworkInterface netI   = NetworkInterface.getByInetAddress(inetA);
      MulticastSocket s       = new MulticastSocket(DPORT);

      s.joinGroup(group, netI);

      byte[]         buf    = new byte[SIZE];
      DatagramPacket packet = new DatagramPacket(buf, buf.length);

      s.receive(packet);

      Object o = toObject(packet.getData());

      if (o instanceof Message)
      {
        Message m = (Message) o;

        System.out.format("Receiver received: %s from user with password %s\n",
            m.getContent(), m.getUser().getPassword());
      }

      s.close();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private Object toObject(final byte[] b)
          throws IOException, ClassNotFoundException
  {
    ObjectInputStream s = new ObjectInputStream(new ByteArrayInputStream(b));

    Object o = s.readObject();
    s.close();

    return o;
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
    new ObjectReceiver().receive();
  }
}
