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

public class pascal extends Application {
  // start attributes
  private Button beinzeln1 = new Button();
  private TextArea textArea1 = new TextArea();
  private TextField textField1 = new TextField();
  private TextField textField2 = new TextField();
  private Button bpyramide1 = new Button();
  // end attributes
  Pane root = new Pane();
  Scene scene = new Scene(root, 800, 400);

  public void start(Stage primaryStage) {
    // start components

    beinzeln1.setLayoutX(8);
    beinzeln1.setLayoutY(8);
    beinzeln1.setPrefHeight(24);
    beinzeln1.setPrefWidth(80);
    beinzeln1.setText("einzeln");
    beinzeln1.setOnAction(
        (event) -> {
          beinzeln1_Action(event);
        });
    root.getChildren().add(beinzeln1);
    textArea1.setLayoutX(8);
    textArea1.setLayoutY(48);
    textArea1.setPrefHeight(280);
    textArea1.setPrefWidth(280);
    root.getChildren().add(textArea1);
    textField1.setLayoutX(104);
    textField1.setLayoutY(8);
    textField1.setPrefHeight(24);
    textField1.setPrefWidth(80);
    textField1.setPromptText("zeile");
    root.getChildren().add(textField1);
    textField2.setLayoutX(192);
    textField2.setLayoutY(8);
    textField2.setPrefHeight(24);
    textField2.setPrefWidth(80);
    textField2.setPromptText("spalte");
    root.getChildren().add(textField2);
    bpyramide1.setLayoutX(288);
    bpyramide1.setLayoutY(8);
    bpyramide1.setPrefHeight(24);
    bpyramide1.setPrefWidth(80);
    bpyramide1.setText("pyramide");
    bpyramide1.setOnAction(
        (event) -> {
          bpyramide1_Action(event);
        });
    root.getChildren().add(bpyramide1);
    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("pascal");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public pascal

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public int pascal(int zeileIndex, int spalteIndex) {
    if (spalteIndex == 1 || zeileIndex == spalteIndex) {
      return 1;
    } else {
      return pascal(zeileIndex - 1, spalteIndex) + pascal(zeileIndex - 1, spalteIndex - 1);
    }
  }

  public void beinzeln1_Action(Event evt) {
    int zeileIndex;
    int spalteIndex;
    try {
      zeileIndex = Integer.parseInt(textField1.getText());
      spalteIndex = Integer.parseInt(textField2.getText());
      textArea1.setText(pascal(zeileIndex, spalteIndex) + "");
    } catch (Exception e) {
      textField1.setText("Enter valid number");
    }
  } // end of beinzeln1_Action

  public void bpyramide1_Action(Event evt) {
    /*
     * for (int z = 1; z <= 10; z++) {
     * for (int s = 1; s < z; s++) {
     * textArea1.appendText(pascal(z, s) + ", ");
     * }
     * textArea1.appendText(pascal(z, z) + "\n");
     * }
     */
    int dimension = 15;
    int startX = 480;
    int startY = 100;
    int width = 20;
    int height = 10;
    int offset = width / 2;

    Label[][] pyramidenStein = new Label[dimension][dimension];
    for (int z = 1; z < dimension; z++) {
      for (int s = 1; s <= z; s++) {
        pyramidenStein[z][s] = new Label();
        pyramidenStein[z][s].setLayoutX((startX - (offset * z)) + (width * s));
        pyramidenStein[z][s].setLayoutY(startY + (height * z) + offset);
        pyramidenStein[z][s].setPrefHeight(height);
        pyramidenStein[z][s].setPrefWidth(width);
        pyramidenStein[z][s].setText(pascal(z, s) + "");
        root.getChildren().add(pyramidenStein[z][s]);
      }
    }

  } // end of bpyramide1_Action

  // end methods
} // end of class pascal
