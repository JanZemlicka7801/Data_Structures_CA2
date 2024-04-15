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

    public boolean isEmpty(){
        return size()==0;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    //add a single appointment
    //maybe should create a method that would add an appointment on the correct position
    public boolean add(Appointment toAdd){
        Node newNode = new Node(toAdd);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }

    //adds appointment to the start
    public boolean addToStart(Appointment toAdd){
        Node newNode = new Node(toAdd);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
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
