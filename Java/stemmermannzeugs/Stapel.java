class Stapel {
  public Knoten start = null;
  
  Stapel (int wert) {
    start = new Knoten(wert);
  }
  
  Stapel () {
  }

  
  public void push(int andererwert) {
    Knoten neuKnoten = new Knoten(andererwert);
    neuKnoten.naechstes = start;
    start = neuKnoten;    
  }
  
  public boolean isEmpty(){
    if (start == null) {
      return true;
    }
    return false;
  }
  
  public int pop(){
    int meinEintrag = start.element;
    start = start.naechstes;    
    return meinEintrag;
  }
  
}