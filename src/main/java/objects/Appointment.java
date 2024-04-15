package objects;

import java.time.*;
import java.util.Objects;

public class Appointment {
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
        this.pFname = pFname;
        this.pLname = pLname;
        this.pDateOfBirth = pDateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triage = triage;
        this.docName = docName;
    }
}
