class Schlange {
  public Knoten start = null;
  public Knoten ende = null;
  
  Schlange (int wert) {
    start = new Knoten(wert);
  }
  
  Schlange () {
  }

  
  public void enqueue(int andererwert) {
    Knoten neuKnoten = new Knoten(andererwert);
    
    if (start == null) {
      start = neuKnoten;
      ende = neuKnoten;      
    }
    else {
      ende.naechstes = neuKnoten;
      ende = neuKnoten;
    } // end of if-else
  }
  
  public boolean isEmpty(){
    if (start == null) {
      return true;
    }
    return false;
  }
  
  public int dequeue(){
    int meinEintrag = start.element;
    start = start.naechstes; 
/*
    if (start == null) {
      ende = null;
    }
    */
    return meinEintrag;
  }
  
}