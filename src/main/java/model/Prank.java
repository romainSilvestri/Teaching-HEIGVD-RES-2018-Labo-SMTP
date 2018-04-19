/**
 * File: Prank.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * The prank object contains all the informations required for the prank.
 */

package model;

import java.util.ArrayList;

public class Prank {

    private Person sender;
    private ArrayList<Person> victims;
    private ArrayList<Person> witnessesToCC;

    private String message;

    public Prank(Person sender, ArrayList<Person> victims, ArrayList<Person> witnessesToCC, String message){
        this.sender = sender;
        this.victims = victims;
        this.witnessesToCC = witnessesToCC;
        this.message = message;
    }

    public Person getSender() {
        return sender;
    }

    public ArrayList<Person> getVictims() {
        return victims;
    }

    public ArrayList<Person> getWitnessesToCC() {
        return witnessesToCC;
    }

    public String getMessage() {
        return message;
    }

}
