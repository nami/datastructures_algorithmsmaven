package data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList linkedListTest = new LinkedList();

    @Before
    public void setUp() throws Exception {
        linkedListTest.append("Pikachu");
        linkedListTest.append("Charmander");
        linkedListTest.append("Bulbasaur");
        linkedListTest.append("Squirtle");
        linkedListTest.prepend("Mew");
    }

    @Test
    public void append() {
       linkedListTest.append("Vulpix");
       assertNotNull(linkedListTest.find("Vulpix"));
    }

    @Test
    public void prepend() {
       linkedListTest.prepend("Snorlax");
       assertNotNull(linkedListTest.find("Snorlax"));
    }

   @Test
    public void delete() {
       linkedListTest.delete("Mew");
       assertNull(linkedListTest.find("Mew"));
   }

    @Test
    public void find() {
        assertNotNull(linkedListTest.find("Charmander"));
    }
}