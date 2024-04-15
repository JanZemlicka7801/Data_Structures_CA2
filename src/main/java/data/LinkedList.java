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

    public boolean add(Appointment toAdd, int pos){
        if(pos == 0){
            addToStart(toAdd);
        } else if (pos == size()) {
            add(toAdd);
        }else {
            Node newNode = new Node(toAdd);
            Node current = head;
            for (int i = 0; i < pos; i++) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(current.getNext());
            size++;
        }
        return true;
    }

    public Appointment remove(int pos){
        Appointment removed;
        if(pos == 0){
            removed = head.getData();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        }
        else {
            Node current = head;
            for(int i = 0; i < pos-1; i++) {
                current = current.getNext();
            }
            removed = current.getNext().getData();
            if (current.getNext() == tail)
            {
                tail = current;
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removed;
    }

    public int indexOf(Appointment appointment){
        Node current = head;
        for(int i = 0; i < size; i++){
            Appointment currentData = current.getData();
            if(currentData == appointment){
                return i;
            }
            current = current.getNext();
        }
        return -1;
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
