package data;

import objects.Appointment;

public class LinkedList {

    protected Node head;
    protected Node tail;
    protected int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Gets the size of a LinkedList.
     * @return size(number) of a List.
     */
    public int size(){
        return size;
    }

    /**
     * Checks if a List is empty.
     * @return true if a List is empty, false otherwise.
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     * Resets a List.
     */
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }


    //maybe should create a method that would add an appointment on the correct position
    /**
     * Adds Appointment to the end of a List.
     * @param toAdd Appointment to be added.
     * @return boolean indicating success of action.
     */
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


    /**
     * Adds Appointment to the start of a List.
     * @param toAdd Appointment to be added.
     * @return boolean indicating success of action.
     */
    public boolean addToStart(Appointment toAdd){
        Node newNode = new Node(toAdd);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
    }

    /**
     * Adds Appointment to the specified index(position).
     * @param toAdd Appointment to add.
     * @param pos position(index) to insert in/add to a List.
     * @return boolean indicating success of action.
     */
    public boolean add(Appointment toAdd, int pos){

//        Validate add position(index)
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException();
        }

        if(pos == 0){
            addToStart(toAdd);
        } else if (pos == size()) {
            add(toAdd);
        }else {
            Node newNode = new Node(toAdd);
            Node current = head;
            for (int i = 0; i < pos-1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
        return true;
    }

    /**
     * Removes Appointment from specified position(index).
     * @param pos position(index) to remove Appointment from.
     * @return removed Appointment.
     */
    public Appointment remove(int pos){

//        Validate remove position(index)
        validatePos(pos);

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

    /**
     * Returns position of a specified Appointment.
     * @param appointment Appointment to search in a List.
     * @return index of Appointment if it was found, -1 otherwise.
     */
    public int indexOf(Appointment appointment){
        Node current = head;
        for(int i = 0; i < size; i++){
            Appointment currentData = current.getData();
            if(currentData.equals(appointment)){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    /**
     * Gets an Appointment from specified index(position) of a List.
     * @param pos position(index) of Appointment.
     * @return found Appointment.
     */
    public Appointment get(int pos){

//        Validate position(index)
        validatePos(pos);

        Node current = head;
        for(int i = 0; i < pos; i++){
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Returns the last Appointment of the List.
     * @return null if the List is empty, appointment otherwise.
     */
    public Appointment tail(){
        if(tail == null){ //Same as empty list
            throw new IndexOutOfBoundsException("No data found in list");
        }
        return tail.getData();
    }

    /**
     * Internal helper method to validate position to get/remove element in a list
     * @param pos position of element to get/be removed
     */
    private void validatePos(int pos) {
        if(size == 0 || pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException();
        }
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
