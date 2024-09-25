package it.unipr.sowide.java.concurrency.buffer;

/**
 *
 * The interface {@code Buffer} defines the methods of simple buffer.
 *
**/

public interface Buffer
{
  /**
   * Gets the buffer size.
   *
   * @return the size.
   *
  **/
  int size();

  /**
   * Consumes an item of the buffer.
   *
   * @return the item.
   *
  **/
  String get();

  /**
   * Adds an item to the buffer.
   *
   * @param s  the item.
   *
  **/
  void put(String s);
}
