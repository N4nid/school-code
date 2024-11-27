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
 * @version 1.0 vom 10.09.2024
 * @author 
 */

public class matrix extends Application {
  // Anfang Attribute
  private Button bmultiply1 = new Button();
  private TextArea textArea1 = new TextArea();
  private TextArea textArea2 = new TextArea();
  private TextArea textArea3 = new TextArea();
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 486, 279);
    // Anfang Komponenten
    
    bmultiply1.setLayoutX(8);
    bmultiply1.setLayoutY(8);
    bmultiply1.setPrefHeight(24);
    bmultiply1.setPrefWidth(80);
    bmultiply1.setText("multiply");
    bmultiply1.setOnAction(
    (event) -> {bmultiply1_Action(event);} 
    );
    root.getChildren().add(bmultiply1);
    textArea1.setLayoutX(8);
    textArea1.setLayoutY(48);
    textArea1.setPrefHeight(80);
    textArea1.setPrefWidth(120);
    root.getChildren().add(textArea1);
    textArea2.setLayoutX(144);
    textArea2.setLayoutY(48);
    textArea2.setPrefHeight(80);
    textArea2.setPrefWidth(120);
    root.getChildren().add(textArea2);
    textArea3.setLayoutX(80);
    textArea3.setLayoutY(184);
    textArea3.setPrefHeight(80);
    textArea3.setPrefWidth(120);
    root.getChildren().add(textArea3);
    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("matrix");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public matrix
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public int[][] getMatrix(TextArea txt)  {
    String[] smatrix1_rows = txt.getText().split("\n");
    int matrix_colums_count = smatrix1_rows[0].split(",").length;
    int[][] matrix = new int[smatrix1_rows.length][matrix_colums_count];
    
    for (int i = 0; i < smatrix1_rows.length; i++) {
      //System.out.println(smatrix1_rows[i].split(",").length);
      if(smatrix1_rows[i].split(",").length != matrix_colums_count){
        System.out.println("missing columns");
        int[][] emptymatrix = {{}};
        return emptymatrix;
        
      } // end of for
      
      for (int k = 0; k < matrix_colums_count; k++) {
        matrix[i][k] = Integer.parseInt(smatrix1_rows[i].split(",")[k]);
        
      }
      
    } // end of bmultiply1_Action
    
    return  matrix;
  }
  
  public int[][] multiply(int[][] m1,int[][] m2) {
  
    for (int i = 0; i < m1.length; i++) {
      int zelle = 0;
      for (int k = 0; k < m2[0].length; k++) {
        
      }
      
    }
    
    return m1;
  }
  
  
  public void bmultiply1_Action(Event evt) {
    // TODO hier Quelltext einfügen
    int[][] matrix1 = getMatrix(textArea1);
    int[][] matrix2 = getMatrix(textArea2);
    
    int[][] result = multiply(matrix1,matrix2);
    for (int i = 0; i < result.length; i++) {
      for (int k = 0; k < result[0].length; k++) {
        textArea3.appendText(result[i][k]+" ");
      }
      textArea3.appendText("\n");
    }
    
    // Ende Methoden
  } // end of class matrix
}