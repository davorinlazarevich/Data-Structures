public class BSTNode { 
 
  public Comparable info;       // The info in a BST node
  public BSTNode left;          // A link to the left child node
  public BSTNode right;         // A link to the right child node

 
  public BSTNode(Comparable info) {
    this.info = info;
    left = null;
    right = null;
  } 
  
  public void setInfo (Comparable info) {
   this.info = info;
  }
  
  public Comparable getInfo() {
   return info;
  }
  
  public BSTNode getLeft () {
   return left;
  }
  
   public BSTNode getRight () {
   return right;
  }
  
  public void setLeft (BSTNode link) {
      left = link;
  }
  
  public void setRight (BSTNode link) {
      right = link;
  }
}