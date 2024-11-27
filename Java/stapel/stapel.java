public class stapel {
  public stapelElement first;
  public stapelElement last;

  public void display() {
    if (this.last != null) {
      this.last.printRecursiv();
    }
  }

  public stapelElement pop() {
    if (this.last != null) {
      stapelElement oldLast = this.last;
      this.last = this.last.getNext();
      return oldLast;
    }
    return null; // should find better way to handle this
  }

  public void push(stapelElement element) {
    if (this.first == null) {
      this.first = element;
      this.last = element;
    } else {
      element.setNext(this.last); // links from last to first
      // this.last.setNext(element); //links from first to last
      this.last = element;
    }
  }

}
