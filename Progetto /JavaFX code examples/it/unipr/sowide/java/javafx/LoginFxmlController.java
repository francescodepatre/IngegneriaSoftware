package it.unipr.sowide.java.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 *
 * The class {@code LoginFxmlController} defines the controller
 * used in the FXML implementation of the login window.
 *
**/

public class LoginFxmlController
{
  @FXML
  private Text actiontarget;

  /**
   * Handles the submit button event.
   *
   * @param e  the event.
  **/
  @FXML
  protected void handleSubmitButtonAction(final ActionEvent e)
  {
    actiontarget.setText("Sign in button pressed");
  }
}
