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

    /**
     * Compares a patient to the specific object. The result is true if the
     * argument is a objects.Patient object with the same values.
     *
     * @param o Object of instance objects.Patient which will be compared to a different objects.Patient.
     * @return True if two objects are the same or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(getfName(), patient.getfName()) && Objects.equals(getlName(), patient.getlName()) && Objects.equals(getDateOfBirth(), patient.getDateOfBirth());
    }

    /**
     * Calculates a hash code based on all provided information of the patient.
     *
     * @return The hash code for the patient.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getfName(), getlName(), getDateOfBirth());
    }

    /**
     * Convert inserted values for patient into a well-formatted text.
     *
     * @return Well-formatted text.
     */
    @Override
    public String toString() {
        return "objects.Patient{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", joinDate=" + joinDate +
                ", appointmentLinkedList=" + appointmentLinkedList +
                '}';
    }
}
