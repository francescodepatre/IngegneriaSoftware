package it.unipr.sowide.java.concurrency.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * The class {@code actorialSquareCalculator} defines a method
 * for calculating the square area through the use of a future method.
 *
**/

public class FactorialSquareCalculator extends RecursiveTask<Integer>
{
  private static final long serialVersionUID = 1L;

  private Integer n;

  public FactorialSquareCalculator(Integer n) {
      this.n = n;
  }

  @Override
  protected Integer compute() {
      if (n <= 1) {
          return n;
      }

      FactorialSquareCalculator calculator
        = new FactorialSquareCalculator(n - 1);

      calculator.fork();

      return n * n + calculator.join();
  }

  public static void main(final String[] args)
  {
    String format = "factorial value of %d is %d";

    int val = 3;

    ForkJoinPool forkJoinPool = new ForkJoinPool();

    FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

    forkJoinPool.execute(calculator);

    forkJoinPool.close();

    FactorialSquareCalculator fsc = new FactorialSquareCalculator(val);

    System.out.println(String.format(format, val, fsc.compute()));
  }
}
