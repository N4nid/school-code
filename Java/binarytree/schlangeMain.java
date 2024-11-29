import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * Description
 *
 * @version 1.0 from 11.10.2024
 * @author
 */

public class schlangeMain extends Application {
  // start attributes
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components

    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("linked list");
    primaryStage.setScene(scene);
    primaryStage.show();
    test();
  } // end of the world

  public static void main(String[] args) {
    launch(args);
  } // end of main

  public static void test() {
    schlange test = new schlange();
    for (int i = 0; i < 10; i++) {
      schlangeElement element = new schlangeElement(i);
      element.print();
      test.enqueue(element);
    }
    // test.print();
    System.out.println("----");
    for (int i = 0; i < 10; i++) {
      test.dequeue().print();

    }
  }

  // end methods
} // end of class sort
