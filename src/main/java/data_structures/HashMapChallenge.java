package data_structures;


public class HashMapChallenge<K, V> {

    // initial size & pair into the table
    private int INITIAL_SIZE = 5;
    private Pair<K, V>[] table;
    // counter to check how many items are in
    private int counter;

    // pass in the initial size into a table
    public HashMapChallenge() {
        table = new Pair[INITIAL_SIZE];
    }

    // add method for hash map
    public void add(K key, V value) {
        // get the hash/index for the key
        int hash = Hash(key);

        // put it in if it's empty
        if (table[hash] == null) {
            table[hash] = new Pair(key, value);
            // counter increases when pair is put in
            counter++;

            // resize if it's too big
            if (counter > table.length * .5) {
                resize();
            }
            return;
        }


        // make so you can get the .next and go through the list
        Pair<K, V> p = table[hash];

        // put it in the linked list if its not empty?????
        while (p.next != null) {
            // keep moving
            p = p.next;
        }

        // add new pair when it reaches the end
        p.next = new Pair(key, value);
        // counter increases when new pair is put in
        counter++;

        // resize if it's too big
        if (counter > table.length * .5) {
            resize();
        }

    }

    // resize table method
    private void resize() {
        // place all the existing values into table
        Pair<K, V>[] old = table;
        // increase table size by 2
        table = new Pair[old.length * 2];
        counter = 0;

        // add the K, V in the hashMap
        for (Pair<K, V> pair : old) {
            // if there is a null value don't add it in
            if (pair != null) {
                // add key and values
                add(pair.getKey(), pair.getValue());
                // add the linked list in the array if there is a linked list
                while (pair.next != null) {
                    // move through the linked list
                    pair = pair.next;
                    // add the key & values in the linked list
                    add(pair.getKey(), pair.getValue());
                }
            }
        }

    }

    // remove value from HashMap
    public void remove(K key) {

        // get hash for key
        int hash = Hash(key);

        // if the key is not there just return
        if (find(key) == null) {
            System.out.println("Key not found. To be removed.");
            return;
        }

        // if the first index is the key
        if (table[hash].getKey() == key) {
            // make the second item in the linked list the first index
            table[hash] = table[hash].next;
            // decrease counter
            counter--;
            // if the table is empty
            if (table[hash] == null) {
                // tell user item is removed from hashmap
                System.out.println("Item removed: " + key);
                // exit this method
                return;
            }
        }

        // if there is a linked list
        while (table[hash].next != null) {
            // and the next value in the linked list is the key
            if (table[hash].next.getKey() == key) {
                // remove the value by connecting the previous value to the next next value
                table[hash].next = table[hash].next.next;
                // tell user the value was removed from list
                System.out.println("Item removed from list: " + key);
                // decrease counter
                counter--;
                // exit this methof
                return;
            }
        }
    }

    // find value in HashMap
    public V find(K key) {

        // get hash for key
        int hash = Hash(key);

        // make sure there are values in the table
        if (table[hash] == null) {
            return null;
        }

        // make it so you can get the .next
        Pair<K, V> p = table[hash];

        // if there are values & it is not the key
        while (p.next != null && p.getKey() != key) {
            // keep moving
            p = p.next;
        }

        // if it is the correct key
        if (p.getKey() == key) {
            System.out.println("Item found: " + key);
            // get value
            return p.getValue();
        }
        // if not, return null
        return null;
    }

    // list all the values in the HashMap
    public void list() {

        // place all the existing values of table into print
        Pair<K, V>[] print = table;

        // for-each loop printing out the Key, Values in HashMap
        for (Pair<K, V> hashmap : print) {
            // try-catch to prevent null pointer exception for the null values
            try {
                // print out the toString of the key & values in HashMap
                System.out.println(hashmap.toString());
                // if there is a linked list in a HashMap
                while (hashmap.next != null){
                    // go to the linked list
                    hashmap = hashmap.next;
                    // print out the linked list
                    System.out.println(hashmap.toString());
                }
            }
            catch (Exception e){
                // exit out once exception is caught
                continue;
            }
        }
    }

    // find the hash value
    public int Hash(K key) {
        // put the hashCode in the x
        int x = key.hashCode();
        // make sure it's an absolute value
        x = Math.abs(x);
        // mod it by the table length
        x = x % table.length;
        // return
        return x;
    }

}

// keys & values
class Pair<K, V> {

    // variables for the pair
    private K key;
    private V value;
    // make sure there's a next???
    Pair next = null;

    // constructor for the pair
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // getters & setters
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    // print a toString listing key & value
    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}