package it.unipr.sowide.java.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 *
 * The class {@code DataReceiver} receives a string from a sender object.
 *
**/

public class DataReceiver
{
  private static final String ADDRESS = "230.0.0.1";
  private static final int DPORT = 4446;
  private static final int SIZE = 256;

  public void receive()
  {
    try
    {
      InetAddress inetA       = InetAddress.getByName(ADDRESS);
      InetSocketAddress group = new InetSocketAddress(inetA, DPORT);
      NetworkInterface netI   = NetworkInterface.getByInetAddress(inetA);
      MulticastSocket s       = new MulticastSocket(DPORT);

      s.joinGroup(group, netI);

      byte[] buf = new byte[SIZE];

      DatagramPacket packet = new DatagramPacket(buf, buf.length);

      s.receive(packet);

      System.out.println("Receiver received: " + new String(packet.getData()));

      s.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(final String[] args)
  {
    new DataReceiver().receive();
  }
}
