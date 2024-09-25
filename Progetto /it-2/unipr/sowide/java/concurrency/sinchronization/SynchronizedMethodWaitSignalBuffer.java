package it.unipr.sowide.java.concurrency.sinchronization;

import java.util.ArrayList;
import java.util.List;

import it.unipr.sowide.java.concurrency.buffer.Buffer;

/**
 *
 * The class {@code SynchronizedMethodWaitSignalBuffer} shows
 * the use of wait and signal for synchronizing the access to a buffer.
 *
**/

public class SynchronizedMethodWaitSignalBuffer implements Buffer
{
  private List<String> elements;

  private final int length;

  /**
   * Class constructor.
   *
   * @param l  the buffer length.
   *
  **/
  public SynchronizedMethodWaitSignalBuffer(final int l)
  {
    this.elements = new ArrayList<>();

    this.length = l;
  }

  /** {@inheritDoc} **/
  @Override
  public int size()
  {
    return this.elements.size();
  }

  /** {@inheritDoc} **/
  @Override
  public synchronized String get()
  {
    while (this.elements.size() == 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    String value = this.elements.remove(0);

    notifyAll();

    return value;
  }

  /** {@inheritDoc} **/
  @Override
  public synchronized void put(final String s)
  {
    while (this.elements.size() == this.length)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    this.elements.add(s);
    notifyAll();
  }
}
