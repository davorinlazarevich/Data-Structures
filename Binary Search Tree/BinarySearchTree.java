public class BinarySearchTree
{
  protected BSTNode root;   // reference to the root of this BST
  boolean found;            // used by remove
  
  // for traversals
  protected ArrayBndQueue inOrderQueue;    // queue of info
  protected ArrayBndQueue preOrderQueue;   // queue of info
  protected ArrayBndQueue postOrderQueue;  // queue of info

  public BinarySearchTree()
  // Creates an empty BST object.
  {
    root = null;
  }

public boolean isEmpty()
// Returns true if this BST is empty, otherwise returns false.
{
  return (root == null);
}

 public int size()
// Returns the number of elements in this BST.
{
  return recSize(root);
} 

private int recSize(BSTNode tree)
// Returns the number of elements in tree.
{
  if (tree == null)    
    return 0;
  else
    return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
} 

private boolean recContains(Comparable element, BSTNode tree)
// Returns true if tree contains an element e such that 
// e.equals(element), otherwise returns false.
{
  if (tree == null)
    return false;       // element is not found
  else if (element.compareTo(tree.getInfo()) < 0)
    return recContains(element, tree.getLeft());   // Search left subtree
  else if (element.compareTo(tree.getInfo()) > 0)
    return recContains(element, tree.getRight());  // Search right subtree
  else
    return true;        // element is found
}

public boolean contains (Comparable element)
// Returns true if this BST contains an element e such that 
// e.equals(element), otherwise returns false.
{
  return recContains(element, root);
} 

private Comparable recGet(Comparable element, BSTNode tree)
// Returns an element e from tree such that e.equals(element);
// if no such element exists returns null.
{
  if (tree == null)
    return null;             // element is not found
  else if (element.compareTo(tree.getInfo()) < 0)
    return recGet(element, tree.getLeft());          // get from left subtree
  else
  if (element.compareTo(tree.getInfo()) > 0)
    return recGet(element, tree.getRight());         // get from right subtree
  else
    return tree.getInfo();  // element is found
}

public Comparable get(Comparable element)
// Returns an element e from this BST such that e.equals(element);
// if no such element exists returns null.
{
  return recGet(element, root);
} 

private BSTNode recAdd(Comparable element, BSTNode tree)
// Adds element to tree; tree retains its BST property.
{
  if (tree == null)
    // Addition place found
    tree = new BSTNode(element);
  else if (element.compareTo(tree.getInfo()) <= 0)
    tree.setLeft(recAdd(element, tree.getLeft()));     // Add in left subtree
  else
    tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
  return tree;
} 

public void add (Comparable element)
// Adds element to this BST. The tree retains its BST property.
{
  root = recAdd(element, root);
} 

public boolean remove (Comparable element)
// Removes an element e from this BST such that e.equals(element)
// and returns true; if no such element exists returns false. 
{
  root = recRemove(element, root);
  return found;
}

private BSTNode recRemove(Comparable element, BSTNode tree)
// Removes an element e from tree such that e.equals(element)
// and returns true; if no such element exists returns false. 
{
  if (tree == null)
    found = false;
  else if (element.compareTo(tree.getInfo()) < 0)
    tree.setLeft(recRemove(element, tree.getLeft()));
  else if (element.compareTo(tree.getInfo()) > 0)
    tree.setRight(recRemove(element, tree.getRight()));
  else
  {  
    tree = removeNode(tree);
    found = true;
  }
  return tree;
} 

private BSTNode removeNode(BSTNode tree)
// Removes the information at the node referenced by tree
// The user's data in the node referenced to by tree is no
// longer in the tree.  If tree is a leaf node or has only
// a non-null child pointer, the node pointed to by tree is
// removed; otherwise, the user's data is replaced by its
// logical predecessor and the predecessor's node is removed
{
  Comparable data;

  if (tree.getLeft() == null)
    return tree.getRight();
  else if (tree.getRight() == null) 
    return tree.getLeft();
  else
  {
    data = getPredecessor(tree.getLeft());
    tree.setInfo(data);
    tree.setLeft(recRemove(data, tree.getLeft()));  // Remove predecessor node
    return tree;
  }
} 

private Comparable getPredecessor(BSTNode tree)
// Returns the information held in the rightmost node in tree
{
  while (tree.getRight() != null)
    tree = tree.getRight();
  return tree.getInfo();
}

public int reset(int orderType)
// Initializes current position for an iteration through this BST
// in orderType order. Returns current number of nodes in the BST.
{
  int numNodes = size();
  if (orderType == INORDER)
  {
    inOrderQueue = new ArrayBndQueue(numNodes);
    inOrder(root);
  }
  else
  if (orderType == PREORDER)
  {
    preOrderQueue = new ArrayBndQueue(numNodes);
    preOrder(root);
  }
  if (orderType == POSTORDER)
  {
    postOrderQueue = new ArrayBndQueue(numNodes);
    postOrder(root);
  }
  return numNodes;
} 

public Comparable getNext (int orderType)
// Preconditions: the BST is not empty
//                the BST has been reset for orderType
//                the BST has not been modified since the most recent reset
//                the end of orderType iteration has not been reached
// Returns the element at the current position on this BST and advances 
// the value of the current position based on the orderType set by reset. 
{
  if (orderType == INORDER)
    return (Comparable)inOrderQueue.dequeue();
  else
  if (orderType == PREORDER)
    return (Comparable)preOrderQueue.dequeue();
  else
  if (orderType == POSTORDER)
    return (Comparable)postOrderQueue.dequeue();
  else return null;
} 

private void inOrder(BSTNode tree)
// Initializes inOrderQueue with tree elements in inOrder order
{
  if (tree != null)
  {
    inOrder(tree.getLeft());
    inOrderQueue.enqueue(tree.getInfo());
    inOrder(tree.getRight());
  }
}
}
