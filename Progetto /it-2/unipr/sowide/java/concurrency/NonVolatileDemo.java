package it.unipr.sowide.java.concurrency;

/**
 *
 * The class {@code NonVolatileDemo} show the behavior
 * of a non volatile field.
 *
**/

public class NonVolatileDemo extends Thread
{
  private boolean keepRunning = true;

  /**
   * Class constructor.
   *
  **/
  public NonVolatileDemo()
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
    NonVolatileDemo demo = new NonVolatileDemo();

    demo.start();
    Thread.sleep(1000);

    demo.keepRunning = false;
  }
}
