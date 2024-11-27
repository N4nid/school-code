class BinaerKnoten {
  public BinaerKnoten rechts, links;
  public PosKey element;
  
  public BinaerKnoten(int myPos, int myKey)  {
    rechts = null;
    links = null;
    element = new PosKey(myPos,myKey);
    
  }
  
  public void einfuegen(int myPos, int myKey){
    if (myKey < element.getKey()) { // also links einfügen
      if (links == null){
        BinaerKnoten neuKnoten = new BinaerKnoten(myPos*2,myKey);
        links = neuKnoten;
      }
      else {
        links.einfuegen(myPos*2,myKey);
      } // end of if-else
      
    }
    else {
      if (rechts == null){
        BinaerKnoten neuKnoten = new BinaerKnoten(myPos*2+1,myKey);
        rechts = neuKnoten;
      }
      else {
        rechts.einfuegen(myPos*2+1,myKey);
      } // end of if-else
    } // end of if-else
  }   
  
  public void ausgabeInorder(StapelObj stack) {
    // TODO hier Quelltext einfügen
    if (links != null) {
      links.ausgabeInorder(stack); 
    }
    stack.push(element);
    if (rechts != null) {
      rechts.ausgabeInorder(stack); 
    }
  }
  
  
  
  public BinaerKnoten einfuegen(BinaerKnoten node, boolean right){
    return node;
  }   
   
}
