import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * Description
 *
 * @version 1.0 from 14.10.2024
 * @author
 */

public class sortings extends Application {
  // start attributes
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components

    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("sortings");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public sortings

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  // end methods
} // end of class sortings
