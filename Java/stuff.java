import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 16.09.2024
 * @author
 */

public class stuff extends Application {
  // start attributes
  // end attributes
  Pane root = new Pane();
  Scene scene = new Scene(root, 600, 600);

  public void start(Stage primaryStage) {
    // start components

    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("stuff");
    primaryStage.setScene(scene);
    primaryStage.show();
    start();

  } // end of public stuff

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void start() {
    int breite = 10;
    int hoehe = breite;
    int dim = ((int) root.getWidth()) / breite;
    int offset = dim;

    Rectangle[][] r = new Rectangle[breite][hoehe];

    for (int i = 0; i < breite; i++) {
      for (int j = 0; j < hoehe; j++) {
        r[i][j] = new Rectangle();
        r[i][j].setX(offset * i);
        r[i][j].setY(offset * j);
        r[i][j].setWidth(dim);
        r[i][j].setHeight(dim);
        r[i][j].setOnMouseMoved(
            (event) -> {
              moved(event);
            });
        root.getChildren().add(r[i][j]);
      }
    }
  }

  public void moved(MouseEvent evt) {

    System.out.println(evt.getSceneX() + "");
  } // end of rectangle1_MouseMoved

  // end methods
} // end of class stuff
