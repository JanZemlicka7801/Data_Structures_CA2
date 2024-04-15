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
}
