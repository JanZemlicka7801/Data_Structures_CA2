package data;

import objects.Appointment;

public class BoundedPriorityQueue extends LinkedList {
    private final int max;
    private final String doctorName;

    public BoundedPriorityQueue(int max, String doctorName) {
        this.max = max;
        this.doctorName = doctorName;
    }

    /**
     * Gets a doctor's name of the queue.
     * @return doctor namw.
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Checks if the queue is full. Checks if the queue has reached the maximum size of a set(maximum size is initialized in constructor).
     *
     * @return boolean indicating if a queue is full.
     */
    public boolean isFull() {
        return super.size() == max;
    }

    /**
     * Gets the size of a queue.
     *
     * @return size(number) of a queue.
     */
    public int count() {
        return super.size();
    }

    /**
     * Deletes and returns the first Appointment in a queue.
     *
     * @return deleted Appointment.
     */
    public Appointment poll() {
        if (isEmpty()) {
            return null;
        }
        return super.remove(0);
    }

    /**
     * Safe version of peek() method. Returns first element in a queue without deleting it OR null if a queue is empty.
     *
     * @return first Appointment object in a queue, if it's not empty.
     */
    public Appointment element() {
        if (isEmpty()) {
            return null;
        }
        return super.get(0);
    }

    /**
     * "Get" method: returns first element in a queue without deleting it.
     *
     * @return first Appointment object in a queue, if it's not empty.
     */
    public Appointment peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        } else {
            return super.get(0);
        }
    }

    /**
     * Adds a Appointment in a queue based on priority.
     *
     * @param toAdd Appointment to be added.
     * @return boolean indicating success of action.
     */
    public boolean add(Appointment toAdd) {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add a null Appointment");
        } else if (!isValidAppointment(toAdd)) {
            throw new IllegalArgumentException("Appointment to be added is for different doctor: " + toAdd.getDocName() + ". Doctor for the queue: " + doctorName);
        } else if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }

        if (isEmpty()) {
            super.add(toAdd);
            return true;
        }

        Node current = head;
        int pos = 0;

        while (current != null && current.getData().compareTo(toAdd) > 0) {
            current = current.getNext();
            pos++;
        }

        super.set(toAdd, pos);
        return true;
    }

    /**
     * Removes and returns a first Appointment in the queue.
     * @return removed Appointment.
     */
    public Appointment remove(){
        return super.remove(0);
    }

    /**
     * Safe version of add() method. Tries to add Appointment in a queue.
     * @param toAdd Appointment to be added.
     * @return false if a queue is empty or Appointment to be added contains invalid doctor's name, true otherwise
     */
    public boolean offer(Appointment toAdd){
        if (isFull() || !isValidAppointment(toAdd)){
            return false;
        }
        return add(toAdd);
    }

    /**
     * Helper method to check if doctor of the appointment to be added is the same as the doctor of the queue.
     *
     * @param appointment Appointment to be added.
     * @return boolean indicating success of validation.
     */
    public boolean isValidAppointment(Appointment appointment) {
        return appointment.getDocName().equalsIgnoreCase(doctorName);
    }
}