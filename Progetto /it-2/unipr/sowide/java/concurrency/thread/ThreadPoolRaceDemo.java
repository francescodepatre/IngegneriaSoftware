package it.unipr.sowide.java.concurrency.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * The class {@code ThreadPoolRaceDemo} shows
 * the use of a thread pool.
 *
**/

public final class ThreadPoolRaceDemo
{
  private static final int THREADS = 100;
  private static final int OPERATIONS = 1000;
  private static final int COREPOOL = 5;
  private static final int MAXPOOL = 100;
  private static final long IDLETIME = 5000;
  private static final long SLEEPTIME = 10;


  private static int shared = 0;

  private ThreadPoolRaceDemo()
  {
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
    Runnable runnable = () -> {
      for (int i = 0; i < OPERATIONS; i++)
      {
        shared++;
      }
    };

    ThreadPoolExecutor pool = new ThreadPoolExecutor(
        COREPOOL, MAXPOOL, IDLETIME, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>());

    for (int j = 0; j < THREADS; j++)
    {
      pool.execute(runnable);
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

    System.out.println("\n shared value is: " + shared);
  }
}
