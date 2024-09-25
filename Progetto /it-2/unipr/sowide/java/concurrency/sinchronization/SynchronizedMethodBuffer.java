package it.unipr.sowide.java.concurrency.sinchronization;

import java.util.ArrayList;
import java.util.List;

import it.unipr.sowide.java.concurrency.buffer.Buffer;

/**
 *
 * The class {@code SynchronizedMethodBuffer} shows
 * an incomplete solution for synchronizing the access to a buffer.
 *
**/

public class SynchronizedMethodBuffer implements Buffer
{
  private List<String> elements;

  private final int length;

  /**
   * Class constructor.
   *
   * @param l  the buffer length.
   *
  **/
  public SynchronizedMethodBuffer(final int l)
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
  public synchronized void put(final String s)
  {
    if (this.elements.size() < this.length)
    {
      this.elements.add(s);
    }
    else
    {
      // what operations should be done?
    }
  }

  /** {@inheritDoc} **/
  @Override
  public synchronized String get()
  {
    if (this.elements.size() > 0)
    {
      return this.elements.remove(0);
    }
    else
    {
      return null;
    }
  }
}
