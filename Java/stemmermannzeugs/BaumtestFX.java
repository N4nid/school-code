import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.11.2024
 * @author
 */

public class BaumtestFX extends Application {
  // Anfang Attribute
  private Line line1 = new Line();
  private TextField textField1 = new TextField();
  private Button beinfuegen1 = new Button();
  private Button bloeschen1 = new Button();
  private Button bsuchen1 = new Button();
  private Button bausgeben1 = new Button();
  private Button bBaumzeichnen1 = new Button();
  // eigene Attribute
  private TextField[] visualBaum = new TextField[64];
  private Line[] visualLine = new Line[64];
  private BinaerBaum meinBaum;
  private StapelObj elemente = new StapelObj(new PosKey(0, 0));
  int breite = 40;
  int hoehe = 20;
  int abstandX = 10;
  int abstandY = 40;
  int starty = 300;
  int startx = 50;
  Pane root;
  // Ende Attribute

  public void start(Stage primaryStage) {
    root = new Pane();
    Scene scene = new Scene(root, 1707, 970);
    // Anfang Komponenten

    line1.setStartX(1584);
    line1.setStartY(8);
    line1.setEndX(1648);
    line1.setEndY(32);
    root.getChildren().add(line1);
    textField1.setLayoutX(88);
    textField1.setLayoutY(16);
    textField1.setPrefHeight(41);
    textField1.setPrefWidth(113);
    root.getChildren().add(textField1);
    beinfuegen1.setLayoutX(264);
    beinfuegen1.setLayoutY(32);
    beinfuegen1.setPrefHeight(24);
    beinfuegen1.setPrefWidth(80);
    beinfuegen1.setText("einfuegen");
    beinfuegen1.setOnAction(
        (event) -> {
          beinfuegen1_Action(event);
        });
    root.getChildren().add(beinfuegen1);
    bloeschen1.setLayoutX(384);
    bloeschen1.setLayoutY(32);
    bloeschen1.setPrefHeight(24);
    bloeschen1.setPrefWidth(80);
    bloeschen1.setText("loeschen");
    bloeschen1.setOnAction(
        (event) -> {
          bloeschen1_Action(event);
        });
    root.getChildren().add(bloeschen1);
    bsuchen1.setLayoutX(496);
    bsuchen1.setLayoutY(32);
    bsuchen1.setPrefHeight(24);
    bsuchen1.setPrefWidth(80);
    bsuchen1.setText("suchen");
    bsuchen1.setOnAction(
        (event) -> {
          bsuchen1_Action(event);
        });
    root.getChildren().add(bsuchen1);
    bausgeben1.setLayoutX(608);
    bausgeben1.setLayoutY(32);
    bausgeben1.setPrefHeight(24);
    bausgeben1.setPrefWidth(80);
    bausgeben1.setText("ausgeben");
    bausgeben1.setOnAction(
        (event) -> {
          bausgeben1_Action(event);
        });
    root.getChildren().add(bausgeben1);
    bBaumzeichnen1.setLayoutX(728);
    bBaumzeichnen1.setLayoutY(24);
    bBaumzeichnen1.setPrefHeight(24);
    bBaumzeichnen1.setPrefWidth(104);
    bBaumzeichnen1.setText("Baumzeichnen");
    bBaumzeichnen1.setOnAction(
        (event) -> {
          bBaumzeichnen1_Action(event);
        });
    root.getChildren().add(bBaumzeichnen1);
    // Ende Komponenten

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("BaumtestFX");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public BaumtestFX

  // Anfang Methoden

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void beinfuegen1_Action(Event evt) {
    // TODO hier Quelltext einfügen
    // TODO hier Quelltext einfügen
    int eingabe = Integer.parseInt(textField1.getText());
    if (meinBaum == null) {
      meinBaum = new BinaerBaum(eingabe);
    } else {
      meinBaum.einfuegen(eingabe);
    } // end of if-else

  } // end of beinfuegen1_Action

  public void bloeschen1_Action(Event evt) {
    // TODO hier Quelltext einfügen

  } // end of bloeschen1_Action

  public void bsuchen1_Action(Event evt) {
    // TODO hier Quelltext einfügen

  } // end of bsuchen1_Action

  public void bausgeben1_Action(Event evt) {
    // TODO hier Quelltext einfügen
    PosKey elem;
    for (int i = 0; i < 64; i++) {
      visualBaum[i].setVisible(false);
    }

    meinBaum.ausgabeInorder(elemente);
    elem = (PosKey) elemente.pop();
    while (elem != null) {
      visualBaum[elem.getPos()].setText(elem.getKey() + "");
      visualBaum[elem.getPos()].setVisible(true);
      elem = (PosKey) elemente.pop();
    } // end of while
    // cp.repaint();

  } // end of bausgeben1_Action

  public void bBaumzeichnen1_Action(Event evt) {
    // TODO hier Quelltext einfügen

    visualBaum[0] = new TextField();
    visualLine[0] = new Line();
    int l = 1;
    for (int j = 5; j >= 0; j--) {
      int k = 0;
      for (int i = (int) Math.pow(2, j); i < Math.pow(2, j + 1); i++) {
        visualBaum[i] = new TextField();
        visualLine[i] = new Line();
        if (j < 5) {
          // int myX = visualBaum[i].get
          int myX = (int) ((visualBaum[2 * i].getLayoutX() + visualBaum[2 * i + 1].getLayoutX()) / 2);
          visualBaum[i].setLayoutX(myX);
          visualBaum[i].setLayoutY(starty + j * (hoehe + abstandY));
          visualBaum[i].setPrefHeight(hoehe);
          visualBaum[i].setPrefWidth(breite);
          visualLine[i].setStartX(myX + breite / 2);
          visualLine[i].setStartY(starty + j * (hoehe + abstandY));
          visualLine[i]
              .setEndX((startx + k * (breite * l + abstandX) + startx + (k + 1) * (breite * l + abstandX)) / 2);
          visualLine[i].setEndY(starty + (j - 1) * (hoehe + abstandY) + hoehe);

        } else {
          visualBaum[i].setLayoutX(startx + k * (breite * l + abstandX));
          visualBaum[i].setLayoutY(starty + j * (hoehe + abstandY));
          visualBaum[i].setPrefHeight(hoehe);
          visualBaum[i].setPrefWidth(breite);
          visualLine[i].setStartX(startx + k * (breite * l + abstandX) + breite / 2);
          visualLine[i].setStartY(starty + j * (hoehe + abstandY));
          visualLine[i]
              .setEndX((startx + k * (breite * l + abstandX) + startx + (k + 1) * (breite * l + abstandX)) / 2);
          visualLine[i].setEndY(starty + (j - 1) * (hoehe + abstandY) + hoehe);
        } // end of if-else
        root.getChildren().add(visualBaum[i]);
        root.getChildren().add(visualLine[i]);
        k++;
      }
      l = l * 2;
    }

  } // end of bBaumzeichnen1_Action

  // Ende Methoden
} // end of class BaumtestFX
