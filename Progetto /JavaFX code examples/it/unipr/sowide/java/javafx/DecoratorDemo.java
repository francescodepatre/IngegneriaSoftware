package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * The class {@code DecoratorDemo} show the use of stage styles.
 *
**/

public class DecoratorDemo extends Application
{

  /** {@inheritDoc} **/
  @Override
  public void start(Stage stage)
  {
    Text text = new Text(10, 40, "Hello World!");
    text.setFont(new Font(40));
    Scene scene = new Scene(new Group());

    stage.setTitle("Welcome to JavaFX!");
    stage.setScene(scene);
    stage.sizeToScene();
    stage.initStyle(StageStyle.DECORATED);
    stage.show();
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(String[] args)
  {
    Application.launch(args);
  }
}
