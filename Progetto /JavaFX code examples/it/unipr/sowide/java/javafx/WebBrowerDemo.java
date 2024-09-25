package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * The class {@code WebBrowerDemo} shows how to create a web browser
 * supporting the management of navigation history and the loading
 * of local HTML files.
 *
**/

public class WebBrowerDemo extends Application
{
  /** {@inheritDoc} **/
  @Override
  public void start(final Stage stage)
  {
    WebView view = new WebView();

    view.getEngine().titleProperty().addListener(
        (t, o, n) -> stage.setTitle(n));

    String homePage             = "http://www.google.com";
    MenuButton menu             = new WebMenu(view);
    WebBrowserHistory history   = new WebBrowserHistory(view);
    WebNavigationBar navigation = new WebNavigationBar(view, homePage, true);

    navigation.getChildren().addAll(menu, history);

    VBox root = new VBox(navigation, view);

    root.setStyle("-fx-padding: 10;"
        + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;"
        + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;"
        + "-fx-border-color: blue;");

    Scene scene = new Scene(root);
    stage.setScene(scene);
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
    Application.launch(args);
  }
}

