package ui;

import data.*;
import objects.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static BoundedPriorityQueue[] doctorQueues;
    private static HashMap patients;


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        setUp();
        System.out.println("You are set up!");

        int choice;
        boolean done = false;



        while (!done) {
            printMenu();

            try {
                System.out.println();
                System.out.println("Please enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e){
                System.out.println("Please enter a correct choice");
                continue;
            }

            switch (choice){
                case 1:
                    addPatient();
                    break;

                case 2:
                    deletePatient();
                    break;

                case 3:
                    displayAllPlatients();
                    break;

                case 4:
                    createAppointment();
                    break;

                case 5:
                    callNextPatient();
                    break;

                 case 0:
                     System.out.println("Exit...");
                     done = true;

                default:
                    System.out.println("Invalid choice. Please enter a number 1-5 or 0 to exit");
            }
        }


    }

    public static void setUp(){
        int maxSize = setUpperBound();
        doctorQueues = new BoundedPriorityQueue[maxSize];

        String[] doctors = addDoctors();
        int index = 0;

        for(String doctor : doctors){
            BoundedPriorityQueue q = new BoundedPriorityQueue(maxSize, doctor);
            doctorQueues[index] = q;
            index++;
        }

//        Initialize hashMap
        patients = new HashMap();

    }

    public static int setUpperBound(){
        Scanner sc = new Scanner(System.in);
        boolean complete = false;
        int maxSize = 5; // default value

        while(!complete){
            try {
                System.out.println("Please enter the max size of the queues: ");
                maxSize = Integer.parseInt(sc.nextLine());

                if(maxSize <= 0){
                    System.out.println("Size must be greater than 0.");
                    continue;
                }
                complete = true;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return maxSize;
    }

    public static String[] addDoctors(){
        Scanner sc = new Scanner(System.in);

        String [] doctors = null; //Initialize to prevent compiling error
        boolean complete = false;
        int arraySize; // default value

        while(!complete){
            try {
                System.out.println("Please enter count of doctors: ");
                arraySize = Integer.parseInt(sc.nextLine());
                if(arraySize <= 0){
                    System.out.println("Size must be greater than 0.");
                    continue;
                }
                doctors = new String[arraySize];

                for (int i = 0; i < arraySize; i++) {
                    System.out.println("Please enter the doctor name: ");
                    String name = sc.nextLine();
                    doctors[i] = name;
                }
                complete = true;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return doctors;
    }

    private static void printMenu(){
        System.out.println();

        System.out.println("Add a new patient - 1");
//      1  • Add a new patient to the practice (where there is already a patient with that first name, last name and date of birth, the
//           user should be informed and the patient should not be added).

        System.out.println("Delete a patient - 2");
//      2  • Delete a patient from the practice (you should handle any outstanding appointments appropriately – this may require
//          adding an extra method to your queue outside the standard functionality)

        System.out.println("Display all patients - 3");
//      3  • Display all patients

        System.out.println("Create a new appointment for a patient - 4");
//      4  • Create a new appointment for a specific patient and add it to the queue (the appointment should be allocated a
//          random triage level between 1 and 5)

        System.out.println("Call the next patient for a specified doctor - 5");
//      5  • Call the next patient in for a specified doctor (this should pull the next appointment from that doctor’s queue and
//          display its details to the user).

        System.out.println("Exit - 0");
//      0  • Exit
    }


    public static void addPatient(){

        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done){
            try {
                System.out.println("Please enter the first name of the patient: ");
                String fName = sc.nextLine();

                System.out.println("Please enter the last name of the patient: ");
                String lName = sc.nextLine();

                LocalDate date;
                System.out.println("Please enter a date of birth in the format YYYY-MM-DD:");
                String bd = sc.nextLine();
                date = LocalDate.parse(bd);

                LocalDate joinDate = LocalDate.now();
                LinkedList appointmentList = new LinkedList();
                Patient patient = new Patient(fName, lName, date, joinDate, appointmentList);

                System.out.println("Enter a key to associate with patient: ");
                String key = sc.nextLine();

                if(patients.put(key, patient) != null){
                    System.out.println("Your Patient already exists! (was replaced)");
                } else {
                    System.out.println("Successfully added new patient");
                }
                done = true;
            } catch (DateTimeParseException | NullPointerException e){
                if(e instanceof DateTimeException){
                    System.out.println("Please enter a correct date in format YYYY-MM-DD");
                }
                e.getMessage();
            }
        }
    }


    public static void deletePatient(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a key associated with a patient to be removed");
        String key = sc.nextLine();

        Patient removed = patients.remove(key);
        if (removed == null){
            System.out.println("no Patient was found!");
        } else {
            System.out.println("Successfully deleted patient " + removed);
        }
    }

    public static void displayAllPlatients(){
        Patient[] retrievedPatients;
        retrievedPatients = patients.getValues();

        System.out.println();
        if (retrievedPatients == null){
            System.out.println("No patients yet!");
            return;
        }
        for (Patient patient : retrievedPatients){
            System.out.println(patient);
        }
    }

    public static void createAppointment(){

//      4  • Create a new appointment for a specific patient and add it to the queue
//      (the appointment should be allocated a random triage level between 1 and 5)
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done){
            try {
                System.out.println();
                System.out.println("Please enter patient's first name: ");
                String fName = sc.nextLine();

                System.out.println("Please enter patient's last name: ");
                String lName = sc.nextLine();

                System.out.println("Please enter a date of birth in the format YYYY-MM-DD:");
                String bd = sc.nextLine();
                LocalDate pDateOfBirth = LocalDate.parse(bd);

                System.out.println("Please enter patient's issue: ");
                String issue = sc.nextLine();

                Random rand = new Random();
                int triAge = rand.nextInt(5) + 1;

                System.out.println("Please enter a doctor name: ");
                String docName = sc.nextLine();

                Appointment appointment = new Appointment(fName, lName, pDateOfBirth, issue, LocalDate.now(), triAge,  docName);

                for (BoundedPriorityQueue queue : doctorQueues){
                    if (queue.isValidAppointment(appointment)){
                        queue.add(appointment);
                        System.out.println("Appointment created!");
                        return;
                    }
                }
                done = true;
                System.out.println("No doctors were found in doctor queues");

            } catch (DateTimeParseException e) {
                System.out.println("Please enter a correct date in format YYYY-MM-DD");
            }
        }


    }


    public static void callNextPatient(){
//      5  • Call the next patient in for a specified doctor (this should pull the next appointment
//             from that doctor’s queue and display its details to the user).
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Please enter a doctor name to call the patient(from that doctor's queue)");
        String docName = sc.nextLine();
        Appointment appointment = null;

        for (BoundedPriorityQueue queue : doctorQueues){
            if (queue.getDoctorName().equals(docName)){
                appointment = queue.poll();
            }
        }

        if (appointment == null){
            System.out.println("No patient was found!");
        } else {
            System.out.println("The next appointment is " + appointment);
        }
    }


}
