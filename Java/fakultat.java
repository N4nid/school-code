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

public class fakultat extends Application {
  // start attributes
  private Button button1 = new Button();
  private TextField textField1 = new TextField();
  private TextField textField2 = new TextField();
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 353, 71);
    // start components

    button1.setLayoutX(8);
    button1.setLayoutY(16);
    button1.setPrefHeight(24);
    button1.setPrefWidth(80);
    button1.setText("Calculate");
    button1.setOnAction(
        (event) -> {
          button1_Action(event);
        });
    root.getChildren().add(button1);
    textField1.setLayoutX(104);
    textField1.setLayoutY(16);
    textField1.setPrefHeight(24);
    textField1.setPrefWidth(80);
    root.getChildren().add(textField1);
    textField2.setLayoutX(208);
    textField2.setLayoutY(16);
    textField2.setPrefHeight(24);
    textField2.setPrefWidth(80);
    root.getChildren().add(textField2);
    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("fakultat");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public fakultat

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public int fakultatBerechnen(int zahl) {
    if (zahl == 1) {
      return zahl;
    } else {
      return zahl * fakultatBerechnen(zahl - 1);
    }

  }

  public void button1_Action(Event evt) {
    // TODO add your code here
    int fakultat;
    try {
      fakultat = Integer.parseInt(textField1.getText());
      textField2.setText(fakultatBerechnen(fakultat) + "");
    } catch (Exception e) {
      textField1.setText("Enter valid number");
    }

  } // end of button1_Action

  // end methods
} // end of class fakultat
