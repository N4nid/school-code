/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 11.11.2024
 * @author 
 */

public class PosKey {  // bitte kommentieren
  
  // Anfang Attribute
  private int pos;
  private int key;
  // Ende Attribute
  
  public PosKey(int myPos, int myKey) {
    this.pos = myPos;
    this.key = myKey;
/*  folgende Zeilen sind äquivalent, das this ist eine zusätzliche Sicherheit
    pos = myPos;
    key = myKey;
    */
  }

  // Anfang Methoden
  public int getPos() {
    return pos;
  }

  public void setPos(int posNeu) {
    pos = posNeu;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int keyNeu) {
    key = keyNeu;
  }

  // Ende Methoden
} // end of PosKey
