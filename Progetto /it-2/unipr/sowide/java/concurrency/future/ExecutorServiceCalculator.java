package it.unipr.sowide.java.concurrency.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * The class {@code ExecutorServiceCalculator} defines a method
 * for calculating the square area through the use of a executor service.
 *
**/

public class ExecutorServiceCalculator
{
  private ExecutorService executor = Executors.newFixedThreadPool(1);

  public Future<Integer> calculate(Integer input)
  {
    return executor.submit(() -> {
      Thread.sleep(1000);
      return input * input;
    });
  }
}
