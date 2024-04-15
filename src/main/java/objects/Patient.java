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

    /**
     * Retrieves patient's first name.
     *
     * @return First name of a patient.
     */
    public String getfName() {
        return fName;
    }

    /**
     * Sets patient's first name.
     *
     * @param fName The name to be set.
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Retrieves a last name of a patient.
     *
     * @return The last name of a patient.
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets a value for a patient's last name.
     *
     * @param lName Last name to be set.
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Retrieves the date of birth.
     *
     * @return The date of birth.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of a birth.
     *
     * @param dateOfBirth The date to be set.
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves a date when patient signed in.
     *
     * @return The date of join.
     */
    public LocalDate getJoinDate() {
        return joinDate;
    }

    /**
     * Sets a date of joining in.
     *
     * @param joinDate The date to be set.
     */
    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * Retrieves a list of appointments.
     *
     * @return The list of appointments.
     */
    public LinkedList getAppointmentLinkedList() {
        return appointmentLinkedList;
    }

    /**
     * Sets a list of appointments of a patient.
     *
     * @param appointmentLinkedList data.LinkedList of app
     */
    public void setAppointmentLinkedList(LinkedList appointmentLinkedList) {
        this.appointmentLinkedList = appointmentLinkedList;
    }

}
