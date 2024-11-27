
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import je.fx.util.Turtle;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

/**
 *
 * Description
 *
 * @version 1.0 from 02.10.2024
 * @author
 */

public class kochsche_flocke extends Application {
  // start attributes
  int depth = 3;
  private Turtle turtle1 = new Turtle();
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 629, 411);
    // start components

    turtle1.setLayoutX(32);
    turtle1.setLayoutY(24);
    turtle1.setWidth(448);
    turtle1.setHeight(352);
    turtle1.setOriginX(224);
    turtle1.setOriginY(176);
    root.getChildren().add(turtle1);
    turtle1.setAnimated(true);
    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("kochsche_flocke");
    primaryStage.setScene(scene);
    primaryStage.show();

    drawFlocke(depth);
  } // end of public kochsche_flocke

  public void drawFlocke(int depth) {
    double length = 300;

  }

  public void drawSeite(int depth, double length) {
    double third = length / 3;
    if (depth > 0) {
      turtle1.draw(third);
      // draw stachel

      turtle1.move(third);
      turtle1.draw(third);
    } else if (depth == 0) {
      turtle1.draw(length);
    }

  }

  public void drawStachel(int depth, double length) {
    turtle1.turn(60);
    drawSeite(depth, length);

  }
  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  // end methods
} // end of class kochsche_flocke
