package it.unipr.sowide.java.concurrency.sinchronization;

/**
 *
 * The class {@code SynchronizedRaceDemo} shows
 * a wrong use of synchronized methods.
 *
**/

public class SynchronizedRaceDemo extends Thread
{
  private static final int THREADS = 100;
  private static final int OPERATIONS = 1000;

  private static int shared = 0;

  private Thread thread;

  /**
   * Class constructor.
   *
   * @param t  the thread.
   *
  **/
  public SynchronizedRaceDemo(final Thread t)
  {
    this.thread = t;
  }

  /** {@inheritDoc} **/
  @Override
  public void run()
  {
    for (int i = 0; i < OPERATIONS; i++)
    {
      shared++;
    }

    joinThread(this.thread);
  }

  private static void joinThread(final Thread t)
  {
    if (t != null)
    {
      try
      {
        t.join();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
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
    Thread t = null;

    for (int j = 0; j < THREADS; j++)
    {
      t = new SynchronizedRaceDemo(t);

      t.start();
    }

    joinThread(t);

    System.out.println("\n shared value is: " + shared);
  }
}
