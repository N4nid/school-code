import java.util.Random;

/**
 *
 * Description
 *
 * @version 1.0 from 11.10.2024
 * @author
 */

public class sort {

  public static void main(String[] args) {
    sort program = new sort();
    program.doSort();
  } // end of main

  void doSort() {
    int[] arr = new int[50];
    int randRange = 50;
    // fill array sorted with rand. numbers
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Random().nextInt(randRange);
    }
    printarr(arr);
    // bubble(arr);
    // selection(arr);
    // insertion(arr);
    quicksort(arr, 0, arr.length - 1);
    System.out.println("--- ergeb.:");
    printarr(arr);
  }

  void quicksort(int arr[], int start, int end) {
    if (start < end) {
      int splitPoint = divide(arr, start, end);
      System.out.println("splitPoint: " + splitPoint + " - " + arr[splitPoint]);
      quicksort(arr, start, splitPoint - 1);
      quicksort(arr, splitPoint + 1, end);
    }
  }

  int divide(int arr[], int start, int end) {
    int left = start;
    int right = end - 1;
    int pivot = arr[end];

    while (left < right) {
      // finde element größer als pivot von links
      while (left < end && arr[left] <= pivot) {
        left++;
      }

      // finde element kleiner als pivot von rechts
      while (right > start && arr[right] >= pivot) {
        right--;
      }
      // tausche diese
      if (left < right) {
        int tmp = arr[left];
        System.out.println("- switched left:" + tmp + " right:" + arr[right]);
        arr[left] = arr[right];
        arr[right] = tmp;
      }
    }
    // tausche pivot falls links größer ist
    if (arr[left] > pivot) {
      int tmp = arr[left];
      System.out.println("# switched left:" + tmp + " right:" + arr[end]);
      arr[left] = arr[end];
      arr[end] = tmp;
    }

    return left; // new pivot index
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
