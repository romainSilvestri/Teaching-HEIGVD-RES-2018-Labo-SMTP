/**
 * File: Group.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * This class manage the different group of people
 */


package model;

import java.util.ArrayList;

public class Group {
    ArrayList<Person> group = new ArrayList<Person>();

    public Group(){}

    public Group(Person... people){
        for(Person p : people){
            group.add(p);
        }
    }

    public void addToGroupe(Person... people){
        for(Person p : people){
            group.add(p);
        }
    }

    public ArrayList<Person> getGroup(){
        return group;
    }
}
