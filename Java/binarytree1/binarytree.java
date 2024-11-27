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
