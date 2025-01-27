import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
  HashSet<Integer> hSet = new HashSet<Integer>();
  ArrayList<Integer> aList = new ArrayList<Integer>();

  // end attributes
  // start methods

  public static void main(String[] args) {
    fingeruebung programm = new fingeruebung();
    programm.dostuff();
  } // end of main

  public void dostuff() {
    for (int i = 0; i < 5; i++) {
      int rng = new Random().nextInt(10);
      hSet.add(rng);
      aList.add(rng);
    }

    System.out.println("HashSet");
    ausgabe(hSet.iterator()); // wird geordnet ausgegeben und es gibt keine gleichen werte 1 3 1 4 -> 1 3 4
    System.out.println("ArrayList:");
    ausgabe(aList.iterator()); // wird so ausgegeben wie reingeschrieben wurde
  }

  void ausgabe(Iterator iterator) {
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  // end methods
} // end of class sort
