package it.unipr.sowide.java.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * The class {@code DataClient} defines a client that sends a string
 * to a server and receives its answer.
 *
**/

public class DataClient
{
  private static final int SPORT = 4444;
  private static final String SHOST = "localhost";

  /**
   * Runs the client code.
   *
  **/
  public void send()
  {
    try
    {
      Socket client = new Socket(SHOST, SPORT);

      BufferedReader   is = new BufferedReader(
          new InputStreamReader(client.getInputStream()));
      DataOutputStream os = new DataOutputStream(client.getOutputStream());

      os.writeBytes("Hello\n");

      System.out.println("Client received: " + is.readLine());

      client.close();
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
    new DataClient().send();
  }
}
