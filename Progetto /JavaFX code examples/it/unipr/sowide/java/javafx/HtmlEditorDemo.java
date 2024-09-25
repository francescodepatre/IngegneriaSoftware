package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 *
 * The class {@code HtmlEditorDem} shows a simple HTML editor.
 *
**/

public class HtmlEditorDemo extends Application
{
  /** {@inheritDoc} **/
  @Override
  public void start(final Stage stage)
  {
    HTMLEditor htmlEditor = new HTMLEditor();
    htmlEditor.setPrefHeight(300);
    htmlEditor.setPrefWidth(600);

    Scene scene = new Scene(htmlEditor);
    stage.setScene(scene);
    stage.setTitle("HTMLEditor Demo");
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
