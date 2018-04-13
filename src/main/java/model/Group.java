package model;

import java.util.ArrayList;

public class Group {
    ArrayList<Person> group = new ArrayList<Person>();

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
}