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

public class fingeruebung extends Application {
  // start attributes
  // end attributes

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components

    // end components

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("sort");
    primaryStage.setScene(scene);
    primaryStage.show();
    dostuff();
  } // end of public sort

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  void dostuff() {
    int[] arr = new int[20];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Random().nextInt(100);
    }
    printarr(arr);
    find(arr, arr[new Random().nextInt(arr.length)]);
    // insertion(arr);
    System.exit(0);
  }

  int find(int[] arr, int num) {
    System.out.println("suche: " + num);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        System.out.println("Index: " + i);
        return i;
      }
    }
    return -1;
  }

  void insertion(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      int index = -1;
      for (int j = 0; j < i; j++) {
        if (val < arr[j]) {
          index = j;
          break;
        }
      }

      if (index != -1 && index != i) {
        for (int k = i; k > index; k--) {
          arr[k] = arr[k - 1];
        }
        arr[index] = val;
      }
    }
    System.out.println("insertion");
    printarr(arr);
  }

  void printarr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  // end methods
} // end of class sort
