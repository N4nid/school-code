/**
 *
 * Beschreibung
 *       
 * @version 1.0 vom 15.10.2024
 * @author 
 */

public abstract class Moebel {
  
  // Anfang Attribute
  private double laenge;
  private double breite;
  // Ende Attribute
  
  // Anfang Methoden
  public double getLaenge() {
    return laenge;
  }

  public void setLaenge(double laengeNeu) {
    laenge = laengeNeu;
  }

  public double getBreite() {
    return breite;
  }

  public void setBreite(double breiteNeu) {
    breite = breiteNeu;
  }

  // Ende Methoden
} // end of Moebel
