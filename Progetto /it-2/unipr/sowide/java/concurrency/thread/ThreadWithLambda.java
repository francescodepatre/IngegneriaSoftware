package it.unipr.sowide.java.concurrency.thread;

import java.util.Random;

/**
 *
 * The class {@code ThreadWithLambda} shows how to implement
 * a thread through the use of a Runnable lambda expression.
 *
**/

public final class ThreadWithLambda
{
  private static final int MAXTHREADS = 10;
  private static final int MAXTIME = 1000;

  private static final Random RANDOM  = new Random();

  private ThreadWithLambda()
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
    int n = RANDOM.nextInt(MAXTHREADS);

    System.out.println(n + " threads will be started!");

    Runnable runnable = () -> {
      try
      {
        Thread.sleep(RANDOM.nextInt(MAXTIME));
      }
      catch (Exception e)
      {
        System.out.println("thread fails!");
      }

      System.out.println("thread ends!");
    };

    for (int i = 0; i < n; i++)
    {
      new Thread(runnable).start();
    }
  }
}
