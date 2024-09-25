package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * The class {@code WebViewDemo} shows how to create a simple Web browser.
 *
**/

public class WebViewDemo extends Application
{
  /** {@inheritDoc} **/
  @Override
  public void start(final Stage primaryStage)
  {
    primaryStage.setTitle("WebView Demo");

    WebView webView = new WebView();

    webView.getEngine().load("http://google.com");

    VBox vBox = new VBox(webView);

    Scene scene = new Scene(vBox, 960, 600);

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
