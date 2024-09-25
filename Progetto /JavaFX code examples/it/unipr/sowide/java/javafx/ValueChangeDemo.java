package it.unipr.sowide.java.javafx;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * The class {@code ValueChangeDemo} shows the use
 * of listeners for monitoring the change of properties.
 *
**/

public final class ValueChangeDemo
{
  private ValueChangeDemo()
  {
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
    SimpleIntegerProperty xProperty = new SimpleIntegerProperty(0);

    // Adding a change listener with lambda expression
    xProperty.addListener((ObservableValue<? extends Number> ov, Number oldVal,
        Number newVal) -> {
      System.out.println("old value:" + oldVal);
      System.out.println("new value:" + newVal);
    });

    SimpleIntegerProperty yProperty = new SimpleIntegerProperty(0);

    // Adding a invalidation listener (lambda expression)
    yProperty.addListener((Observable o) -> {
      System.out.println(o.toString());
    });

    xProperty.set(10);
    yProperty.set(5);
  }
}
