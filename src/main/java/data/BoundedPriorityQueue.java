package data;

import objects.Appointment;

public class BoundedPriorityQueue extends LinkedList{
    private final int max;
    private final String doctorName;

    public BoundedPriorityQueue(int max, String doctorName) {
        this.max = max;
        this.doctorName = doctorName;
    }

    /**
     * Checks if the queue is full. Checks if the queue has reached the maximum size of a set(maximum size is initialized in constructor).
     * @return boolean indicating if a queue is full.
     */
    public boolean isFull(){
        return super.size() == max;
    }

    /**
     * Gets the size of a queue.
     * @return size(number) of a queue.
     */
    public int count(){
        return super.size();
    }

    /**
     * Deletes and returns the first Appointment in a queue.
     * @return deleted Appointment.
     */
    public Appointment poll(){
        if (isEmpty()){
            return null;
        }
        return super.remove(0);
    }

    /**
     * Safe version of peek() method. Returns first element in a queue without deleting it OR null if a queue is empty.
     * @return first Task object in a queue, if it's not empty.
     */
    public Appointment element(){
        if (isEmpty()) {
            return null;
        }
        return super.get(0);
    }

    /**
     * "Get" method: returns first element in a queue without deleting it.
     * @return first Task object in a queue, if it's not empty.
     */
    public Appointment peek(){
        if (isEmpty()){
            throw new IllegalStateException("Priority queue is empty");
        } else {
            return super.get(0);
        }
    }
}
