package data;

import objects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTests {
    private HashMap hashMap;
    private LinkedList appointmentList1;
    private LinkedList appointmentList2;

    private Patient patient1;
    private Patient patient2;

    @BeforeEach
    public void setUp() {
//        Patient 1
        appointmentList1 = new LinkedList();
        appointmentList1.add(new Appointment("Dmytro", "Drahan", LocalDate.of(2004, 3, 28), "Broken bone", LocalDate.of(2024, 6, 12), 2, "Stella Melton"));

        patient1 = new Patient("Dmytro", "Drahan",
                LocalDate.of(1973, 5, 12),
                LocalDate.of(2024, 4, 9),
                appointmentList1
        );

//        Patient 2
        appointmentList2 = new LinkedList();
        appointmentList2.add(new Appointment("Jo", "Whatever", LocalDate.of(1987, 5, 12), "Covid", LocalDate.of(2024, 6, 14), 3, "Stella Melton"));

        patient2 = new Patient("Jo", "Whatever",
                LocalDate.of(1973, 5, 12),
                LocalDate.of(2024, 4, 12),
                appointmentList2
        );

        hashMap = new HashMap();
    }

    @Test
    public void testPut() {
        assertNull(hashMap.put("+3538052014440", patient1));
        assertEquals(patient1, hashMap.put("+3538052014440", patient2));
    }

    @Test
    public void testGet() {
        hashMap.put("+3538052014440", patient1);
        assertEquals(patient1, hashMap.get("+3538052014440"));
        assertNull(hashMap.get("Wrong key"));
    }

    @Test
    public void testRemove() {
        hashMap.put("+3538052014440", patient1);
        assertEquals(patient1, hashMap.remove("+3538052014440"));
        assertNull(hashMap.remove("+3538052014440"));
    }

    @Test
    public void testContainsKey() {
        hashMap.put("+3538052014440", patient1);
        assertTrue(hashMap.containsKey("+3538052014440"));
        assertFalse(hashMap.containsKey("Wrong key"));
    }

    @Test
    public void testSize() {
        assertEquals(0, hashMap.size());

        hashMap.put("key1", patient1);
        assertEquals(1, hashMap.size());

        hashMap.put("key1", patient2);
        assertEquals(1, hashMap.size());

        hashMap.remove("key1");
        assertEquals(0, hashMap.size());
    }

    @Test
    public void testGetKeys() {
        hashMap.put("key1", patient1);
        hashMap.put("key2", patient2);
        String[] keys = hashMap.getKeys();
        assertEquals(2, keys.length);

        assertTrue(Arrays.asList(keys).contains("key1"));
        assertTrue(Arrays.asList(keys).contains("key2"));
    }

    @Test
    public void testGetValues() {
        hashMap.put("key1", patient1);
        hashMap.put("key2", patient2);

        Patient[] values = hashMap.getValues();

        assertEquals(2, values.length);
        assertTrue(Arrays.asList(values).contains(patient1));
        assertTrue(Arrays.asList(values).contains(patient2));
    }
}