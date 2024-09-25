package it.unipr.sowide.java.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * The class {@code StopExecutionWithThread} shows a demo that run a task
 * that waits 1 second for ten times, each time with a new thread.
 * The use of the "runLater" method allows a correct termination management,
 * but at each thread execution an java.lang.IllegalStateException is generated
 * because the application does not use the javaFx application thread.
 *
**/

public class StopExecutionWithThread extends Application
{
  TextArea textArea = new TextArea();
  Label statusLabel = new Label("Not Started...");
  Button startButton = new Button("Start");
  Button exitButton = new Button("Exit");

  /** {@inheritDoc} **/
  @Override
  public void start(final Stage stage)
  {
    startButton.setOnAction((e) -> startTask());
    exitButton.setOnAction((e) -> stage.close());

    HBox buttonBox = new HBox(5, startButton, exitButton);
    VBox root      = new VBox(10, statusLabel, buttonBox, textArea);

    root.setStyle("-fx-padding: 10;"
        + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;"
        + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;"
        + "-fx-border-color: blue;");

    Scene scene = new Scene(root, 400, 300);
    stage.setScene(scene);
    stage.setTitle("A simple Concurrency Example");
    stage.show();
  }

  /**
   * Starts the task.
   *
  **/
  public void startTask()
  {
    Runnable task = new Runnable()
    {
      @Override
      public void run()
      {
        runTask();
      }
    };

    Thread backgroundThread = new Thread(task);

    backgroundThread.start();
  }

  private void runTask()
  {
    for (int i = 1; i <= 10; i++)
    {
      try
      {
        String status = "Processing " + i + " of " + 10;
        statusLabel.setText(status);
        textArea.appendText(status + "\n");
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
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
