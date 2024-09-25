package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * The class {@code MultipleStageDemo} shows
 * an application with more than one stage.
 *
**/

public class MultipleStageDemo extends Application
{
  /** {@inheritDoc} **/
  @Override
  public void start(final Stage primaryStage)
  {
    Scene scene = new Scene(new Button("OK"), 200, 250);
    primaryStage.setTitle("MyJavaFX");
    primaryStage.setScene(scene);
    primaryStage.show();

    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      return;
    }

    Stage stage = new Stage();
    stage.setTitle("Second Stage");
    stage.setScene(new Scene(new Button("New Stage"), 200, 250));
    stage.show();
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
