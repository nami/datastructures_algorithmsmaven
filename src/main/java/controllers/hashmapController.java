package controllers;

import data_structures.HashMapChallenge;

public class hashmapController {

    public static void main(String[] args){

        HashMapChallenge hashmap = new HashMapChallenge();

        hashmap.add("はな", 1);
        hashmap.add("banana", 2);
        hashmap.add("むずい", 3);
        hashmap.add("haha", 4);
        hashmap.add("my", 5);
        hashmap.add("cheese", 6);

        System.out.println("-------------------");

        System.out.println(hashmap.find("cheese"));

        System.out.println("-------------------");

        System.out.println(hashmap.find("はな"));

        System.out.println("-------------------");

        hashmap.remove("banana");

        System.out.println(hashmap.find("banana"));

        hashmap.list();

    }
}
