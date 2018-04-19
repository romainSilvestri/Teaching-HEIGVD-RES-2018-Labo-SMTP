/**
 * File: Person.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * This class create and manage the differents people ( victims and witness)
 */
package model;

public class Person {
    String mail;

    public Person(String mail){
        this.mail = mail;
    }
    public String getMail(){
        return mail;
    }

}
