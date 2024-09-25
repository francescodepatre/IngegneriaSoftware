package it.unipr.sowide.java.concurrency.thread;

import java.util.Random;

/**
 *
 * The class {@code ThreadExtension} shows how to implement
 * a thread extending the {@code Thread} class.
 *
**/

public final class ThreadExtension extends Thread
{
  private static final int MAXTHREADS = 10;
  private static final int MAXTIME = 1000;

  private static final Random RANDOM  = new Random();

  private ThreadExtension()
  {
  }

  /** {@inheritDoc} **/
  @Override
  public void run()
  {
    try
    {
      Thread.sleep(RANDOM.nextInt(MAXTIME));
    }
    catch (Exception e)
    {
      System.out.println("thread fails!");
    }

    System.out.println("thread ends!");
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
    int n = RANDOM.nextInt(MAXTHREADS);

    System.out.println(n + " threads will be started!");

    for (int i = 0; i < n; i++)
    {
      new ThreadExtension().start();
    }
  }
}
