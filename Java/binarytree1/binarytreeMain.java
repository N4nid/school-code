
import java.util.Random;
import javafx.scene.shape.Line;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.Group;

/**
 *
 * Description
 *
 * @version 1.0 from 11.10.2024
 * @author
 */

public class binarytreeMain extends Application {
  // start attributes
  Pane root = new Pane();
  Scene scene = new Scene(root, 1000, 1000);
  Group visualisierung = new Group();
  binarytree baum = new binarytree();
  private Button button1 = new Button();
  private Button button2 = new Button();
  private Button button3 = new Button();
  private Button button4 = new Button();
  private Button button5 = new Button();
  private TextField textField1 = new TextField();
  private Slider slider1 = new Slider(100, 500, 200);
  // end attributes
  
  public void start(Stage primaryStage) {
    // start components
    button1.setLayoutX(10);
    button1.setLayoutY(10);
    button1.setPrefHeight(20);
    button1.setPrefWidth(80);
    button1.setText("insert");
    button1.setOnAction(
    (event) -> {
      btn1(event);
    });
    root.getChildren().add(button1);
    button2.setLayoutX(110);
    button2.setLayoutY(10);
    button2.setPrefHeight(20);
    button2.setPrefWidth(80);
    button2.setText("delete");
    button2.setOnAction(
    (event) -> {
      btn2(event);
    });
    root.getChildren().add(button2);
    button3.setLayoutX(210);
    button3.setLayoutY(10);
    button3.setPrefHeight(20);
    button3.setPrefWidth(80);
    button3.setText("clear");
    button3.setOnAction(
    (event) -> {
      btn3(event);
    });
    root.getChildren().add(button3);
    button4.setLayoutX(310);
    button4.setLayoutY(10);
    button4.setPrefHeight(20);
    button4.setPrefWidth(80);
    button4.setText("find");
    button4.setOnAction(
    (event) -> {
      btn4(event);
    });
    root.getChildren().add(button4);
    textField1.setLayoutX(10);
    textField1.setLayoutY(40);
    textField1.setPrefHeight(20);
    textField1.setPrefWidth(80);
    root.getChildren().add(textField1);
    button5.setLayoutX(410);
    button5.setLayoutY(10);
    button5.setPrefHeight(20);
    button5.setPrefWidth(80);
    button5.setText("bsp");
    button5.setOnAction(
    (event) -> {
      btn5(event);
    });
    root.getChildren().add(button5);
    
    root.getChildren().add(visualisierung);
    slider1.setLayoutX(510);
    slider1.setLayoutY(10);
    slider1.setPrefHeight(20);
    slider1.setPrefWidth(120);
    slider1.setShowTickLabels(true);
    slider1.setShowTickMarks(true);
    slider1.setSnapToTicks(true);
    root.getChildren().add(slider1);
    // end components
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("test");
    primaryStage.setScene(scene);
    primaryStage.show();
    test();
  } // end of the world

  // start methods
  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void test() {
    int arr[] = { 9, 5, 16, 3, 7, 12, 19, 14, 18, 20 };
    baum = new binarytree(new node(arr[0]));
    
    for (int i = 1; i < arr.length; i++) {
      baum.insert(arr[i]);
    }
    show();
  }

  // clear btn
  // insert btn+txt
  // delete btn+ ^
  // Find btn +txt

  public void clear() {
    baum = new binarytree();
  }

  public void show() {
    visualisierung.getChildren().clear();
    int offset;
    int yOffset = 50;
    
    offset = (int)slider1.getValue();
    visualizeTree(baum.root, offset, (offset*2), yOffset); // 25 * Tiefe = offset ?
    
  }

  public void visualizeTree(node nodeToVisualize, double offset, double x, double y) {
    if (nodeToVisualize != null) {
      TextField keyTxt = new TextField();
      int height = 20;
      int width = 50;
      int yOffset = 50;
      
      keyTxt.setLayoutX(x);
      keyTxt.setLayoutY(y);
      keyTxt.setPrefHeight(height);
      keyTxt.setPrefWidth(width);
      keyTxt.setText(nodeToVisualize.getKey() + "");
      visualisierung.getChildren().add(keyTxt);
      
      if (nodeToVisualize.getLeft() != null) {
        double newX = x - offset;
        double newY = y + yOffset;
        
        Line line = new Line();
        line.setStartX(x + (width / 2));
        line.setStartY(y + height);
        line.setEndX(newX + (width / 2));
        line.setEndY(newY);
        visualisierung.getChildren().add(line);
        visualizeTree(nodeToVisualize.getLeft(), (offset / 2), newX, newY);
      }
      if (nodeToVisualize.getRight() != null) {
        double newX = x + offset;
        double newY = y + yOffset;
        
        Line line = new Line();
        line.setStartX(x + (width / 2));
        line.setStartY(y + height);
        line.setEndX(newX + (width / 2));
        line.setEndY(newY);
        visualisierung.getChildren().add(line);
        visualizeTree(nodeToVisualize.getRight(), (offset / 2), newX, newY);
      }
    }
  }

  public void btn1(Event evt) {
    try {
      int key = Integer.parseInt(textField1.getText());
      baum.insert(key);
      show();
    } catch (Exception e) {
      textField1.setText("Enter valid num");
    }
  }

  public void btn2(Event evt) {
    try {
      int key = Integer.parseInt(textField1.getText());
      baum.delete(key);
      show();
    } catch (Exception e) {
      textField1.setText("Enter valid num");
    }
  }

  public void btn3(Event evt) {
    clear();
    show();
  }

  public void btn4(Event evt) {
    try {
      int key = Integer.parseInt(textField1.getText());
      node foundNode = baum.find(key);
      if (foundNode != null) {
        textField1.setText("found " + foundNode.getKey());
      } else {
        textField1.setText("not found");
      }
    } catch (Exception e) {
      textField1.setText("Enter valid num");
    }
  }

  public void btn5(Event evt) {
    clear();
    test();
  }
  // end methods
} // end of class sort
