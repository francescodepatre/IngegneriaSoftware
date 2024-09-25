package it.unipr.sowide.java.concurrency.thread;

/**
 *
 * The class {@code ThreadRaceDemo} shows the wrong
 * access of a set of threads to a shared variable.
 *
**/

public final class ThreadRaceDemo
{
  private static final int THREADS = 100;
  private static final int OPERATIONS = 1000;

  private static int shared = 0;

  private ThreadRaceDemo()
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

    for (int j = 0; j < THREADS; j++)
    {
      new Thread(runnable).start();
    }

    System.out.println("\n shared value is: " + shared);
  }
}
