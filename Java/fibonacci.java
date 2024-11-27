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

public class fibonacci extends Application {
  // start attributes
  private Button bfib1 = new Button();
  private TextField textField1 = new TextField();
  private TextField textField2 = new TextField();
  int callAmount = 0;
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 329, 95);
    // start components

    bfib1.setLayoutX(8);
    bfib1.setLayoutY(16);
    bfib1.setPrefHeight(24);
    bfib1.setPrefWidth(80);
    bfib1.setText("fib");
    bfib1.setOnAction(
        (event) -> {
          bfib1_Action(event);
        });
    root.getChildren().add(bfib1);
    textField1.setLayoutX(96);
    textField1.setLayoutY(16);
    textField1.setPrefHeight(24);
    textField1.setPrefWidth(80);
    textField1.setPromptText("index");
    root.getChildren().add(textField1);
    textField2.setLayoutX(192);
    textField2.setLayoutY(16);
    textField2.setPrefHeight(24);
    textField2.setPrefWidth(80);
    textField2.setPromptText("output");
    root.getChildren().add(textField2);
    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("fibonacci");
    primaryStage.setScene(scene);
    primaryStage.show();

  } // end of public fibonacci

  // start methods

  public int fib(int index) {
    callAmount++;
    // System.out.println(callAmount + "");
    if (index <= 2) {
      return 1;
    } else {

      return fib(index - 1) + fib(index - 2);
    }

  }

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void bfib1_Action(Event evt) {
    callAmount = 0;
    int index;
    try {
      index = Integer.parseInt(textField1.getText());
      textField2.setText(fib(index) + "");
    } catch (Exception e) {
      textField1.setText("Enter valid number");
    }
  } // end of bfib1_Action

  // end methods
} // end of class fibonacci
