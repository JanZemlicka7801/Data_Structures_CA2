package objects;

import java.time.*;
import java.util.Objects;

public class Appointment implements Comparable<Appointment>{
    private String pFname;
    private String pLname;
    private LocalDate pDateOfBirth;
    private String issue;
    private LocalDate date;
    private int triage;
    private String docName;

    /**
     * To create an appointment all information needs to be input.
     *
     * @param pFname objects.Patient's first name.
     * @param pLname objects.Patient's last name.
     * @param pDateOfBirth objects.Patient's date of birth.
     * @param issue Reason why patient needs to come.
     * @param date Date of an appointment.
     * @param triage The triage level.
     * @param docName Name of a doctor.
     */

    public Appointment(String pFname, String pLname, LocalDate pDateOfBirth, String issue, LocalDate date, int triage, String docName) {
        validateDate(date);
        this.pFname = pFname;
        this.pLname = pLname;
        this.pDateOfBirth = pDateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triage = triage;
        this.docName = docName;
    }

    /**
     * Method for validating a date and avoid duplicating.
     *
     * @param date The date to be validated.
     */
    private void validateDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Deadline must be a future date.");
        }
    }

    /**
     * Retrieves patient's first name.
     *
     * @return The first name of patient.
     */
    public String getpFname() {
        return pFname;
    }

    /**
     * Sets patient's first name.
     *
     * @param pFname Name to set patient's first name to.
     */
    public void setpFname(String pFname) {
        this.pFname = pFname;
    }

    /**
     * Retrieves patient's last name.
     *
     * @return The last name of a patient.
     */
    public String getpLname() {
        return pLname;
    }

    /**
     * Sets patient's last name.
     *
     * @param pLname Last name to be set.
     */
    public void setpLname(String pLname) {
        this.pLname = pLname;
    }

    /**
     * Retrieves patient's date of birth.
     *
     * @return objects.Patient's date of birth.
     */
    public LocalDate getpDateOfBirth() {
        return pDateOfBirth;
    }

    /**
     * Sets date of patient's birth.
     *
     * @param pDateOfBirth Date to be set.
     */
    public void setpDateOfBirth(LocalDate pDateOfBirth) {
        this.pDateOfBirth = pDateOfBirth;
    }

    /**
     * Retrieves a problem that patient is coming to a doctor with.
     *
     * @return An issue of patient.
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Sets an issue of patient.
     *
     * @param issue Issue of patient.
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * Retrieves a date of an appointment.
     *
     * @return A date of an appointment.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets a date of an appointment.
     *
     * @param date Date to be set.
     */
    public void setDate(LocalDate date) {
        validateDate(date);
        this.date = date;
    }

    /**
     * Retrieves triage of an appointment.
     *
     * @return Returns a triage.
     */
    public int getTriage() {
        return triage;
    }

    /**
     * Sets a value for triage of an appointment.
     *
     * @param triage The triage to be set.
     */

    public void setTriage(int triage) {
        this.triage = triage;
    }

    /**
     * Retrieves the name of a doctor.
     *
     * @return The name of a doctor.
     */
    public String getDocName() {
        return docName;
    }

    /**
     * Sets the doctor's name.
     *
     * @param docName The name of a doctor to be set.
     */
    public void setDocName(String docName) {
        this.docName = docName;
    }

    /**
     * Compares an appointment to the specific object. The result is true if the
     * argument is an objects.Appointment object with the same values.
     *
     * @param o Object of instance objects.Appointment which will be compared to a different objects.Appointment.
     * @return True if two objects are the same or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment that)) return false;
        return getTriage() == that.getTriage() && Objects.equals(getpFname(), that.getpFname()) && Objects.equals(getpLname(), that.getpLname()) && Objects.equals(getpDateOfBirth(), that.getpDateOfBirth()) && Objects.equals(getIssue(), that.getIssue()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getDocName(), that.getDocName());
    }

    /**
     * Calculates a hash code based on all provided information of the appointment.
     *
     * @return The hash code for the appointment.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getpFname(), getpLname(), getpDateOfBirth(), getIssue(), getDate(), getTriage(), getDocName());
    }

    /**
     * Convert value from entities to well-formatted text.
     *
     * @return Well-formatted text of values.
     */
    @Override
    public String toString() {
        return "objects.Appointment{" +
                "pFname='" + pFname + '\'' +
                ", pLname='" + pLname + '\'' +
                ", pDateOfBirth=" + pDateOfBirth +
                ", issue='" + issue + '\'' +
                ", date=" + date +
                ", triage=" + triage +
                ", docName='" + docName + '\'' +
                '}';
    }

    /**
     * Compares two appointments if they are not same based on triage, on date otherwise if they have same values for triage.
     *
     * @param another The object to be compared.
     * @return
     */
    @Override
    public int compareTo(Appointment another){
        if (this.getTriage() != another.getTriage()){
            return Integer.compare(another.getTriage(), this.getTriage());
        } else {
            return  this.getDate().compareTo(another.getDate());
        }
    }
}
