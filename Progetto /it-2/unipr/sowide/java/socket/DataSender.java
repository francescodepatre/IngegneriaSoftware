package it.unipr.sowide.java.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 *
 * The class {@code DataSender} sends a string to a receiver object.
 *
**/

public class DataSender
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

      String m = "Hello\n";
      byte[] b = m.getBytes();

      DatagramPacket packet = new DatagramPacket(b, b.length, inetA, DPORT);

      s.send(packet);

      s.close();
    }
    catch (IOException e)
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
    new DataSender().send();
  }
}
