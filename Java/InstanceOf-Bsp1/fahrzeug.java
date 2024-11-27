/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 14.10.2024
 * @author 
 */

public class fahrzeug {
  
  // Anfang Attribute
  private double PositionX;
  private double PositionY;
  private double Geschwindigkeit;
  private String Name;
  // Ende Attribute
  
  // Anfang Methoden
  public double getPositionX() {
    return PositionX;
  }

  public double getPositionY() {
    return PositionY;
  }

  public double getGeschwindigkeit() {
    return Geschwindigkeit;
  }

  public void setName(String NameNeu) {
    Name = NameNeu;
  }
  public String getName() {
    return Name;
  }

  public void setGeschwindigkeit(double GeschwindigkeitNeu) {
    Geschwindigkeit = GeschwindigkeitNeu;
  }

  // Ende Methoden
} // end of fahrzeug
