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

public class stapelMain extends Application {
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
    stapel test = new stapel();
    System.out.println("Elements pushed");
    for (int i = 0; i < 10; i++) {
      stapelElement element = new stapelElement(i);
      element.print();
      test.push(element);
    }
    // test.display();
    System.out.println("----");
    System.out.println("Elements popped");
    for (int i = 0; i < 10; i++) {
      test.pop().print();
    }
  }

  // end methods
} // end of class sort
