/**
 *
 * Description
 *
 * @version 1.0 from 11.10.2024
 * @author
 */

public class greedy_robber {
  // nach preisleistung sortieren
  int[] value = { 120, 200, 120 };
  int[] weight = { 20, 40, 30 };

  public static void main(String[] args) {
    greedy_robber programm = new greedy_robber();
    programm.dostuff();
  } // end of main

  public void dostuff() {
    rob(50);
  }

  public void rob(int maxWeight) {
    int currentWeight = maxWeight;
    int i = 0;
    System.out.println("Items: ");

    while (currentWeight > 0) {
      if ((currentWeight - weight[i]) >= 0) {
        currentWeight -= weight[i];
        System.out.println(" " + value[i] + " " + weight[i]);
      } else {
        i++;
        if (i == value.length)
          break;
      }
    }

  }
}
