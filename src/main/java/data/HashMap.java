package data;
import objects.Patient;

import java.util.LinkedList;

public class HashMap {

    private static final int DEFAULT_CAPACITY = 103;
    private LinkedList<Entry>[] map;
    private int size;

    public HashMap(){
        map = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size(){
        return size;
    }

//    TODO - check if works correctly and effective. (Optimize if space between hashes or collisions too big)
    private int calcSlot(String key){
        int slot = Math.abs(key.hashCode());
        slot %= map.length;
        return slot;
    }

    public Patient remove(String key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Patient get(String key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    TODO - Optimize and Check workability
    public Patient put(String key, Patient value){
//        First of all, validate key and value
        validateKey(key);
        validateValue(value);
//        Increment size (Arguments were validated, which means new entry will be added anyway)
        size++;


//        1. Calculate index(slot) to insert K,V.
        int slot = calcSlot(key);
        LinkedList<Entry> list = map[slot]; //Using 'list' for easier use further.

//        2. If List at that index(slot) wasn't initialized do so.
        if(map[slot] == null){
            list = new LinkedList<>();
        }


//        3. Iterate over the List to check if there's duplicate
        for(Entry entry : list){
            if(entry.getKey().equals(key)){
                Patient oldValue = entry.getValue();
//                if so - replace it with the specified value
                entry.updateValue(value);
//                and return old value(to see what was replaced) meaning found duplicate key
                return oldValue;
            }
        }
//        Otherwise - add Entry to the end of the List
        list.add(new Entry(key, value));
//        and return null (meaning no duplicate key found)
        return null;
    }


//    Helper methods
    public void validateKey(String key){
        if(key == null){
            throw new NullPointerException("Key can not be null");
        }
    }
    public void validateValue(Patient value){
        if(value == null){
            throw new NullPointerException("Value can not be null");
        }
    }







    private static class Entry{
//        Make key final to prevented change/modification of a key.
        private final String key;
        private Patient value;

        public Entry(String key, Patient value){
            if(key == null){
                throw new NullPointerException("Key can not be null");
            }
            this.key = key;
            this.value = value;
        }

//        TODO - Important! What type of variable(key) to use? Generic?
        /**
         * Gets a key of Entry.
         * @return key of this entry.
         */
        protected String getKey(){
            return key;
        }

        /**
         * Gets a value of Entry(Patient).
         * @return value of this entry.
         */
        protected Patient getValue(){
            return value;
        }

        /**
         * Updates the value of Entry(the one which calling the method) and returns the old one.
         * @param value new Patient.
         * @return replaced Patient.
         */
        public Patient updateValue(Patient value){
            Patient oldValue = this.value;
            this.value = value;
            return oldValue;
        }


    }
}