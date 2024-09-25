package it.unipr.sowide.java.concurrency.buffer;

/**
 *
 * The class {@code Producer} defines a consumer of items.
 *
**/

public class Consumer implements Runnable
{
  private Buffer data;
  private int products;

  /**
   * Class constructor.
   *
   * @param d  the buffer.
   * @param p  the number of products to consume.
   *
  **/
  public Consumer(final Buffer d, final int p)
  {
    this.data     = d;
    this.products = p;
  }

  /** {@inheritDoc} **/
  @Override
  public void run()
  {
    for (int i = 0; i < this.products; i++)
    {
      this.data.get();
    }

    System.out.println("Comumer managed " + this.products + " produts");
  }
}
