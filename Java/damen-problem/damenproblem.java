
/**
 *
 * Description
 *
 * @version 1.0 from 10.10.2024
 * @author
 */

public class damenproblem {
  // start attributes
  Dame[] damen = new Dame[8]; // Anzahl damen hier anpassen (Funktioniert für n damen)
  int damenCounter = 0;
  int solvesCounter = 0;
  int dim = damen.length;
  // end attributes

  // start methods

  public static void main(String[] args) {
    damenproblem programm = new damenproblem();
    programm.run();
  } // end of main

  void run() {
    solve(0);
  }

  void printDamenPos() {
    System.out.println("#-");
    for (int i = 0; i < damen.length; i++) {
      System.out.println("Dame" + i + " x" + damen[i].x + " y" + damen[i].y);
    }
    System.out.println("#-");
  }

  boolean solve(int row) {
    boolean solvable = false;

    if (damenCounter == damen.length) {
      solvable = true;
      solvesCounter++;
      System.out.println("Solved: " + solvesCounter);
      printDamenPos();
      return solvable;
    }
    if (row == dim) {
      System.out.println("unten Angekommen");
      return solvable;
    }
    // System.out.println("# current row: " + row);
    for (int i = 0; i < dim; i++) {
      if (canBePlaced(i, row)) {
        // System.out.println("-- place here: " + i + " " + row + " Dame: " +
        // damenCounter);
        damen[damenCounter] = new Dame(i, row, damenCounter);
        damenCounter++;

        // System.out.println("setzte naeschste");
        solvable = solve(row + 1);

        // we come back here to either
        // try find a working solution
        // try find another solution
        // Either way the old Dame has to be removed
        damenCounter--;
        damen[damenCounter] = null;

      }
    }
    return solvable;
  }

  boolean canBePlaced(int x, int y) {
    boolean flag = true;
    for (Dame dame : damen) {
      if (dame != null) {
        if (x == dame.x || y == dame.y) { // geraden checken
          // System.out.println("Senkrechte/Horizontale " + x + " " + y + " dame: " +
          // dame.damenNum);
          flag = false;
          break;
        }
        if (Math.abs(x - dame.x) == Math.abs(y - dame.y)) { // diagonalen checken
          // System.out.println("Diagonale " + x + " " + y + " dame: " + dame.damenNum);
          flag = false;
          break;
        }

      }
    }
    return flag;
  }

  // end methods
} // end of class test

class Dame {
  public int damenNum = -1;
  public int x = -1;
  public int y = -1;

  public Dame(int x, int y, int damenNum) {
    this.damenNum = damenNum;
    this.x = x;
    this.y = y;
  }

}
