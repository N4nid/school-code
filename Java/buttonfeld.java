import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 16.09.2024
 * @author
 */

public class buttonfeld extends Application {
  // start attributes
  // end attributes
  Pane root = new Pane();
  Scene scene = new Scene(root, 100, 100);

  public void start(Stage primaryStage) {
    // start components

    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("buttonfeld");
    primaryStage.setScene(scene);
    primaryStage.show();
    start();
  } // end of public buttonfeld

  // start methods
  public void start() {
    int breite = 10;
    int hoehe = breite;
    int buttondim = ((int) root.getWidth()) / breite;
    int offset = buttondim;
    Button[][] b = new Button[breite][hoehe];
    for (int i = 0; i < breite; i++) {
      for (int j = 0; j < hoehe; j++) {
        b[i][j] = new Button();
        b[i][j].setLayoutX(offset * i);
        b[i][j].setLayoutY(offset * j);
        b[i][j].setPrefHeight(buttondim);
        b[i][j].setPrefWidth(buttondim);

        // b[i][j].setText("");
        root.getChildren().add(b[i][j]);

      }
    }

  }

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void button1_Action(Event evt) {

  } // end of button1_Action

  // end methods
} // end of class buttonfeld
