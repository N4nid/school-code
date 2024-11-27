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
 * @version 1.0 from 14.10.2024
 * @author 
 */

public class vererbungMain extends Application {
  // start attributes
  private Button button1 = new Button();
  // end attributes
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 367, 272);
    // start components
    
    button1.setLayoutX(8);
    button1.setLayoutY(8);
    button1.setPrefHeight(24);
    button1.setPrefWidth(80);
    button1.setText("Button");
    button1.setOnAction(
      (event) -> {button1_Action(event);} 
    );
    root.getChildren().add(button1);
    // end components
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("vererbungMain");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public vererbungMain
  
  // start methods
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void button1_Action(Event evt) {
    // TODO add your code here
    
  } // end of button1_Action

  // end methods
} // end of class vererbungMain
