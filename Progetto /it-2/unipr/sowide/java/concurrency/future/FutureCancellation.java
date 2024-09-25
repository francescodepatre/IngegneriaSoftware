package it.unipr.sowide.java.concurrency.future;

import java.util.concurrent.Future;

/**
 *
 * The class {@code FutureCancellation} defines a method
 * that shows how to stop the execution of a computation.
 *
**/

public class FutureCancellation
{
  public static Integer calculateArea(final Integer side)
  {
    Future<Integer> future = new ExecutorServiceCalculator().calculate(side);

    future.cancel(true);

    return null;
  }
}
