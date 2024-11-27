import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * Description
 *
 * @version 1.0 from 10.10.2024
 * @author
 */

public class test extends Application {
  // start attributes
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components

    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("test");
    primaryStage.setScene(scene);
    primaryStage.show();
    test();
  } // end of public test

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  void test() {
    int[] arr = new int[10];
    fillArr(arr);
    System.out.println(max(arr));
    System.out.println(sum(arr));
  }

  void fillArr(int[] arr) {
    int maxRnd = 10;
    for (int i = 0; i < arr.length; i++) {
      // arr[i] = i; //if there is no random
      arr[i] = new Random().nextInt(maxRnd);
    }
  }

  int sum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }

  int max(int[] arr) {
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  // end methods
} // end of class test
