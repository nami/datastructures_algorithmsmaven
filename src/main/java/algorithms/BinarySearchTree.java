package algorithms;

public class BinarySearchTree<T extends Comparable> {
    // the root of the binary
    Node<T> root;

    public Node addRecursive(Node current, T value) {

        // if there's nothing inside, return a new node
        if (current == null) {
            return new Node(value);
        }

        // compare value to root,
        int compareValue = value.compareTo(current.getValue());
        // if value is lesser than root (-1), add to the left
        if (compareValue < 0) {
            current.left = addRecursive(current.left, value);
        // if value is more than root (1), add to the right
        } else if (compareValue > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    // this method calls the addRecursive method
    public void add(T value) {
        root = addRecursive(root, value);
    }

    // use boolean to check if the binary tree has a specific node
    public boolean containsRecursive(Node current, T value) {
        // if there's nothing, tree is empty
        if (current == null) {
            return false;
        }

        // if value is in root, return true
        if (value == current.value){
            return true;
        }

        // if value is in the root, return true
        int compareValue = value.compareTo(current.getValue());
        // if value is lesser than root, search left
        if (compareValue < 0)
            return containsRecursive(current.left, value);

        // if value is more that root, search right
        return containsRecursive(current.right, value);
    }

    // this method calls the containsRecursive
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }


    // delete a node from the tree
    public Node deleteRecursive(Node current, T value) {

        // if tree is empty, the just return
        if (current == null) {
            return current;
        }

        // otherwise recur down the tree
        int compareValue = value.compareTo(current.getValue());
        // if value is less than root, go left
        if(compareValue < 0)
            current.left = deleteRecursive(current.left, value);
        // if value is more than root, go right
        else if (compareValue > 0)
            current.right = deleteRecursive(current.right, value);

        else {
            // if node with no child
            if (current.left == null && current.right == null)
                return null;
            // node with one child on the right
            else if (current.left == null)
                return current.right;
            // node with one child on the left
            else if (current.right == null)
                return current.left;

            // node with two children
            else {
                // if deleting a node with two children the left, replace with the maxValue
                if (compareValue < 0){
                    T maxValue = maxValue(current.getLeft());
                    current.setValue(maxValue);
                    current.setRight(deleteRecursive(current.getRight(), maxValue));
                    // if deleting root node/ or a node with two children the right, replace with the minValue
                } else {
                    T minValue = minValue(current.getRight());
                    current.setValue(minValue);
                    current.setLeft(deleteRecursive(current.getLeft(), minValue));
                }
            }
        }
        return current;
    }

    // method to get the smallest value from the left side of the tree
    public T minValue(Node current){
        T minv = (T) current.value;
        while (current.left != null){
            minv = (T)current.left.value;
            current = current.left;
        }
        return minv;
    }

    // method to get the biggest value from the right side of the treee
    public T maxValue(Node current){
        T maxv = (T) current.value;
        while (current.right != null){
            maxv = (T)current.right.value;
            current = current.right;
        }
        return maxv;
    }

    // method to call deleteRecursive
    public void delete(T value){
        deleteRecursive(root, value);
    }


    // print tree in order - left, root, right
    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(" " + node.value);
            printInOrder(node.right);
        }
    }

    // call the printInOrder method
    public void inOrder() {
        printInOrder(root);
    }

    // print pre-order - root, left, right
    public void printPreOrder(Node node) {
        if (node != null) {
            System.out.println(" " + node.value);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    // method to call printPreOrder
    public void preOrder() {
        printPreOrder(root);
    }

    // print post-order - left, right, root
    public void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(" " + node.value);
        }
    }

    // method to call printPostOrder
    public void postOrder() {
        printPostOrder(root);
    }

}

// nodes to add to the BST
class Node<T extends Comparable> {
    T value;
    //directions the nodes needs to move through
    //left is always if the value is lesser than current node
    //right if is value is greater than current node
    Node left, right;

    // node contains
    Node(T value) {
        this.value = value;
        left = right = null;
    }

    // getters & setters
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}