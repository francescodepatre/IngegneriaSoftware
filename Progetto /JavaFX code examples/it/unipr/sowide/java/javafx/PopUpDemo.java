package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 *
 * The class {@code PopUpDemo} shows how to create a pop-up object.
 *
**/

public class PopUpDemo extends Application
{
  /** {@inheritDoc} **/
  @Override
  public void start(final Stage primaryStage)
  {
    primaryStage.setTitle("Popup Example");
    final Popup popup = new Popup();
    popup.setX(300);
    popup.setY(200);
    popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));

    Button show = new Button("Show");
    show.setOnAction((e) -> popup.show(primaryStage));

    Button hide = new Button("Hide");
    hide.setOnAction((e) -> popup.hide());

    HBox layout = new HBox(10);
    layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
    layout.getChildren().addAll(show, hide);
    primaryStage.setScene(new Scene(layout));
    primaryStage.show();
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(String[] args)
  {
    launch(args);
  }
}
