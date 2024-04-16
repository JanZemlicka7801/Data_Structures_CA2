package data;

import objects.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList list;
    private Appointment appointment1;
    private Appointment appointment2;
    private Appointment appointment3;

    /*
    Sets up instances before each test for easier use
     */
    @BeforeEach
    void setUp() {
        list = new LinkedList();

        LocalDate bd1 = LocalDate.of(1973, 5, 12);
        LocalDate bd2 = LocalDate.of(1989, 2, 17);
        LocalDate bd3 = LocalDate.of(1967, 7, 2);

        LocalDate appointmentDate = LocalDate.of(2024, 4, 22);

        appointment1 = new Appointment("Johnny", "Brooks", bd1, "Broken leg", appointmentDate, 2, "Stella Melton");
        appointment2 = new Appointment("Brock", "Richard", bd2, "Flu", appointmentDate, 4, "Stella Melton");
        appointment3 = new Appointment("Milena", "Graham", bd3, "Covid", appointmentDate, 2, "Norah Cameron");
    }


    /*
    Test of add() method
     */
    @Test
    void testAdd() {
        assertTrue(list.add(appointment1));
        assertTrue(list.add(appointment2));
        assertTrue(list.add(appointment3));
        assertEquals(3, list.size());
    }



    /*
    Test of addToStart() method
     */
    @Test
    void testAddToStart() {
        list.add(appointment2);
        assertTrue(list.addToStart(appointment1));
        assertEquals(2, list.size());
        assertEquals(appointment1, list.get(0));

//        Ensure that method works in empty list.
        list.clear();
        assertTrue(list.addToStart(appointment3));
        assertEquals(1, list.size());
        assertEquals(appointment3, list.get(0));
    }



    /*
    Test of addAtPosition() method
     */
    @Test
    void testAddAtPosition() {
//        Adding to start of the list
        list.add(appointment1);
        assertTrue(list.add(appointment2, 0));
        assertEquals(2, list.size());
        assertEquals(appointment2, list.get(0));


        list.clear();
//        Adding to middle of the list with 2 elements
        list.add(appointment1);
        list.add(appointment3);

        assertTrue(list.add(appointment2, 1));
        assertEquals(3, list.size());
        assertEquals(appointment2, list.get(1));


        list.clear();
//        Adding to middle of the list with 3 elements
        list.add(appointment1);
        list.add(appointment3);
        list.add(appointment3);

        assertTrue(list.add(appointment2, 1));
        assertEquals(4, list.size());
        assertEquals(appointment2, list.get(1));



        list.clear();
//        Adding to end of the list
        list.add(appointment1);
        list.add(appointment2);
        assertTrue(list.add(appointment3, 2));
        assertEquals(3, list.size());
        assertEquals(appointment3, list.get(2));

        //Ensure throws exception if trying to add at invalid index/position
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(appointment3, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(appointment3, -1));
    }


    /*
    Test of remove() method
     */
    @Test
    void testRemove() {
        //Removing from start/head
        list.add(appointment1);
        list.add(appointment2);
        list.add(appointment3);

        Appointment removed1 = list.remove(0);
        assertEquals(2, list.size());
        assertEquals(appointment1, removed1);

        list.clear();
        //Removing from middle
        list.add(appointment1);
        list.add(appointment2);
        list.add(appointment3);

        Appointment removed2 = list.remove(1);
        assertEquals(2, list.size());
        assertEquals(appointment2, removed2);
        assertEquals(appointment1, list.get(0));
        assertEquals(appointment3, list.get(1));

        list.clear();
        //Removing from end/tail
        list.add(appointment1);
        list.add(appointment2);
        list.add(appointment3);

        Appointment removed3 = list.remove(2);
        assertEquals(2, list.size());
        assertEquals(appointment3, removed3);
        assertEquals(appointment1, list.get(0));
        assertEquals(appointment2, list.get(1));

        //Assert throws exception trying to delete an element in wrong index/position
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

//    Test of indexOf() - Index of object in the list
    @Test
    void testIndexOf() {
        list.add(appointment1);
        list.add(appointment2);
        assertEquals(0, list.indexOf(appointment1));
        assertEquals(1, list.indexOf(appointment2));
        assertEquals(-1, list.indexOf(appointment3));
    }


//    Test of get() method
    @Test
    void testGet() {
        list.add(appointment1);
        assertEquals(appointment1, list.get(0));

//     Assert throws IndexOutOfBoundsException trying to retrieve element at invalid index/position
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

//    Test of tail() method - returns data of last element(tail) in the list
    @Test
    void testTail() {
        list.add(appointment1);
        assertEquals(appointment1, list.tail());

//     Assert throws IndexOutOfBoundsException calling method on empty list
        list.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> list.tail());
    }


//    Test of size() method
    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add(appointment1);
        assertEquals(1, list.size());

        list.clear();
        assertEquals(0, list.size());
    }

//    Test of isEmpty() method
    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(appointment1);
        assertFalse(list.isEmpty());
    }

//    Test of clear() method
    @Test
    void testClear() {
        list.add(appointment1);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}