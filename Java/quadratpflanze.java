import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import je.fx.util.Turtle;
import javafx.scene.canvas.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

/**
 *
 * Description
 *
 * @version 1.0 from 19.09.2024
 * @author
 */

public class quadratpflanze extends Application {
  // start attributes
  private Button bquadratPflanze1 = new Button();
  private Turtle turtle1 = new Turtle();
  private TextField textField1 = new TextField();
  int callAmount = 0;
  private TextField textField2 = new TextField();
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 545, 438);
    // start components

    bquadratPflanze1.setLayoutX(8);
    bquadratPflanze1.setLayoutY(0);
    bquadratPflanze1.setPrefHeight(24);
    bquadratPflanze1.setPrefWidth(120);
    bquadratPflanze1.setText("quadratPflanze");
    bquadratPflanze1.setOnAction(
        (event) -> {
          bquadratPflanze1_Action(event);
        });
    root.getChildren().add(bquadratPflanze1);
    turtle1.setLayoutX(16);
    turtle1.setLayoutY(40);
    turtle1.setWidth(520);
    turtle1.setHeight(384);
    turtle1.setOriginX(260);
    turtle1.setOriginY(192);
    root.getChildren().add(turtle1);
    turtle1.setAnimated(false);
    textField1.setLayoutX(136);
    textField1.setLayoutY(0);
    textField1.setPrefHeight(24);
    textField1.setPrefWidth(80);
    textField1.setPromptText("depth");
    root.getChildren().add(textField1);
    textField2.setLayoutX(232);
    textField2.setLayoutY(0);
    textField2.setPrefHeight(24);
    textField2.setPrefWidth(80);
    textField2.setPromptText("callAmount");
    root.getChildren().add(textField2);
    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("quadratpflanze");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public quadratpflanze

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void quadratPflanze(double[] pos, double lange, int depth, int seiteZuIgnorieren) {
    /*
     * sides are ints counted clockwise
     * 0 is top
     * 1 is right
     * 2 is bottom
     * 3 is left
     */

    if (depth > 0) {
      callAmount++;
      System.out.println(callAmount + "");
      textField2.setText(callAmount + "");

      double halbelange = lange / 2;
      turtle1.moveto(pos[0], pos[1] + halbelange);
      turtle1.turnto(0);
      turtle1.draw(halbelange);
      for (int i = 0; i < 3; i++) {
        turtle1.turn(-90);
        turtle1.draw(lange);
      }
      turtle1.turn(-90);
      turtle1.draw(halbelange);

      double newlange = lange / 3;
      double offset = halbelange + (newlange / 2);

      double[] pos0 = new double[] { pos[0], pos[1] + offset };
      double[] pos1 = new double[] { pos[0] + offset, pos[1] };
      double[] pos2 = new double[] { pos[0], pos[1] - offset };
      double[] pos3 = new double[] { pos[0] - offset, pos[1] };
      double[][] newpos = new double[][] { pos0, pos1, pos2, pos3 };
      depth--;
      for (int i = 0; i < 4; i++) {
        if (i != seiteZuIgnorieren) {
          if (i < 2) { // um immer die gegengesetzte seite zu "ignorieren"
            quadratPflanze(newpos[i], newlange, depth, i + 2);
          } else {
            quadratPflanze(newpos[i], newlange, depth, i - 2);
          }

        }
      }

    }

  }

  public void bquadratPflanze1_Action(Event evt) {
    turtle1.clear();
    callAmount = 0;
    double[] startPos = { 0, 0 };
    int depth;
    try {
      depth = Integer.parseInt(textField1.getText());
    } catch (Exception e) {
      depth = 5;
    }
    quadratPflanze(startPos, 150, depth, 2);
  } // end of bquadratPflanze1_Action

  // end methods
} // end of class quadratpflanze
