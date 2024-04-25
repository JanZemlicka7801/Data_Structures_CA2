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
}