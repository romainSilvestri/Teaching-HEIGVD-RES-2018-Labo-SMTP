package model;

import java.util.ArrayList;

public class Message {

    String from;
    ArrayList<String> to;
    String subject;
    String message;

    public Message(String from, ArrayList<String> to, String subject, String message){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public String generateMessage(){
       // TODO: retourne la partie DATA du protocol smtp.
        return "aaa";
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public ArrayList<String> getTo() {
        return to;
    }

    public void setTo(ArrayList<String> to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
