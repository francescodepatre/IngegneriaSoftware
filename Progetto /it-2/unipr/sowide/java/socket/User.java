package it.unipr.sowide.java.socket;

import java.io.Serializable;

/**
*
* The class {@code User} provides a simple user model.
*
**/

public final class User implements Serializable
{
  private static final long serialVersionUID = 1L;

  private final String firstName;
  private final String lastName;
  private final String address;
  private final transient String password;

  /**
   * Class constructor.
   *
   * @param f  the first name.
   * @param l  the last name.
   * @param a  the address.
   * @param p  the password.
   */
  public User(final String f, final String l, final String a, final String p)
  {
    this.firstName = f;
    this.lastName  = l;
    this.address   = a;
    this.password  = p;
  }

  /**
   * Gets the first name.
   *
   * @return the content.
   *
  **/
  public String getFirstName()
  {
    return this.firstName;
  }

  /**
   * Gets the last name.
   *
   * @return the content.
   *
  **/
  public String getLastName()
  {
    return this.lastName;
  }

  /**
   * Gets the address.
   *
   * @return the address.
   *
  **/
  public String getAddress()
  {
    return this.address;
  }

  /**
   * Gets the password.
   *
   * @return the password.
   *
  **/
  public String getPassword()
  {
    return this.password;
  }
}
