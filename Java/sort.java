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

public class sort extends Application {
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
    sort();
  } // end of public sort

  // start methods

  public static void main(String[] args) {
    launch(args);
  } // end of main

  void sort() {
    int[] arr = { 5, 3, 2, 1 };
    printarr(arr);
    // bubble(arr);
    selection(arr);
    // insertion(arr);
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

      if (index != -1) {
        for (int k = i; k > index; k--) {
          arr[k] = arr[k - 1];
        }
        arr[index] = val;
      }
    }
    System.out.println("insertion");
    printarr(arr);
  }

  void selection(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int min = arr[i];
      int mindex = i;

      for (int j = i; j < arr.length; j++) {
        if (arr[j] < min) {
          min = arr[j];
          mindex = j;
        }
      }
      int swp = arr[i];
      arr[i] = arr[mindex];
      arr[mindex] = swp;

    }
    System.out.println("selection");
    printarr(arr);
  }

  void bubble(int[] arr) {
    boolean unsorted = true;
    while (unsorted) {
      unsorted = false;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
          unsorted = true;
          int swp = arr[i];
          arr[i] = arr[i - 1];
          arr[i - 1] = swp;
        }

      }
    }
    System.out.println("bubble");
    printarr(arr);
  }

  void printarr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  // end methods
} // end of class sort
