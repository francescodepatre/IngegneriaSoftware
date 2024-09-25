package it.unipr.sowide.java.concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * The class {@code FutureCalculator} defines a method
 * for calculating the square area through the use of a future method.
 *
**/

public class FutureCalculator
{
  public static Integer calculateArea(final Integer side)
  {
    try
    {
      Future<Integer> future = new ExecutorServiceCalculator().calculate(side);

      while(!future.isDone()) {
          System.out.println("Calculating...");
          Thread.sleep(300);
      }

      return future.get();
    }
    catch (ExecutionException e)
    {
      return null;
    }
    catch (InterruptedException i)
    {
      return null;
    }
  }
}
