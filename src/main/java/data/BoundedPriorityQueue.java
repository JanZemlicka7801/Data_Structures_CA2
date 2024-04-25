package data;

public class BoundedPriorityQueue {
    private final int max;
    private final String doctorName;

    public BoundedPriorityQueue(int max, String doctorName) {
        this.max = max;
        this.doctorName = doctorName;
    }
}
