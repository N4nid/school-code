import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import je.fx.util.Turtle;
import javafx.scene.canvas.*;
import javafx.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 17.09.2024
 * @author
 */

public class sierpinski extends Application {
  // start attributes
  private Turtle turtle1 = new Turtle();
  private Button button1 = new Button();
  private TextField textField1 = new TextField();
  private TextField textField2 = new TextField();
  private TextField textField3 = new TextField();
  int callAmount = 0;
  int counter = 1;
  int defaultLange = 420;
  private Button button2 = new Button();
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 945, 903);
    // start components

    turtle1.setLayoutX(16);
    turtle1.setLayoutY(40);
    turtle1.setWidth(904);
    turtle1.setHeight(856);
    turtle1.setOriginX(452);
    turtle1.setOriginY(428);
    root.getChildren().add(turtle1);
    turtle1.setAnimated(false);
    button1.setLayoutX(8);
    button1.setLayoutY(8);
    button1.setPrefHeight(24);
    button1.setPrefWidth(80);
    button1.setText("sierpinski");
    button1.setOnAction(
        (event) -> {
          button1_Action(event);
        });
    root.getChildren().add(button1);
    textField1.setLayoutX(104);
    textField1.setLayoutY(8);
    textField1.setPrefHeight(24);
    textField1.setPrefWidth(80);
    textField1.setPromptText("lange");
    root.getChildren().add(textField1);
    textField2.setLayoutX(192);
    textField2.setLayoutY(8);
    textField2.setPrefHeight(24);
    textField2.setPrefWidth(80);
    textField2.setPromptText("depth");
    root.getChildren().add(textField2);
    textField3.setLayoutX(280);
    textField3.setLayoutY(8);
    textField3.setPrefHeight(24);
    textField3.setPrefWidth(80);
    textField3.setPromptText("callAmount");
    root.getChildren().add(textField3);
    button2.setLayoutX(368);
    button2.setLayoutY(8);
    button2.setPrefHeight(24);
    button2.setPrefWidth(80);
    button2.setText("fun");
    button2.setOnAction(
        (event) -> {
          button2_Action(event);
        });
    root.getChildren().add(button2);
    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("sierpinski");
    primaryStage.setScene(scene);
    primaryStage.show();

  } // end of public sierpinski

  // start methods
  public void sierpinskiDreieck(double startX, double startY, int lange, int depth) {
    if (depth > 0) {
      callAmount++;
      System.out.println(callAmount);
      textField3.setText(callAmount + "");
      turtle1.moveto(startX, startY);
      turtle1.turn(60);
      for (int i = 0; i < 3; i++) {
        turtle1.draw(lange);
        turtle1.turn(120);
      }
      turtle1.turnto(0);
      depth--;
      int halbeLange = lange / 2;
      // neue startwerte berechnen
      // rechts
      sierpinskiDreieck(startX + halbeLange, startY, lange / 2, depth);
      // links
      sierpinskiDreieck(startX - halbeLange, startY, lange / 2, depth);
      // oben
      double dreieckHohe = Math.sqrt((double) (Math.pow(lange, 2) - Math.pow(halbeLange, 2)));// satz des Pythagoras
      sierpinskiDreieck(startX, startY + dreieckHohe, lange / 2, depth);

    }
  }

  public void sierpinskiDreieckInit(double startX, double startY, int lange) {
    turtle1.clear();
    callAmount = 0;
    turtle1.moveto(startX - lange, startY);
    turtle1.turnto(0);
    for (int i = 0; i < 3; i++) {
      turtle1.draw(lange * 2);
      turtle1.turn(120);
    }
  }

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void button1_Action(Event evt) {
    int startLange;
    int depth;

    try {
      startLange = Integer.parseInt(textField1.getText());
    } catch (Exception e) {
      startLange = defaultLange;
    }
    try {
      depth = Integer.parseInt(textField2.getText());
    } catch (Exception e) {
      depth = 5;
    }
    int startX = 0;
    int startY = 0 - startLange;

    // draw initial triangle
    sierpinskiDreieckInit(startX, startY, startLange);
    sierpinskiDreieck(startX, startY, startLange, depth);
  } // end of button1_Action

  public void button2_Action(Event evt) {
    int startLange = defaultLange;
    int startX = 0;
    int startY = 0 - startLange;
    sierpinskiDreieckInit(startX, startY, startLange);
    sierpinskiDreieck(startX, startY, startLange, counter);
    if (counter < 8) {
      counter++;
    } else {
      counter = 1;
    }

  } // end of button2_Action

  // end methods
} // end of class sierpinski
