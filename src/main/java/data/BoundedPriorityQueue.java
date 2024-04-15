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
            return null;
        }
        return super.get(0);
    }

    public Appointment element(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        return super.get(0);
    }

    public Appointment remove(){
        return super.remove(0);
    }

    public boolean add(Appointment toAdd){
        if (!isValidAppointment(toAdd)){
            throw new IllegalArgumentException("objects.Appointment with " + toAdd.getDocName() + " is not possible to add.");
        }

        if (super.size() >= max){
            throw new IllegalArgumentException("Queue is full.");
        }

        return super.add(toAdd);
    }

    private boolean isValidAppointment(Appointment appointment){
        return appointment.getDocName().equalsIgnoreCase(doctorName);
    }
}
