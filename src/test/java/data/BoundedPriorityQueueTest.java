package data;

import objects.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BoundedPriorityQueueTest {
    private BoundedPriorityQueue queue;
    private Appointment appointment1;
    private Appointment appointment2;
    private Appointment appointment3;
    private Appointment appointment4;

    /*
    Sets up instances before each test for easier use
     */
    @BeforeEach
    void setUp() {
        queue = new BoundedPriorityQueue(3, "Stella Melton");
        LocalDate bd1 = LocalDate.of(1973, 5, 12);
        LocalDate bd2 = LocalDate.of(1989, 2, 17);
        LocalDate bd3 = LocalDate.of(1967, 7, 2);
        LocalDate bd4 = LocalDate.of(1981, 11, 27);

        LocalDate appointmentDate = LocalDate.of(2024, 4, 22);

        appointment1 = new Appointment("Johnny", "Brooks", bd1, "Broken leg", appointmentDate, 2, "Stella Melton");
        appointment2 = new Appointment("Brock", "Richard", bd2, "Flu", appointmentDate, 4, "Stella Melton");
        appointment3 = new Appointment("Milena", "Graham", bd3, "Covid", appointmentDate, 2, "Norah Cameron");
        appointment4 = new Appointment("Melany", "Black", bd4, "Covid", appointmentDate, 2, "Stella Melton");
    }

    /*
    Test of isFull() method
     */
    @Test
    void testIsFull() {
        assertFalse(queue.isFull());
        queue.add(appointment1);
        queue.add(appointment2);
        queue.add(appointment1);
        assertTrue(queue.isFull());
    }

    /*
   Test of count() method
    */
    @Test
    void testCount() {
        assertEquals(0, queue.count());
        queue.add(appointment1);
        queue.offer(appointment2);
        assertEquals(2, queue.count());

        queue.poll();
        assertEquals(1, queue.count());
        queue.remove();
        assertEquals(0, queue.count());
    }

    /*
    Test of peek() method - get the first element without deleting
     */
    @Test
    void testPeek() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
        queue.add(appointment1);
        assertEquals(appointment1, queue.peek());
    }

    /*
     Test of offer() method - safe add
     */
    @Test
    void testOffer() {
        assertTrue(queue.offer(appointment1));
        assertTrue(queue.offer(appointment2));
        assertFalse(queue.offer(appointment3));

        assertTrue(queue.offer(appointment4));

        assertEquals(3, queue.count());
        assertTrue(queue.isFull());

        assertFalse(queue.offer(appointment4));


    }

    /*
     Test of add() method
     */
    @Test
    void testAdd() {
        assertTrue(queue.add(appointment1));
        assertTrue(queue.add(appointment2));
        assertTrue(queue.add(appointment4));

        assertThrows(NullPointerException.class, () -> queue.add(null));
        assertThrows(IllegalStateException.class, () -> queue.add(appointment1));
        assertThrows(IllegalArgumentException.class, () -> queue.add(appointment3));
    }

    /*
    Test of poll() method - safe delete
     */
    @Test
    void testPoll() {
        assertNull(queue.poll());

        queue.add(appointment1);
        queue.add(appointment2);

        assertEquals(appointment1, queue.poll());
        assertEquals(appointment2, queue.poll());
    }

    /*
     Test of remove() method
     */
    @Test
    void testRemove() {
        queue.add(appointment1);
        assertEquals(appointment1, queue.remove());

        assertThrows(IndexOutOfBoundsException.class, () -> queue.remove());
    }
}