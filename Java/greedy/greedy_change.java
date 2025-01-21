/**
 *
 * Description
 *
 * @version 1.0 from 11.10.2024
 * @author
 */

public class greedy_change {
  // geld ist in cent
  int[] possibleCoins = { 500, 200, 100, 20, 10 };
  int[] productPrices = { 230, 220, 110 };

  public static void main(String[] args) {
    greedy_change programm = new greedy_change();
    programm.dostuff();
  } // end of main

  public void dostuff() {
    change(200, 0);
  }

  public void change(int money, int num) {
    int change = money - productPrices[num];
    System.out.println("Rückgeld: " + change);
    int i = 0;
    System.out.println("Münzen: ");

    if (change < 0) {
      System.out.println("sie idiot");
    }

    while (change > 0) {
      if ((change - possibleCoins[i]) >= 0) {
        change -= possibleCoins[i];
        System.out.println(" " + possibleCoins[i]);
      } else {
        i++;
        if (i == possibleCoins.length)
          break;
      }
    }

  }
}
