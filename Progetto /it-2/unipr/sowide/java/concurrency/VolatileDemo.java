package it.unipr.sowide.java.concurrency;

/**
 *
 * The class {@code VolatileDemo} show the behavior
 * of a volatile field.
 *
**/

public class VolatileDemo extends Thread
{
  private volatile boolean keepRunning = true;

  /**
   * Class constructor.
   *
  **/
  public VolatileDemo()
  {
    this.keepRunning = true;
  }

  /** {@inheritDoc} **/
  @Override
  public void run()
  {
    System.out.print("\n Thread terminated in ");

    long t = System.currentTimeMillis();

    while (keepRunning)
    {
    }

    System.out.println((System.currentTimeMillis() - t) + " milliseconds");
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
   * @throws InterruptedException if the execution fails.
   *
  **/
  public static void main(final String[] args) throws InterruptedException
  {
    VolatileDemo demo = new VolatileDemo();

    demo.start();
    Thread.sleep(1000);

    demo.keepRunning = false;
  }
}
