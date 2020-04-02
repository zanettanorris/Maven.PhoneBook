package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private final Map <String, List<String>> phoneBook;
//^ making a map variable field for getter method and constructor test

    public PhoneBook(){
            this.phoneBook= new LinkedHashMap<>();
//            Map<String, List<String>> map) {
    }

    //makes the map in the parameter the map in the field.
    //pass reference of map Copy constructor
    public PhoneBook(Map <String, List <String>>map) {
        this.phoneBook = new LinkedHashMap<>(map);
    }

    public void add(String name, String phoneNumber) {
        //for map key name, put phoneNumber.
        List<String> phoneNumbers;
        if (phoneBook.containsKey(name)) {
            phoneNumbers = phoneBook.get(name);
        } else {
            phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        //for map key name, put all.
this.phoneBook.put(name, Arrays.asList(phoneNumbers));
}


    public void remove(String name) {
       this.phoneBook.remove(name);
        //for map key name, remove entry.

    }

    public Boolean hasEntry(String name) {
        if (phoneBook.containsKey(name)) {
            return true;
        } else {
            //reverse lookup method
            for (Map.Entry<String, List<String>> numbers :
                    phoneBook.entrySet()) {
                if (numbers.getValue().contains(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> lookup(String name) {
        //returns a phone number for the respective input name
        return this.phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        //returns a name for the respective input phoneNumber
        for (Map.Entry<String, List<String>> entry :
                this.phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        //returns a list of all names in this PhoneBook
        return new ArrayList<String>(phoneBook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.phoneBook;
    }


}
