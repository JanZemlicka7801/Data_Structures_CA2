package data;

import objects.Appointment;

public class BoundedPriorityQueue extends LinkedList {

    //means that we need to set a queue that will have specific length and also is sorted by priority of each object inside it
    private final int max;
    private final String doctorName;

    public BoundedPriorityQueue(int max, String doctorName) {
        this.max = max;
        this.doctorName = doctorName;
    }

    //Checks if the queue is full
    public boolean isFull(){
        return size() >= max;
    }

    public int count(){
        return super.size();
    }

    public Appointment poll(){
        if (isEmpty()){
            return null;
        }
        Appointment head = super.get(0);
        super.remove(0);
        return head;
    }

    public Appointment peek(){
        if (isEmpty()){
            throw new NullPointerException("Priority queue is empty");
        } else {
            return super.get(0);
        }
    }

    public boolean offer(Appointment toAdd){
        if (isFull() || !isValidAppointment(toAdd)){
            return false;
        }
        return add(toAdd);
    }

    public Appointment remove(){
        return super.remove(0);
    }

//    TODO - Check if algorithm for add() based on priority(triage) works correctly

    public boolean add(Appointment toAdd){
        if (!isValidAppointment(toAdd)){
            throw new IllegalArgumentException("Appointment to be added is for different doctor: " + toAdd.getDocName() + ". Doctor for the queue: " + doctorName);
        }

        if (isFull()){
            throw new IllegalArgumentException("Queue is full.");
        }


        Node current = head;
        int pos = 0;

        if (head.getData().compareTo(toAdd) <= 0){
            super.addToStart(toAdd);
        } else if (tail.getData().compareTo(toAdd) > 0) {
            super.add(toAdd);
        } else {
            while (current.getNext() != null) {
                if (current.getNext().getData().compareTo(toAdd) <= 0){
                    super.add(toAdd, pos);
                }
                pos++;
            }
        }
        return true;
    }

    /**
     * Internal helper method to check if doctor of the appointment to be added is the same as the doctor of the queue.
     * @param appointment Appointment to be added.
     * @return boolean indicating success of validation.
     */
    private boolean isValidAppointment(Appointment appointment){
        return appointment.getDocName().equalsIgnoreCase(doctorName);
    }
}
