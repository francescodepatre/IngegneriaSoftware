package it.unipr.sowide.java.concurrency.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * The class {@code MultiThreadFutureCalculator} defines a multi-thread
 * executor of future methods for calculating the area of some squares.
 *
**/

public class MultiThreadFutureCalculator
{
  private List<Future<Integer>> lf;

  public MultiThreadFutureCalculator()
  {
    lf = new ArrayList<>();
  }

  public void calculateArea(final Integer ... v)
  {
    for (Integer i : v)
    {
       lf.add(new ExecutorServiceCalculator().calculate(i));
    }

    boolean completed = false;

    String format = "future %d is %s and result is %s";

    try
    {
      while (!completed) {

        completed = true;

        for (Future<Integer> f : lf)
        {
          if (!f.isDone())
          {
            completed = false;
          }
        }

        int i = 1;

        for (Future<Integer> f : lf)
        {
          System.out.println(String.format(format, i++, f.isDone(), f.get()));
        }

        System.out.println();

        Thread.sleep(300);
      }
    }
    catch (ExecutionException e)
    {
      e.printStackTrace();
    }
    catch (InterruptedException i)
    {
      i.printStackTrace();
    }
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/

  public static void main(final String[] args)
  {
    MultiThreadFutureCalculator mtfc = new MultiThreadFutureCalculator();

    mtfc.calculateArea(10, 15, 45);
  }
}
