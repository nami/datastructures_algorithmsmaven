package controllers;

import data_structures.LinkedList;

public class linkedlistController {

    public static void main(String[] args) {

    LinkedList list = new LinkedList();

        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        list.print();

        System.out.println("------------------");

        list.prepend(1);
        list.print();

        System.out.println("------------------");

        list.find(1);

        System.out.println("-------------------");

        list.delete(1);
        list.print();
    }
}
