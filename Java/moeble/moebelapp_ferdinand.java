import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import java.util.Random;


/**
 *
 * Description
 *
 * @version 1.0 from 15.10.2024
 * @author 
 */

public class moebelapp_ferdinand extends Application {
  // start attributes
  private Button bzufall1 = new Button();
  private Button bausgabe1 = new Button();
  private Button bedit1 = new Button();
  private TextField textField1 = new TextField();
  private TextField txanzahlkleiderstangen = new TextField();
  private TextField txanzahlboden = new TextField();
  private TextField txanzahlturen = new TextField();
  private TextField txanzahlschubladen = new TextField();
  // end attributes
  Moebel[] mobel = new Moebel[20];
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 289, 204);
    // start components
    
    bzufall1.setLayoutX(8);
    bzufall1.setLayoutY(16);
    bzufall1.setPrefHeight(24);
    bzufall1.setPrefWidth(80);
    bzufall1.setText("zufall");
    bzufall1.setOnAction(
    (event) -> {bzufall1_Action(event);} 
    );
    root.getChildren().add(bzufall1);
    bausgabe1.setLayoutX(96);
    bausgabe1.setLayoutY(16);
    bausgabe1.setPrefHeight(24);
    bausgabe1.setPrefWidth(80);
    bausgabe1.setText("ausgabe");
    bausgabe1.setOnAction(
    (event) -> {bausgabe1_Action(event);} 
    );
    root.getChildren().add(bausgabe1);
    bedit1.setLayoutX(184);
    bedit1.setLayoutY(16);
    bedit1.setPrefHeight(24);
    bedit1.setPrefWidth(80);
    bedit1.setText("edit");
    bedit1.setOnAction(
    (event) -> {bedit1_Action(event);} 
    );
    root.getChildren().add(bedit1);
    textField1.setLayoutX(8);
    textField1.setLayoutY(56);
    textField1.setPrefHeight(24);
    textField1.setPrefWidth(80);
    textField1.setPromptText("index");
    root.getChildren().add(textField1);
    txanzahlkleiderstangen.setLayoutX(96);
    txanzahlkleiderstangen.setLayoutY(56);
    txanzahlkleiderstangen.setPrefHeight(24);
    txanzahlkleiderstangen.setPrefWidth(168);
    txanzahlkleiderstangen.setText("");
    txanzahlkleiderstangen.setPromptText("anzahlkleiderstangen");
    root.getChildren().add(txanzahlkleiderstangen);
    txanzahlboden.setLayoutX(96);
    txanzahlboden.setLayoutY(88);
    txanzahlboden.setPrefHeight(24);
    txanzahlboden.setPrefWidth(168);
    txanzahlboden.setPromptText("anzahlboden");
    root.getChildren().add(txanzahlboden);
    txanzahlturen.setLayoutX(96);
    txanzahlturen.setLayoutY(128);
    txanzahlturen.setPrefHeight(24);
    txanzahlturen.setPrefWidth(168);
    txanzahlturen.setPromptText("anzahlturen");
    root.getChildren().add(txanzahlturen);
    txanzahlschubladen.setLayoutX(96);
    txanzahlschubladen.setLayoutY(160);
    txanzahlschubladen.setPrefHeight(24);
    txanzahlschubladen.setPrefWidth(168);
    txanzahlschubladen.setPromptText("anzahlschubladen");
    root.getChildren().add(txanzahlschubladen);
    // end components
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("moebelapp");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public moebelapp_ferdinand
  
  // start methods
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void bzufall1_Action(Event evt) {
    // TODO add your code here
    for (int i = 0; i < mobel.length; i++) {
      int rng = new Random().nextInt(4);
      double rnd;
      switch (rng) {
        
        case  0: 
          Haengeschrank h = new Haengeschrank();
          rnd = new Random().nextDouble(100);
          h.setAnzahlKleiderstangen((int)rnd);
          h.setLaenge(rnd);
          h.setBreite(rnd);
          mobel[i] = h;
          break;
        case  1: 
          TuerenSchrank t = new TuerenSchrank();
          rnd = new Random().nextDouble(100);
          t.setAnzahlTueren((int) rnd);
          t.setAnzahlBoeden((int)rnd);
          t.setLaenge(rnd);
          t.setBreite(rnd);
          mobel[i] = t;
          break; 
        case  2: 
          Regal r = new Regal();
          rnd = new Random().nextDouble(100);
          r.setAnzahlBoeden((int)rnd);
          r.setLaenge(rnd);
          r.setBreite(rnd); 
          mobel[i] = r;
          break;
        case  3: 
          SchubladenSchrank s = new SchubladenSchrank();
          rnd = new Random().nextDouble(100);
          s.setAnzahlSchubladen((int)rnd);
          s.setLaenge(rnd);
          s.setBreite(rnd);
          mobel[i] = s;
          break; 
      } // end of switch
    }
    
  } // end of bzufall1_Action

  public void bausgabe1_Action(Event evt) {
    // TODO add your code here
    System.out.println(" ----- ");
    for (int i = 0; i < mobel.length; i++) {
      if (mobel[i] instanceof Haengeschrank) {
        Haengeschrank h = (Haengeschrank)mobel[i];
        System.out.println(i+" Haengeschrank | Kleiderstangen:"+h.getAnzahlKleiderstangen()+" | lange:"+h.getLaenge()+" | breite:"+h.getBreite()+"");
      }else if (mobel[i] instanceof TuerenSchrank) {
        TuerenSchrank t = (TuerenSchrank)mobel[i];
        System.out.println(i+" TuerenSchrank | Tueren:"+t.getAnzahlTueren()+" | boden:"+t.getAnzahlBoeden()+" | lange:"+t.getLaenge()+" | breite:"+t.getBreite()+"");
      } else if (mobel[i] instanceof SchubladenSchrank) {
        SchubladenSchrank s = (SchubladenSchrank)mobel[i];
        System.out.println(i+" SchubladenSchrank | Schubleden:"+s.getAnzahlSchubladen()+" | lange:"+s.getLaenge()+" | breite:"+s.getBreite()+"");
      }else {
        Regal r = (Regal)mobel[i];
        System.out.println(i+" Regal | Boden:"+r.getAnzahlBoeden()+" | lange:"+r.getLaenge()+" | breite:"+r.getBreite()+"");
      } // end of if-else
    }
  } // end of bausgabe1_Action

  public void bedit1_Action(Event evt) {
    // TODO add your code here
    int i = Integer.parseInt(textField1.getText());
    if (mobel[i] instanceof Haengeschrank) {
      Haengeschrank h = (Haengeschrank)mobel[i];
      h.setAnzahlKleiderstangen(Integer.parseInt(txanzahlkleiderstangen.getText()));

      mobel[i] = h;
    }else if (mobel[i] instanceof TuerenSchrank) {
      TuerenSchrank t = (TuerenSchrank)mobel[i];
      t.setAnzahlTueren(Integer.parseInt(txanzahlturen.getText()));
      t.setAnzahlBoeden(Integer.parseInt(txanzahlboden.getText()));
      mobel[i] = t;
    } else if (mobel[i] instanceof SchubladenSchrank) {
      SchubladenSchrank s = (SchubladenSchrank)mobel[i];
      s.setAnzahlSchubladen(Integer.parseInt(txanzahlschubladen.getText()));
      mobel[i] = s;
    }else {
      Regal r = (Regal)mobel[i];
      r.setAnzahlBoeden(Integer.parseInt(txanzahlboden.getText())); 
      mobel[i] = r;
    } // end of if-else
  } // end of bedit1_Action

  // end methods
} // end of class moebelapp
