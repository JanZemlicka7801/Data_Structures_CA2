package data;
import objects.Patient;

import java.util.LinkedList;

public class HashMap {
    /**
     * Default capacity of hashMap
     */
    private static final int DEFAULT_CAPACITY = 103;

    /**
     * HashMap (Array of Linked lists of Entry types)
     */
    private LinkedList<Entry>[] map;
    private int size;

    public HashMap(){
        map = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Returns total number of entries in a hashmap.
     * @return count of entries in a hashmap
     */
    public int size(){
        return size;
    }

//    TODO - check if works correctly and effective. (Optimize if space between hashes or collisions too big)

    /**
     * Calculates a slot(index) to store the entry in a hashMap.
     * @param key The key which is in result hashed and modded by the size of the array.
     * @return Integer representing slot(index).
     */
    private int calcSlot(String key){
        int slot = Math.abs(key.hashCode());
        slot %= map.length;
        return slot;
    }

    /**
     * Removes an entry from a hashMap.
     * @param key Key of the value to be removed.
     * @return A removed Patient or null if there is no matching Entry.
     */
    public Patient remove(String key){
        validateKey(key);
        int slot = calcSlot(key);
        Patient oldValue = null;

        if(map[slot] == null){
            return null;
        } else {
            for (Entry entry : map[slot]){
                if(key.equals(entry.getKey())){
                    oldValue = entry.getValue();
                    map[slot].remove(entry);
                }
            }
        }
        return oldValue;
    }

    /**
     * Gets a Patient from a hashMap.
     * @param key Key to access the value in a hashMap.
     * @return the found Patient or null if there is no Entry matching the specified key.
     */
    public Patient get(String key){
        validateKey(key);
        int slot = calcSlot(key);

        if(map[slot] == null){
            return null;
        } else {
            for (Entry entry : map[slot]){
                if(key.equals(entry.getKey())){
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Stores an entry in a hashMap. Puts a data in a hashMap with collision resolution(LinkedList).
     * @param key Key of the Entry.
     * @param value Value of the Entry.
     * @return Replaced Patient if the specified key was already in a hashMap, null if Entry was stored without replacing any values.
     */
//    TODO - Optimize and Check workability
    public Patient put(String key, Patient value){
//        First of all, validate key and value
        validateKey(key);
        validateValue(value);

//        1. Calculate index(slot) to insert K,V.
        int slot = calcSlot(key);


//        2. If List at that index(slot) wasn't initialized do so.
        if(map[slot] == null){
            map[slot] = new LinkedList<>();
        }


//        3. Iterate over the List to check if there's duplicate
        for(Entry entry : map[slot]){
            if(entry.getKey().equals(key)){
                Patient oldValue = entry.getValue();
//                if so - replace it with the specified value
                entry.updateValue(value);
//                and return old value(to see what was replaced) meaning found duplicate key
                return oldValue;
            }
        }
//        Otherwise - add Entry to the end of the List
        map[slot].add(new Entry(key, value));
//        Increment size
        size++;
//        and return null (meaning no duplicate key found)
        return null;
    }

    /**
     * Checks if there is a specified key in a hashMap.
     * @param key Key to search in a hashMap.
     * @return true if specified key is in a hashMap, false - otherwise.
     */
    public boolean containsKey(String key){
        validateKey(key);
        int slot = calcSlot(key);
        if(map[slot] == null){
            return false;
        }
        for(Entry entry : map[slot]){
            if(key.equals(entry.getKey())){
                return true;
            }
        }
        return false;
    }


    /**
     * Gets all the keys from a hashMap.
     * @return An array of all keys in a hashMap.
     */
    public String[] getKeys(){
//        Check if there are any entries in the hashmap
        if(size == 0){
            return null;
        }
//        Create new array with the size of total entries. Set index to 0 (helps iterate over the lists)
        String[] keys = new String[size];
        int index = 0;

        for(LinkedList<Entry> list : map){
            if(list != null){
                for(Entry entry : list){
                    keys[index] = entry.getKey();
                    index++;
                }
            }
        }
        return keys;
    }

    /**
     * Gets all the Patients from a hashMap.
     * @return An array of all Patients in a hashMap.
     */
    public Patient[] getValues(){
//        Check if there are any entries in the hashmap
        if(size == 0){
            return null;
        }
//        Create new array with the size of total entries. Set index to 0 (helps set the element to right position in array to be returned)
        Patient[] values = new Patient[size];
        int index = 0;

        for(LinkedList<Entry> list : map){
            if(list != null){
                for(Entry entry : list){
                    values[index] = entry.getValue();
                    index++;
                }
            }
        }
        return values;
    }


//    Helper methods

    /**
     * Helper method to validate keys.
     * @param key Key to validate.
     * @throws NullPointerException If the specified key is null.
     */
    public void validateKey(String key){
        if(key == null){
            throw new NullPointerException("Key can not be null");
        }
    }

    /**
     * Helper method to validate Values.
     * @param value Value to validate.
     * @throws NullPointerException If the specified value is null.
     */
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