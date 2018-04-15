package model;

import java.util.ArrayList;

public class Prank {

    private Person sender;
    private ArrayList<Person> victims;
    private ArrayList<Person> witnessesToCC;

    public String message;

    public Prank(Person sender, ArrayList<Person> victims, ArrayList<Person> witnessesToCC, String message){
        this.sender = sender;
        this.victims = victims;
        this.witnessesToCC = witnessesToCC;
        this.message = message;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public ArrayList<Person> getVictims() {
        return victims;
    }

    public void setVictims(ArrayList<Person> victims) {
        this.victims = victims;
    }

    public ArrayList<Person> getWitnessesToCC() {
        return witnessesToCC;
    }

    public void setWitnessesToCC(ArrayList<Person> witnessesToCC) {
        this.witnessesToCC = witnessesToCC;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
