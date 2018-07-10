package controllers;

import algorithms.BinarySearchTree;

public class bstController {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.add(3);
        bst.add(1);
        bst.add(2);
        bst.add(6);
        bst.add(7);
        bst.add(8);

        System.out.println("Printing In-order:");
        bst.inOrder();
        System.out.println();

        System.out.println("Printing Pre-Order:");
        bst.preOrder();
        System.out.println();

        System.out.println("Printing Post-Order");
        bst.postOrder();
        System.out.println();

        bst.delete(3);
        bst.inOrder();

    }
}
