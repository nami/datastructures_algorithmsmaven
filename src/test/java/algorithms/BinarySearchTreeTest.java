package algorithms;

import algorithms.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree bst = new BinarySearchTree();

    @Test
    public void addRecursive() {
        bst.add(40);
        bst.add(50);
        bst.add(60);
    }

    @Test
    public void containsRecursive() {
        bst.add(5);
        bst.add(1);
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(1));

        assertFalse(bst.contains(100));
    }

    @Test
    public void deleteRecursive() {
        bst.add(1);
        bst.add(3);
        bst.add(2);
        bst.delete(3);
        bst.delete(2);
        assertFalse(bst.contains(3));
        assertFalse(bst.contains(2));
    }
}