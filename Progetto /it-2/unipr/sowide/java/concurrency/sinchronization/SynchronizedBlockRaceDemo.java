package it.unipr.sowide.java.concurrency.sinchronization;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
*
* The class {@code SynchronizedBlockRaceDemo} shows
* the use of wait and signal for synchronizing the access
* to a block of a method of its instances.
*
**/

public class SynchronizedBlockRaceDemo extends Thread
{
  private static final int THREADS = 100;
  private static final int OPERATIONS = 1000;
  private static final int COREPOOL = 5;
  private static final int MAXPOOL = 100;
  private static final long IDLETIME = 5000;
  private static final long SLEEPTIME = 10;

  private static Shared shared = new Shared();

  /**
  *
  * The inner class {@code Shared} provides an object
  * that support a correct increment of a shared variable.
  *
 **/

  protected static class Shared
  {
    protected int value;

    /**
     * Class constructor.
     *
    **/
    protected Shared()
    {
      this.value = 0;
    }

    /**
     * Increments the shared variable.
     *
    **/
    public void increment()
    {
      // ... some code ...
      synchronized (this)
      {
        this.value++;
      }
      // ... some code ...
    }
  }

  /** {@inheritDoc} **/
  @Override
  public void run()
  {
    for (int i = 0; i < OPERATIONS; i++)
    {
      shared.increment();
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
    ThreadPoolExecutor pool = new ThreadPoolExecutor(
        COREPOOL, MAXPOOL, IDLETIME, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>());

    for (int j = 0; j < THREADS; j++)
    {
      pool.execute(new SynchronizedBlockRaceDemo());
    }

    while (pool.getActiveCount() > 0)
    {
      try
      {
        Thread.sleep(SLEEPTIME);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    pool.shutdown();

    System.out.println("\n shared value is: " + shared.value);
  }
}
