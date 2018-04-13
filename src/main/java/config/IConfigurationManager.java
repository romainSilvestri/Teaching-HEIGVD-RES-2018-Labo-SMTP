package config;

import model.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface IConfigurationManager {

    ArrayList<Person> loadVictims(String filename) throws IOException;

    ArrayList<Person> getListVictims();

    ArrayList<String> loadMessages(String filename) throws IOException;

    ArrayList<String> getListMessages();

    ArrayList<Person> getwitnessesToCC();

    int getSmtpServerPort();

    int getNumberOfGroups();

    String getSmtpServerAdress();
}
