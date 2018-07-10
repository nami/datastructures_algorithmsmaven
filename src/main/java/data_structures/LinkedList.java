package data_structures;

public class LinkedList<T> {

    // need a head
    Node2 head;

    // add something to the end
    public T append(T data){

        // if there's no head
        if(head == null){
            head = new Node2(data);
            return data;
        }

        // point to the head without moving it around
        Node2 current2 = head;

        // if next one is not empty
        while(current2.next != null){
            // move to the next node until current.next is empty
            current2 = current2.next;
        }

        // when current.next is empty put in the new node
        current2.next = new Node2(data);
        return data;
    }

    // add something as the head of the linked list
    public T prepend(T data){

        // if head has nothing
        if(head == null){
            // make a new node
            head = new Node2(data);
            return data;
        }

        // if head is not empty make a new head
        Node2 newHead2 = new Node2(data);

        // have head point to the next node
        newHead2.next = head;

        // new head becomes the new head
        head = newHead2;
        return data;
    }

    // delete data in the linked list
    public void delete(T data){

        // if linked list is empty, just return
        if(head == null){
            return;
        }

        // if data is in the head, delete data in the head
        if(head.data == data){
            head = head.next;
            return;
        }

        // make something to point to the head
        Node2 current2 = head;

        // if data is not null
        while (current2.next != null){
            // when data is found, skip over the data
            if (current2.next.data == data) {
                // if the next.next one is empty
                if (current2.next.next == null ){
                    // make it empty
                    current2.next = null;
                    return;
                }
                current2.next = current2.next.next;
            }
            // else keep moving through the data
            current2 = current2.next;
        }
        return;
    }

    // find the data in the linked list
    public T find(T data){

        // if data is in the head use that data
        if(head.data == data){
            System.out.println(head.data);
            return data;
        }

        // if not, make something point to the head
        Node2 current2 = head;

        // if data is in the linked list print it
        while (current2.next != null){
            if (current2.data == data){
                System.out.println(current2.data);
            }
            // if not keep moving
            current2 = current2.next;
        }
        if (current2.data == data) {
            return data;
        }
        return null;
    }

    public void print(){

        // if the list is empty
        if (head == null){
            return;
        }

        // point to the head
        Node2 current2 = head;

        // use boolean to make sure there is more data
        boolean moreData = true;

        // while there is more data print data
        while (moreData){
            System.out.println(current2.data);
            // if there's nothing then exit
            if(current2.next == null){
                return;
            }
            // if not continue to the next node to print it
            current2 = current2.next;
        }
    }
}

class Node2<T>{
    // data u want to put in
    T data;
    // link to the next node
    Node2 next;

    //constructor for easy reference
    public Node2(T data){
        this.data = data;
    }
}