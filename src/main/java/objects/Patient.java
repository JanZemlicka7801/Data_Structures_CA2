package objects;

import java.time.*;
import java.util.Objects;
import data.*;

public class Patient {
    private String fName;
    private String lName;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;
    private LinkedList appointmentLinkedList;

    /**
     * Parametrized constructor for patient object.
     *
     * @param fName The patient's first name.
     * @param lName The patient's last name.
     * @param dateOfBirth The patient's date of birth.
     * @param joinDate The date of a signing in.
     * @param appointmentLinkedList A linked list of appointments of a patient.
     */
    public Patient(String fName, String lName, LocalDate dateOfBirth, LocalDate joinDate, LinkedList appointmentLinkedList) {
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
        this.appointmentLinkedList = new LinkedList();
    }
}
