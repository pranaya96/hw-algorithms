package lab5;

public class BinarySearchTree {

    private class Node {
	// The value stored in this tree node.
	private int value;

	// The left child of this node. Can be null if there is none.
	private Node leftChild;

	// The right child of this node. Can be null if there is none.
	private Node rightChild;

	// Create a node with given value and no children.
	private Node(int value) {
	    this.value = value;
	    this.leftChild = null;
	    this.rightChild = null;
	}

	private int getValue() {
	    return this.value;
	}

	private void setValue(int value) {
	    this.value = value;
	}

	private Node getLeftChild() {
	    return this.leftChild;
	}

	private Node getRightChild() {
	    return this.rightChild;
	}

	private void setLeftChild(Node child) {
	    this.leftChild = child;
	}

	private void setRightChild(Node child) {
	    this.rightChild = child;
	}

	private void insertNode(Node node) {
	    if (node.value < this.value) {
		// Node value is less than this, so insert
		// the node in the left subtree.
		if (this.leftChild == null) {
		    // No left child, so make node left child.
		    this.leftChild = node;
		} else {
		    // Recurse into left subtree.
		    this.leftChild.insertNode(node);
		}
	    } else if (node.value > this.value) {
		// Node value is greater than this, so insert
		// the node in the right subtree.
		if (this.rightChild == null) {
		    // No right child, so make node right child.
		    this.rightChild = node;
		} else {
		    // Recurse into right subtree.
		    this.rightChild.insertNode(node);
		}
	    }
	}
    }

    private Node root;

    // Constructor for an empty tree.
    public BinarySearchTree() {
	this.root = null;
    }

    // Inserts the given value in this tree.
    // Inserting a value more than once is treated as a no-op.
    public void insert(int value) {
	Node newNode = new Node(value);
	if (this.root == null) {
	    // BinarySearchTree empty, so set the new node as root node.
	    this.root = newNode;
	} else {
	    this.root.insertNode(newNode);
	}
    }

    // Checks if this BinarySearchTree contains the given value.
    // Returns true iff the value is present in this BinarySearchTree.
    public boolean find(int value) {

	// TODO: You should implement find() here.
	// Note that you will likely want to implement a helper
	// method in the Node class above.

	return false;
    }

    // Returns the number of entries in this BinarySearchTree that are
    // less than value.
    public int numLessThan(int value) {

	// TODO: You should implement numLessThan() here.
	// Note that you will likely want to implement a helper
	// method in the Node class above.

	return 0;
    }
}