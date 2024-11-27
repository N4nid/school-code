class StapelObj {
  public KnotenObj start = null;
  
  StapelObj (Object wert) {
    start = new KnotenObj(wert);
  }
  
  StapelObj () {
  }
  
  
  public void push(Object andererwert) {
    KnotenObj neuKnoten = new KnotenObj(andererwert);
    neuKnoten.naechstes = start;
    start = neuKnoten;    
  }
  
  public boolean isEmpty(){
    if (start == null) {
      return true;
    }
    return false;
  }
  
  public Object pop(){
    if (start == null) {
      return null;   
    }
    Object meinEintrag = start.element;
    start = start.naechstes;    
    return meinEintrag;
  }
  
}