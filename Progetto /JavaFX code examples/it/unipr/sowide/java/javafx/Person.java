package it.unipr.sowide.java.javafx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * The class {@code Person} provides a simple person model.
 *
**/

public class Person
{
  private SimpleIntegerProperty id;
  private SimpleStringProperty name;
  private SimpleIntegerProperty age;

  public Person(final int i, final String n, final int a)
  {
    this.id   = new SimpleIntegerProperty(i);
    this.name = new SimpleStringProperty(n);
    this.age  = new SimpleIntegerProperty(a);
  }

  /**
   * Gets the person's id.
   *
   * @return the id.
   *
  **/
  public int getId()
  {
    return id.get();
  }

  /**
   * Sets the person's id.
   *
   * @param i  the id.
   *
  **/
  public void setId(final int i)
  {
    this.id.set(i);
  }

  /**
   * Gets the person's name.
   *
   * @return the name.
   *
  **/
  public String getName()
  {
    return name.get();
  }

  /**
   * Sets the person's name.
   *
   * @param n  the name.
   *
  **/
  public void setName(final String n)
  {
    this.name.set(n);
  }

  /**
   * Gets the person's age.
   *
   * @return the age.
   *
  **/
  public int getAge()
  {
    return age.get();
  }

  /**
   * Sets the person's age.
   *
   * @param a  the age.
   *
  **/
  public void setAge(final int a)
  {
    this.age.set(a);
  }

  /** {@inheritDoc} **/
  @Override
  public String toString()
  {
    return "id: " + id.get() + " - " + "name: "
           + name.get() + "age: " + age.get();
  }
}
