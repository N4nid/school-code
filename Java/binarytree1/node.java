public class node {
  private node left = null;
  private node right = null;
  private int key;
  private int grad;

  // konstruktor
  public node() {
  }

  public node(int key) {
    this.setKey(key);
  }

  public node(int key, node left, node right) {
    this.setKey(key);
    this.setLeft(left);
    this.setRight(right);
  }
  // konstruktor

  public void insert(int key) {
    if (key < this.key) {
      if (this.left == null) {
        this.left = new node(key);
      } else {
        this.left.insert(key);
      }
    } else {
      if (this.right == null) {
        this.right = new node(key);
      } else {
        this.right.insert(key);
      }
    }
  }

  public node delete(node nodeAbove, boolean left) {
    int grad;
    node newNode;

    // da der übergeordnete Knoten übergeben wird, kann der zu löschende rechts oder
    // links liegen.
    // Spart if-Verzweigungen
    if (left) {
      grad = nodeAbove.left.getGrad();
      newNode = nodeAbove.left;
    } else {
      grad = nodeAbove.right.getGrad();
      newNode = nodeAbove.right;
    }
    System.out.println("grad: " + grad);
    switch (grad) { // je nach grad des Knotens ist es ein anderer Fall
      case 0: // Knoten ist Blatt
        newNode = null;
        break;

      case 1:// unterer Knoten muss "hochgeschoben" werden
        if (newNode.getLeft() != null) {
          node lowerNode = newNode.getLeft();
          newNode = lowerNode;
        } else {
          node lowerNode = newNode.getRight();
          newNode = lowerNode;
        }
        break;

      case 2: // what if root
        // need to store the right and left node
        // find the leftmost node of the right subtree with grad 0
        // "replace" node to delete with found node
        // set left and right of said node

        node oldLeft = newNode.getLeft();
        node oldRight = newNode.getRight();
        node aboveLeftmost = findAboveLeftmost(oldRight);
        node leftmost;
        if (aboveLeftmost.left != null) {
          leftmost = aboveLeftmost.getLeft();
          if (leftmost.getRight() != null) { // falls leftmost rechten Knoten hat, diesen hochziehen
            aboveLeftmost.left = leftmost.getRight();
          } else {
            aboveLeftmost.left = null;
          }
        } else { // aboveLeftmost hat keinen Linken knoten -> ist the leftmost
          leftmost = aboveLeftmost;
        }

        leftmost.left = oldLeft;
        if (oldRight != leftmost) { // nicht sich selbst als rechts setzen
          leftmost.right = oldRight;
        }
        newNode = leftmost;

        break;
    }
    if (left) {
      nodeAbove.left = newNode;
    } else {
      nodeAbove.right = newNode;
    }
    // Gibt den Neuen Knoten zurück -> wichtig um root neu zu setzen
    return newNode;
  }

  private node findAboveLeftmost(node nodeToSearch) { // finds node one above the leftmost node
                                                      // Wird gebraucht für delete fall 3
    int grad = nodeToSearch.getGrad();
    if (grad == 0) {
      return nodeToSearch;
    } else if (nodeToSearch.left != null) {
      if (nodeToSearch.left.getLeft() == null) {
        return nodeToSearch;
      } else {
        return findAboveLeftmost(nodeToSearch.getLeft());
      }
    } else { // cant look further cuz there is no left node
      return nodeToSearch;
    }

  }

  public void findForDelete(int key) { // findet knoten über dem zu Löschenden Knoten, da diese auf diesen zeigt.
                                       // Sonst wie reuläres Find, nur mit ein niveau tiefer schauen.
    if (key < this.key) {
      if (this.left != null) {
        if (this.left.getKey() == key) {
          // Found node -> do the deleting
          delete(this, true);

        } else {
          this.left.findForDelete(key);
        }
      }
    } else {
      if (this.right != null) {
        if (this.right.getKey() == key) {
          // Found node -> do the deleting
          delete(this, false);

        } else {
          this.right.findForDelete(key);
        }
      }

    }

  }

  public node find(int key) {
    if (key < this.key) { // dann links schauen
      if (this.left != null) { // schaut links
        if (this.left.getKey() == key) {
          return this.left;
        } else {
          return this.left.find(key); // rekursiv aufrufen um weiter zu schauen
        }
      }
    } else {// selbes wie links nur für rechts
      if (this.right != null) {
        if (this.right.getKey() == key) {
          return this.right;
        } else {
          return this.right.find(key);
        }
      }
    }

    return null; // gibt null zurück falls nichts gefunden wurde.

  }

  public void display(String lvl) {
    System.out.print(lvl + " " + this.key);
    System.out.println();
    if (this.left != null)
      this.left.display(lvl + "l");
    if (this.right != null)
      this.right.display(lvl + "r");

  }

  // getter and setter

  public int getGrad() {
    if (this.left == null && this.right == null)
      return 0;
    else if (this.left != null && this.right != null)
      return 2;
    else
      return 1;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setLeft(node node) {
    this.left = node;
  }

  public void setRight(node node) {
    this.right = node;
  }

  public int getKey() {
    return this.key;
  }

  public node getLeft() {
    return this.left;
  }

  public node getRight() {
    return this.right;
  }

}
