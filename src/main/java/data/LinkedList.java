package data;

import objects.Appointment;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    protected static class Node{
        private Appointment data;
        private Node next;
        private Node previous;

        public Node(Appointment data){
            this.data = data;
            next = null;
            previous = null;
        }

        public Appointment getData() {
            return data;
        }

        public void setData(Appointment data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}
