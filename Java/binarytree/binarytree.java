public class binarytree {
  public node root = null;

  public binarytree() {
  }

  public binarytree(node root) {
    this.root = root;
  }

  public void insert(int key) {
    if (this.root != null) {
      this.root.insert(key);
    } else {
      this.root = new node(key);
    }
  }

  public void delete(int key) {
    if (this.root != null) {
      if (this.root.getKey() == key) { // für den 3ten fall, Falls Root node entfernt wird.
        node aboveRoot = new node(key - 1); // Füge temporären Knoten über root ein, damit delete funktioniert.
        aboveRoot.setLeft(this.root);
        this.root = this.root.delete(aboveRoot, true);
        aboveRoot = null;
      } else {

        this.root.findForDelete(key); // sonst wie normal löschen
      }

    }
  }

  public node depthSearch(int key) {
    stapel todo = new stapel();
    stapelElement start = new stapelElement(this.root);
    todo.push(start);
    System.out.println("> depthSearch:");
    while (todo.last != null) {
      Object elem = todo.pop().element;
      node currentNode;
      if (elem instanceof node) {
        currentNode = (node) elem;
        System.out.println(currentNode.getKey());
      } else {
        throw new Error("not a node in the queue");
      }
      if (currentNode != null && currentNode.getKey() == key) {
        return currentNode;
      }
      // Nachbarn adden
      // da es sich um ein Binärbaum handelt, muss nicht überprüft werden ob sie noch
      // nicht besucht worden sind
      if (currentNode.getLeft() != null)
        todo.push(new stapelElement(currentNode.getLeft()));
      if (currentNode.getRight() != null)
        todo.push(new stapelElement(currentNode.getRight()));

    }

    return null;
  }

  public node widthSearch(int key) {
    schlange todo = new schlange();
    schlangeElement start = new schlangeElement(this.root);
    todo.enqueue(start);
    System.out.println("> widthSearch:");
    while (todo.last != null) {
      Object elem = todo.dequeue().element;
      node currentNode;
      if (elem instanceof node) {
        currentNode = (node) elem;
        System.out.println(currentNode.getKey());
      } else {
        throw new Error("not a node in the stack");
      }
      if (currentNode != null && currentNode.getKey() == key) {
        return currentNode;
      }
      // Nachbarn adden
      // da es sich um ein Binärbaum handelt, muss nicht überprüft werden ob sie noch
      // nicht besucht worden sind
      if (currentNode.getLeft() != null)
        todo.enqueue(new schlangeElement(currentNode.getLeft()));
      if (currentNode.getRight() != null)
        todo.enqueue(new schlangeElement(currentNode.getRight()));

    }

    return null;
  }

  public node find(int key) {
    if (this.root != null) {
      if (this.root.getKey() == key) {
        return this.root; // root wurde gesucht
      } else {
        return this.root.find(key); // sonst suchen
      }

    }
    return null;
  }

  public void display() {
    if (this.root != null) {
      this.root.display("");
    }
  }

  public void printInorder() {

  }

}
