public class schlange {
  public schlangeElement first;
  public schlangeElement last;

  public void print() {
    if (this.first != null) {
      this.first.printRecursiv();
    }
  }

  public schlangeElement dequeue() {
    if (this.first != null) {
      schlangeElement oldFirst = this.first;
      this.first = this.first.getNext();
      return oldFirst;
    }
    return null; // should find better way to handle this
  }

  public void enqueue(schlangeElement element) {
    if (this.first == null) {
      this.first = element;
      this.last = element;
    } else {
      this.last.setNext(element);
      this.last = element;
    }
  }

}
