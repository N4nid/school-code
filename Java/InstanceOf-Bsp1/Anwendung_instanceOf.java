import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 14.10.2024
 * @author 
 */

public class Anwendung_instanceOf extends Application {
  // Anfang Attribute
  private Button button1 = new Button();
  private Button button2 = new Button();
  private Button button3 = new Button();
  private TextField textField1 = new TextField();
  private TextField textField2 = new TextField();
  private TextField textField3 = new TextField();
  private TextArea textArea1 = new TextArea();
  private TextArea textArea2 = new TextArea();
  private fahrzeug[] meineFahrzeuge = new fahrzeug[10];
  int aktuellePosition = 0;
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 1107, 819);
    // Anfang Komponenten
    
    button1.setLayoutX(64);
    button1.setLayoutY(40);
    button1.setPrefHeight(24);
    button1.setPrefWidth(80);
    button1.setText("Button");
    button1.setOnAction(
    (event) -> {button1_Action(event);} 
    );
    root.getChildren().add(button1);
    button2.setLayoutX(184);
    button2.setLayoutY(40);
    button2.setPrefHeight(24);
    button2.setPrefWidth(80);
    button2.setText("Button");
    button2.setOnAction(
    (event) -> {button2_Action(event);} 
    );
    root.getChildren().add(button2);
    button3.setLayoutX(296);
    button3.setLayoutY(32);
    button3.setPrefHeight(24);
    button3.setPrefWidth(80);
    button3.setText("Button");
    button3.setOnAction(
    (event) -> {button3_Action(event);} 
    );
    root.getChildren().add(button3);
    textField1.setLayoutX(72);
    textField1.setLayoutY(96);
    textField1.setPrefHeight(24);
    textField1.setPrefWidth(176);
    root.getChildren().add(textField1);
    textField2.setLayoutX(72);
    textField2.setLayoutY(144);
    textField2.setPrefHeight(24);
    textField2.setPrefWidth(80);
    root.getChildren().add(textField2);
    textField3.setLayoutX(72);
    textField3.setLayoutY(184);
    textField3.setPrefHeight(24);
    textField3.setPrefWidth(80);
    root.getChildren().add(textField3);
    textArea1.setLayoutX(376);
    textArea1.setLayoutY(152);
    textArea1.setPrefHeight(353);
    textArea1.setPrefWidth(321);
    root.getChildren().add(textArea1);
    textArea2.setLayoutX(744);
    textArea2.setLayoutY(152);
    textArea2.setPrefHeight(353);
    textArea2.setPrefWidth(297);
    root.getChildren().add(textArea2);
    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("Anwendung_instanceOf");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public Anwendung_instanceOf
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void button1_Action(Event evt) {
    // TODO hier Quelltext einfügen
    if (textField1.getText().equals("PKW")){
      System.out.println("PKW " + aktuellePosition);
      pkw meinAuto = new pkw();
      meinAuto.setSitze(Integer.parseInt(textField2.getText()));
      meineFahrzeuge[aktuellePosition] = meinAuto;
      aktuellePosition++;
    }
    else if (textField1.getText().equals("Motorrad")) {
      System.out.println("Motorrad " + aktuellePosition);
      motorrad meinmotorrad = new motorrad();
      meinmotorrad.setLautstaerke(Integer.parseInt(textField2.getText()));
      meineFahrzeuge[aktuellePosition] = meinmotorrad;
      aktuellePosition++;
    }
  } // end of button1_Action

  public void button2_Action(Event evt) {
    // TODO hier Quelltext einfügen
    
    for (int i = 0; i < aktuellePosition; i++) {
      if (meineFahrzeuge[i] instanceof pkw) {
        pkw dasAuto = (pkw) meineFahrzeuge[i];
        System.out.println("Sitze: "+dasAuto.getSitze());
      }
      else if (meineFahrzeuge[i] instanceof motorrad) {
        motorrad dasMoped = (motorrad) meineFahrzeuge[i];
        System.out.println("Krach:" + dasMoped.getLautstaerke());
        
      } // end of if-else
      System.out.println( meineFahrzeuge[i].getPositionX());
    }
  } // end of button2_Action

  public void button3_Action(Event evt) {
    // TODO hier Quelltext einfügen
    
  } // end of button3_Action

  // Ende Methoden
} // end of class Anwendung_instanceOf
