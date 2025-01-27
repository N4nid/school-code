import java.util.Random;

/**
 *
 * Description
 *
 * @version 1.0 from 11.10.2024
 * @author
 */

public class interfacesTest {
  // start attributes
  // end attributes
  // start methods

  public static void main(String[] args) {
    interfacesTest programm = new interfacesTest();
    programm.dostuff();
  } // end of main

  public void dostuff() {
    lehrer1 l1 = new lehrer1();
    lehrer2 l2 = new lehrer2();

    System.out.println("lehrer1:");
    l1.bewerten(1);
    l1.printKriterien();

    System.out.println("lehrer2:");
    l2.bewerten(0.9);
    l2.printKriterien();
  }

  // end methods
} // end of class sort

interface notengebung {
  public void bewerten(double leistungInProzent); // 0.0 - 1.0

  public void printKriterien();
}

class lehrer1 implements notengebung {
  public void bewerten(double leistungInProzent) {
    int gewurfelteNoten = new Random().nextInt(15);
    System.out.println("Deine note: " + gewurfelteNoten);
  }

  public void printKriterien() {
    System.out.println("total made up bullshit");
  }
}

class lehrer2 implements notengebung {
  public void bewerten(double leistungInProzent) {
    int note = (int) (leistungInProzent * 15);
    System.out.println("Deine Note: " + note);
  }

  public void printKriterien() {
    System.out.println("sane normal criteria");
  }
}
