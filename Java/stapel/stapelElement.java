public class stapelElement extends stapel {
  stapelElement next;
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

  public stapelElement(Object element) {
    this.element = element;
  }

  public stapelElement getNext() {
    return this.next;
  }

  public void setNext(stapelElement next) {
    this.next = next;
  }
}
