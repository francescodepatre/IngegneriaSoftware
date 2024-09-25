package it.unipr.sowide.java.concurrency.buffer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * The class {@code BlockingQueueBuffer} implements the {@code Buffer}
 * interface by using a blocking queue.
 *
**/

public class BlockingQueueBuffer implements Buffer
{
  private ArrayBlockingQueue<String> elements;

  /**
   * Class constructor.
   *
   * @param l  the buffer length.
   *
  **/
  public BlockingQueueBuffer(final int l)
  {
    this.elements = new ArrayBlockingQueue<String>(l);
  }

  /** {@inheritDoc} **/
  @Override
  public int size()
  {
    return this.elements.size();
  }

  /** {@inheritDoc} **/
  @Override
  public String get()
  {
    try
    {
      return this.elements.take();
    }
    catch (InterruptedException e)
    {
      return null;
    }
  }

  /** {@inheritDoc} **/
  @Override
  public void put(final String s)
  {
    try
    {
      this.elements.put(s);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
