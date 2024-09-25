package it.unipr.sowide.java.concurrency.buffer;

/**
 *
 * The class {@code Producer} defines a producer of items.
 *
**/

public class Producer implements Runnable
{
  private Buffer data;
  private int products;

  /**
   * Class constructor.
   *
   * @param d  the buffer.
   * @param n  the number of products to produce.
   *
  **/
  public Producer(final Buffer d, final int n)
  {
    this.data     = d;
    this.products = n;
  }

  /** {@inheritDoc} **/
  @Override
  public void run()
  {
    for (int i = 0; i < this.products; i++)
    {
      this.data.put(String.valueOf(i));
    }

    System.out.println("Producer managed " + this.products + " produts");
  }
}
