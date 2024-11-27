/**
 *
 * Beschreibung
 *               
 * @version 1.0 vom 15.10.2024
 * @author 
 */

public abstract class MoebelMitBoeden extends Moebel {
  
  // Anfang Attribute
  private int anzahlBoeden;
  // Ende Attribute
  
  // Anfang Methoden
  public int getAnzahlBoeden() {
    return anzahlBoeden;
  }

  public void setAnzahlBoeden(int anzahlBoedenNeu) {
    anzahlBoeden = anzahlBoedenNeu;
  }

  // Ende Methoden
} // end of MoebelMitBoeden
