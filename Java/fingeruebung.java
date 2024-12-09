import java.util.Random;

/**
 *
 * Description
 *
 * @version 1.0 from 11.10.2024
 * @author
 */

public class fingeruebung {
  // start attributes
  // end attributes
  int stepsCount = 0;
  // start methods

  public static void main(String[] args) {
    fingeruebung programm = new fingeruebung();
    programm.dostuff();
  } // end of main

  public void dostuff() {
    int[] arr = new int[20];
    int randRange = 50;
    // fill array sorted with rand. numbers
    arr[0] = new Random().nextInt(randRange);
    for (int i = 1; i < arr.length; i++) {
      arr[i] = arr[i - 1] + new Random().nextInt(randRange);
    }

    int halfIndex = arr.length / 2;
    int toSearch = arr[new Random().nextInt(arr.length)];
    printarr(arr);

    stepsCount = 0;
    System.out.println("--- to search: " + toSearch);
    int ind = binarySearch(arr, halfIndex, (double) halfIndex, toSearch);
    System.out.println("--- found at index: " + ind + ": " + arr[ind]);
    System.out.println("--- step needed: " + stepsCount);
    // find(arr, arr[new Random().nextInt(arr.length)]);
    // insertion(arr);
    System.exit(0);
  }

  int binarySearch(int arr[], int halfIndex, double step, int num) {
    System.out.println(halfIndex);
    if (halfIndex >= 0 && halfIndex <= arr.length && step > 0) {
      stepsCount++;
      if (arr[halfIndex] == num) {
        return halfIndex;
      }
      if (step > 1) {
        // step = (step + 1) / 2; // step +1 to improve rounding and reduce steps taken
        step = step / 2; // more steps becaus faster down rounding
      }
      System.out.println("-- step " + step);
      if (num > arr[halfIndex]) {
        return binarySearch(arr, halfIndex + (int) Math.round(step), step, num);
      } else {
        return binarySearch(arr, halfIndex - (int) Math.round(step), step, num);
      }

    }

    return -1;
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
      System.out.println(i + ": " + arr[i]);
    }
  }

  // end methods
} // end of class sort
