package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * The class {@code PersonBookDemo} shows the person book demo.
 *
**/

public class PersonBookDemo extends Application
{
  /** {@inheritDoc} **/
  @Override
  public void start(final Stage primaryStage) throws Exception
  {
    Parent root  = FXMLLoader.load(getClass().getResource("personBook.fxml"));
    Scene  scene = new Scene(root, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
    launch(args);
  }
}
