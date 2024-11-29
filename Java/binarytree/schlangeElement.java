public class schlangeElement extends schlange {
  schlangeElement next;
  Object element;

  public void print() {
    System.out.println("" + element);
  }

  public void printRecursiv() {
    System.out.println("" + element);
    if (next != null) {
      next.printRecursiv();
    }

  }

  public boolean hastNext() {
    return (next != null);
  }

  public schlangeElement(Object element) {
    this.element = element;
  }

  public schlangeElement getNext() {
    return this.next;
  }

  public void setNext(schlangeElement next) {
    this.next = next;
  }
}
