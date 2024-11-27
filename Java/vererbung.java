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
 * @version 1.0 from 11.10.2024
 * @author
 */

public class vererbung extends Application {
  // start attributes
  // end attributes
  private Button button1 = new Button();
  private Button button2 = new Button();
  private TextField textField1 = new TextField();
  private TextField textField2 = new TextField();
  private TextArea textArea1 = new TextArea();
  int size = 10;
  Verkehrsmittel[] vkmittel = new Verkehrsmittel[size];
  int pos = 0;

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 1000, 1000);
    // start components
    button2.setLayoutX(8);
    button2.setLayoutY(86);
    button2.setPrefHeight(24);
    button2.setPrefWidth(80);
    button2.setText("Show");
    button2.setOnAction(
        (event) -> {
          button2_Action(event);
        });
    root.getChildren().add(button2);
    button1.setLayoutX(8);
    button1.setLayoutY(16);
    button1.setPrefHeight(24);
    button1.setPrefWidth(80);
    button1.setText("add");
    button1.setOnAction(
        (event) -> {
          button1_Action(event);
        });
    root.getChildren().add(button1);
    textField1.setLayoutX(104);
    textField1.setLayoutY(16);
    textField1.setPrefHeight(40);
    textField1.setPrefWidth(500);
    root.getChildren().add(textField1);
    textField2.setLayoutX(104);
    textField2.setLayoutY(86);
    textField2.setPrefHeight(40);
    textField2.setPrefWidth(500);
    root.getChildren().add(textField2);
    textArea1.setLayoutX(104);
    textArea1.setLayoutY(130);
    textArea1.setPrefHeight(380);
    textArea1.setPrefWidth(280);
    root.getChildren().add(textArea1);

    // end components
    textField1.setText("10 Verkehrsmittel Auto|Motorrad");
    textField2.setText("Set: [Auto: Marke | Motorrad: HP]");

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("sort");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public sort

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void button1_Action(Event evt) {
    if (pos < vkmittel.length) {
      String typ = textField1.getText();
      String atr = textField2.getText();
      textArea1.setText((size - (pos + 1)) + " Verkehrsmittel uebrig");
      switch (typ) {
        case "Auto":
          Auto dasAuto = new Auto();
          dasAuto.setMarke(atr);
          vkmittel[pos] = dasAuto;
          break;
        case "Motorrad":
          Motorrad dasMotorrad = new Motorrad();
          dasMotorrad.setHp(Integer.parseInt(atr));
          vkmittel[pos] = dasMotorrad;
      }

      pos++;
    }
  } // end of button1_Action

  public void button2_Action(Event evt) {
    textArea1.setText("");
    for (int i = 0; i < vkmittel.length; i++) {
      if (vkmittel[i] instanceof Auto) {
        Auto dasAuto = (Auto) vkmittel[i];
        textArea1.appendText("Auto: " + dasAuto.getMarke() + "\n");
      } else {
        Motorrad dasMotorrad = (Motorrad) vkmittel[i];
        textArea1.appendText("Motorrad: " + dasMotorrad.getHp() + "\n");

      }

    }
  }

  // end methods
} // end of class sort
