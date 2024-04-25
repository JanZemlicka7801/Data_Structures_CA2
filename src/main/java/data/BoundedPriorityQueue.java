package data;

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
}
